import { Component, OnInit } from '@angular/core';
import { NewsService } from 'src/app/services/news.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit {
  currentNews = null;
  message = '';

  constructor(
    private newsService: NewsService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.message = '';
    this.getNews(this.route.snapshot.paramMap.get('id'));
  }

  getNews(id) {
    this.newsService.get(id)
      .subscribe(
        data => {
          this.currentNews = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updatePublished(status) {
    const data = {
      title: this.currentNews.title,
      description: this.currentNews.description,
      published: status
    };

    this.newsService.update(this.currentNews.id, data)
      .subscribe(
        response => {
          this.currentNews.published = status;
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

  updateNews() {
    this.newsService.update(this.currentNews.id, this.currentNews)
      .subscribe(
        response => {
          console.log(response);
          this.message = 'The news was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteNews() {
    this.newsService.delete(this.currentNews.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/news']);
        },
        error => {
          console.log(error);
        });
  }
}
