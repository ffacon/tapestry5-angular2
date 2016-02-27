//
// Copyright 2015 GOT5 (GO Tapestry 5)
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
import org.apache.tapestry5.internal.webresources.CacheMode;
import org.apache.tapestry5.internal.webresources.ResourceTransformerFactory;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.ImportModule;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.compatibility.Compatibility;
import org.apache.tapestry5.services.compatibility.Trait;


@ImportModule(value = Angular2Module.class)
public class AppModule
{	
	@Contribute(SymbolProvider.class)
	@ApplicationDefaults
    public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration)
    {
    	
    	
    	configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de,ru,ua");
    	
    	configuration.add(SymbolConstants.PRODUCTION_MODE, false);
    	
    	configuration.add(SymbolConstants.COMBINE_SCRIPTS, false);
    	
    	configuration.add(SymbolConstants.COMPRESS_WHITESPACE, false);
        
    	configuration.add(SymbolConstants.GZIP_COMPRESSION_ENABLED, false);
    	
    	configuration.add("demo-src-dir", "");
    	
    	configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");

     }
    
    
    public static void contributeClasspathAssetAliasManager(MappedConfiguration<String, String> configuration)
    {
        configuration.add("demo-css", "static/css");
        configuration.add("demo-js", "META-INF/modules/demo");
    }

    
    @Contribute(Compatibility.class)
	public static void disableBackwardsCompatibleFeatures(MappedConfiguration<Trait, Boolean> configuration){
	        configuration.add(Trait.INITIALIZERS, false);
	}

    
   
	
}
