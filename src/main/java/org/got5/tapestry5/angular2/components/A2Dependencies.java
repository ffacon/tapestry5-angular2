package org.got5.tapestry5.angular2.components;

import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.ModuleManager;
import org.slf4j.Logger;

public class A2Dependencies {
	
	 @Inject
	 private ModuleManager moduleManager;
	 
	 @Inject
	 private AssetSource assetSource;
	
	 @Inject
	 private ComponentResources resources;
	 
	 @Inject
	 private Logger logger;
	  
	 @Parameter
	 private List<String> scriptList;
	 
	 public boolean isListEmpty(){
		 if(resources.isBound("scriptList") && !scriptList.isEmpty())
			 return false;
		 else
			 return true;
		 
	 }
	 
	 @AfterRender
	 void after(MarkupWriter writer){
		 Resource res;
		 Asset asset;
		 if(!isListEmpty())
		 {
			 for (String script : scriptList){
				 try{
				 res=moduleManager.findResourceForModule(script);
				 asset=assetSource.getUnlocalizedAsset(res.toString());
				 String url = asset.toClientURL();
				 writer.element("script", "type", "text/javascript", "src", url);
				 writer.end();}
				 catch(Exception ex)
				 {
					  logger.error("Script not found:"+ ex.getMessage());
				 }
			 }
		 }
		 
	 }

}
