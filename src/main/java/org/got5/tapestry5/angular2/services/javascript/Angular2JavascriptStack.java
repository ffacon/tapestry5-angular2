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
//// Copyright 2016 GOT5 (GO Tapestry 5)

package org.got5.tapestry5.angular2.services.javascript;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptAggregationStrategy;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Angular2JavascriptStack implements JavaScriptStack {

    public static final String STACK_ID = "Angular2Stack";

    private final boolean productionMode;
    
    private final AssetSource assetSource;
    
    private final Resource es6_shim; 
    private final Resource zoneJs;
    private final Resource reflectMetadata;
    private final Resource systemjs;
    private final Resource rx;
    private final Resource angular2;	

    public Angular2JavascriptStack(@Symbol(SymbolConstants.PRODUCTION_MODE)
                                   final boolean productionMode,
                                   @Path("webjars:es6-shim:es6-shim.js") final Resource es6_shim, 
                                   @Path("webjars:zone.js:$version/dist/zone.js") final Resource zoneJs,
                                   @Path("webjars:reflect-metadata:$version/Reflect.js") final Resource reflectMetadata,
                                   @Path("webjars:systemjs:dist/system.src.js") final Resource systemjs, 
                                   @Path("webjars:rxjs:bundles/Rx.js") final Resource rx,
                                   @Path("webjars:angular__core:$version/bundles/core.umd.js") final Resource angular2,	
                                   final AssetSource assetSource)
    {
        this.productionMode = productionMode;
        
        this.es6_shim = es6_shim; 
        this.zoneJs = zoneJs;
        this.reflectMetadata = reflectMetadata;
        this.systemjs = systemjs;
        this.rx = rx;
        this.angular2 = angular2;
        
        this.assetSource = assetSource;
      
    }

    public String getInitialization()
    {
        return productionMode ? null : "Tapestry.DEBUG_ENABLED = true;";
    }

    public List<Asset> getJavaScriptLibraries()
    {
    	final List<Asset> javaScriptStack = new ArrayList<Asset>();

    	javaScriptStack.add(assetSource.getUnlocalizedAsset(es6_shim.toString()));
    	javaScriptStack.add(assetSource.getUnlocalizedAsset(zoneJs.toString()));
        javaScriptStack.add(assetSource.getUnlocalizedAsset(reflectMetadata.toString()));
    	javaScriptStack.add(assetSource.getUnlocalizedAsset(systemjs.toString())); 
    	javaScriptStack.add(assetSource.getUnlocalizedAsset(rx.toString()));
    	javaScriptStack.add(assetSource.getUnlocalizedAsset(angular2.toString())); 
        
        return javaScriptStack;
    }

    public List<StylesheetLink> getStylesheets()
    {
        return Collections.emptyList();
    }

    public List<String> getModules() {
        return Collections.emptyList();
    }

    public JavaScriptAggregationStrategy getJavaScriptAggregationStrategy() {
    	return org.apache.tapestry5.services.javascript.JavaScriptAggregationStrategy.COMBINE_AND_MINIMIZE;
    }

    public List<String> getStacks()
    {
        return Collections.emptyList();
    }

}