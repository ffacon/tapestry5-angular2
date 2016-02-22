package org.got5.tapestry5.angular2.services.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.apache.tapestry5.ContentType;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.internal.InternalConstants;
import org.apache.tapestry5.internal.webresources.RhinoExecutor;
import org.apache.tapestry5.internal.webresources.RhinoExecutorPool;
import org.apache.tapestry5.ioc.OperationTracker;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.ioc.internal.util.ClasspathResource;
import org.apache.tapestry5.ioc.internal.util.InternalUtils;
import org.apache.tapestry5.services.assets.ResourceDependencies;
import org.apache.tapestry5.services.assets.ResourceTransformer;
import org.mozilla.javascript.NativeObject;


public class TSCompiler implements ResourceTransformer {
  private final static Charset UTF8 = StandardCharsets.UTF_8;

  private final RhinoExecutorPool executorPool;

  private final boolean useColoredOutput;
  
  private final OperationTracker tracker;
  
  private final Resource typescript;


  public ContentType getTransformedContentType() {
    return InternalConstants.JAVASCRIPT_CONTENT_TYPE;
  }

  public TSCompiler(final OperationTracker tracker,
      @Path("webjars:typescript:lib/typescript.js") final Resource typescript) {
	  this.typescript = typescript;
	  this.tracker = tracker;  
      this.useColoredOutput = Boolean.TRUE;
      this.executorPool = new RhinoExecutorPool(tracker, Arrays.<Resource> asList(typescript,new ClasspathResource("org/got5/tapestry5/angular2/services/typescriptCompile.js")));

  }

  private static String getString(final NativeObject object, final String key) {
    return object.get(key).toString();
  }


  public InputStream transform(final Resource source, final ResourceDependencies dependencies) throws IOException {
    InputStream is = null;
    String content;

  
    
    try {
      is = source.openStream();
      content = IOUtils.toString(is, UTF8);
    } finally {
      InternalUtils.close(is);
    }
   
    RhinoExecutor executor = executorPool.get();

    String fileName = source.getFile();
    if (fileName != null && fileName.endsWith(".ts")) {
    }

    try {

      NativeObject result = (NativeObject) executor.invokeFunction("transpile", content, source.toString(),
          "{noEmitOnError: true, noImplicitAny: true,target: ts.ScriptTarget.ES6, module: ts.ModuleKind.CommonJS}");

      if (result.containsKey("exception")) {
        throw new RuntimeException(getString(result, "exception"));
      }

      return IOUtils.toInputStream(getString(result, "output"), UTF8);

    } finally {
      executor.discard();
    }

  }
}
