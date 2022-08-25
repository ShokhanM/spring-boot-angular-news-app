import { Component, OnInit } from '@angular/core';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent implements OnInit {

  news: any;
  currentNews = null;
  currentIndex = -1;
  title = '';

  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.retrieveNews();
  }

  retrieveNews() {
    this.newsService.getAll()
      .subscribe(
        data => {
          this.news = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList() {
    this.retrieveNews();
    this.currentNews = null;
    this.currentIndex = -1;
  }

  setActiveNews(news, index) {
    this.currentNews = news;
    this.currentIndex = index;
  }

  removeAllNews() {
    this.newsService.deleteAll()
      .subscribe(
        response => {
          console.log(response);
          this.refreshList();
        },
        error => {
          console.log(error);
        });
  }

  searchTitle() {
    this.newsService.findByTitle(this.title)
      .subscribe(
        data => {
          this.news = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
