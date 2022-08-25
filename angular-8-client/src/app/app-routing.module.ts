import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewsListComponent } from './components/news-list/news-list.component';
import { AddNewsComponent } from './components/add-news/add-news.component';
import {NewsDetailsComponent} from './components/news-details/news-details.component';

const routes: Routes = [
  { path: '', redirectTo: 'news', pathMatch: 'full' },
  { path: 'news', component: NewsListComponent },
  { path: 'news/:id', component: NewsDetailsComponent },
  { path: 'add', component: AddNewsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
