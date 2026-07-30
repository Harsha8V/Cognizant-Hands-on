import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app'; // <-- Change 'App' to 'AppComponent'

bootstrapApplication(AppComponent, appConfig) // <-- Change 'App' to 'AppComponent' here too
  .catch((err) => console.error(err));
