import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddNewsComponent } from './components/add-news/add-news.component';
import { NewsDetailsComponent } from './components/news-details/news-details.component';
import { NewsListComponent } from './components/news-list/news-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddNewsComponent,
    NewsDetailsComponent,
    NewsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
