//
// Copyright 2016 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.got5.tapestry5.angular2.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.internal.webresources.CacheMode;
import org.apache.tapestry5.internal.webresources.ResourceTransformerFactory;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.ioc.annotations.Autobuild;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.ioc.services.FactoryDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.assets.ResourceTransformer;
import org.apache.tapestry5.services.assets.StreamableResourceSource;
import org.apache.tapestry5.services.javascript.JavaScriptModuleConfiguration;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.ModuleManager;
import org.got5.tapestry5.angular2.services.compiler.TSCompiler;
import org.got5.tapestry5.angular2.services.javascript.Angular2JavascriptStack;

public class Angular2Module {

	public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration) 
	{
		configuration.add(new LibraryMapping("angular2","org.got5.tapestry5.angular2"));
	}

	
	public static void contributeClasspathAssetAliasManager(MappedConfiguration<String, String> configuration) 
	{
		configuration.add("tapestry5-angular2", "META-INF/modules/angular2");
	}

	
	 @Contribute(SymbolProvider.class)
	 @FactoryDefaults
	 public static void setupSymbols(MappedConfiguration<String, Object> configuration)
	 {
	 
		 	configuration.add("angular2.assets.root", "classpath:META-INF/modules");
		 
	        configuration.add(Angular2SymbolConstants.ANGULAR2_ROOT, "${angular2.assets.root}/angular2");
	       
	 }

     public static void contributeJavaScriptStackSource(MappedConfiguration<String, JavaScriptStack> configuration)
     {
    	 	configuration.addInstance(Angular2JavascriptStack.STACK_ID, Angular2JavascriptStack.class);
     }
     
     
     @Contribute(ModuleManager.class)
     public static void setupJSModules(final MappedConfiguration<String, JavaScriptModuleConfiguration> configuration,
         @Path("webjars:es6-shim:es6-shim.js") final Resource es6_shim, 
         @Path("webjars:angular2:bundles/angular2-polyfills.js") final Resource angular2_polyfills,
         @Path("webjars:systemjs:dist/system.src.js") final Resource systemjs, 
         @Path("webjars:rxjs:bundles/Rx.js") final Resource rx,
         @Path("webjars:angular2:bundles/angular2.dev.js") final Resource angular2_dev,
         @Path("webjars:typescript:lib/tsc.js") final Resource tsc,
         @Symbol(SymbolConstants.PRODUCTION_MODE) final boolean productionMode) {

       configuration.add("es6-shim", new JavaScriptModuleConfiguration(es6_shim));
       configuration.add("angular2-polyfills", new JavaScriptModuleConfiguration(angular2_polyfills));
       configuration.add("system", new JavaScriptModuleConfiguration(systemjs));
       configuration.add("rx", new JavaScriptModuleConfiguration(rx));
       configuration.add("angular2.dev", new JavaScriptModuleConfiguration(angular2_dev));
       
       configuration.add("tsc", new JavaScriptModuleConfiguration(tsc));
       
       
     }
     
     @Contribute(StreamableResourceSource.class)
     public static void provideCompilers(final MappedConfiguration<String, ResourceTransformer> configuration,
         final ResourceTransformerFactory factory, @Autobuild final TSCompiler tsCompiler) {
       // contribution ids are file extensions:

        configuration.add("ts",
           factory.createCompiler("text/javascript", "TS", "JavaScript", tsCompiler, CacheMode.SINGLE_FILE));

     }
	
	
}
