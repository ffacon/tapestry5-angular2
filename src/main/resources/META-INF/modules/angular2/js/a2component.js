define([  ], function() {
    return function(moduleName,clientId, parameters) {
    	System.config({
    		packages: {
    			app: { 
    			  	format: 'register',
    			  	defaultExtension: 'js'
    		  	     }
    			}
    		});
    		System.import(moduleName).then(null, console.error.bind(console));
    };
});
