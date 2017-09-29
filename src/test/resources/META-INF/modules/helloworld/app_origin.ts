import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { Component } from "@angular/core";

@Component({
  selector: 'hello-world',
  template: `
  <div>
    Hello world
  </div>
  `
})
class HelloWorld {
}

platformBrowserDynamic().bootstrapModule(HelloWorld);
