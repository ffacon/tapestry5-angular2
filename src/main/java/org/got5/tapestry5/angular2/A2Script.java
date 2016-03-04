package org.got5.tapestry5.angular2;

public enum A2Script {
	
	A2_POLYFILLS("angular2-polyfills"),
	SYSTEM("system"),
	RX("rx"),
	A2_ANGULAR("angular"),
	A2_HTTP("http"),
	A2_ROUTER("router");
	
    public final String text;

    /**
     * @param text
     */
    private A2Script(final String text) {
        this.text = text;
    }	
	

}
