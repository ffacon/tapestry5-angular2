package org.got5.tapestry5.angular2;

public enum A2Script {
	
	ZONE_JS("zone.js"),
	REFLECT_METADATA("reflect-metadata"),
	SYSTEM("system"),
	RX("rx"),
	A2_ANGULAR("@angular/core"),
	A2_HTTP("@angular/http"),
	A2_ROUTER("@angular/router"),
	A2_PLATFORM_BROWSER_DYNAMIC("@angular/platform-browser-dynamic");
	
    public final String text;

    /**
     * @param text
     */
    private A2Script(final String text) {
        this.text = text;
    }	
	

}
