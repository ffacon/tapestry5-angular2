# Angular 2 integration Module for Tapestry 5

 This module provides Angular 2 integration for Tapestry 5. 

##Questions? Ideas? Comments?
All kind of feedback is very welcome. Please use [Github issues system](http://github.com/ffacon/tapestry5-angular2/issues) for that.

## How to use it

Just  add the following dependency in your `pom.xml`.

For Tapestry 5.4 users:

	<dependencies>
		...
		<dependency>
			<groupId>org.got5</groupId>
			<artifactId>tapestry5-angular2</artifactId>
			<version>0.1.0-beta-17</version>
		</dependency>
		...
	</dependencies>

	<repositories>
		...
		<repository>
          		<id>central</id>
          		<url>https://repo1.maven.org/maven2</url>
          		<releases>
            			<enabled>true</enabled>
          		</releases>
        	</repository>

		<repository>
			<id>oss—sonatype-snapshot-repo</id>
			<url>https://oss.sonatype.org/content/repositories/snapshots
			</url>
			<releases>
				<enabled>false</enabled>
			</releases>
		</repository>
		...
	</repositories>


In order to add scripts required by Angular 2, you can add A2Dependencies component in your page or layout.
 
	<html xmlns:t="http://tapestry.apache.org/schema/tapestry_5_4.xsd" 
		xmlns:p="tapestry:parameter"
		xmlns:a2="tapestry-library:angular2">
	<head>
		...	
		<a2:A2Dependencies />
	</head>

You are now ready to start you Angular 2 application.

	<script>
	System.config({
	packages: {
		app: {
			format: 'register',
			defaultExtension: 'js' 
			}
			
	}
	});
	System.import('modules/helloworld/app.js')
		.then(null, console.error.bind(console));
	</script>

<hello-world  > </hello-world>


##Changelog related to Tapestry 5.4.x branch
** 0.1.0-beta-17 : Update to use Angular 2 beta-17
** 0.1.0-beta-2 : Update to Tapestry 5.4.1 with Angular 2 beta-2

## Demo 
the test application can be examined by running mvn jetty:run and pointing your browser to http://localhost:8080/.
see also https://github.com/ffacon/tapestry5-angular2-demo

## License
This project is distributed under Apache 2 License. See LICENSE.txt for more information. 
