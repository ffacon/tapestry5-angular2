package org.got5.tapestry5.angular2.pages;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.json.JSONObject;


public class HelloWorld_A2Component {

 
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
