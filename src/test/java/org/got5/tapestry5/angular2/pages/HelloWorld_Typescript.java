package org.got5.tapestry5.angular2.pages;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.InitializationPriority;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.got5.tapestry5.angular2.services.javascript.Angular2JavascriptStack;

import javax.inject.Inject;


public class HelloWorld_Typescript {

    @Inject
    private JavaScriptSupport javaScriptSupport;

	public JSONObject getParams(){
		JSONObject json =  new JSONObject();
		json.put("active_class", "open");// specify the class used for active sections
		json.put("is_hover",false);
        return json;
	}


    @AfterRender
    public void finish(MarkupWriter w){


    }
	
}
