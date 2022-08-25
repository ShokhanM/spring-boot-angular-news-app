package com.shokhan.springboot.controller;


import com.shokhan.springboot.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shokhan.springboot.service.NewsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public ResponseEntity<List<News>> getAllNews(@RequestParam(required = false) String title) {
        try {
            List<News> news = new ArrayList<>();
            if (title == null) {
                newsService.getAll().forEach(news::add);
            } else {
                newsService.findByTitleCont(title).forEach(news::add);
            }

            if (news.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(news, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<News> getOne(@PathVariable("id") int id) {
        Optional<News> newsOptional = newsService.getOneById(id);
        if (newsOptional.isPresent()) {
            return new ResponseEntity<>(newsOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/news")
    public ResponseEntity<News> createNews(@RequestBody News news) {
        try {
            News _news = newsService.create(new News(news.getTitle(), news.getDescription(), false));
            return new ResponseEntity<>(_news, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/news/{id}")
    public ResponseEntity<News> updateNews(@PathVariable("id") int id, @RequestBody News news) {

        Optional<News> newsOptional = newsService.getOneById(id);
        if (newsOptional.isPresent()) {
            newsService.update(id, news);
            return new ResponseEntity<>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/news/id")
    public ResponseEntity<HttpStatus> deleteNews(@PathVariable("id") int id) {
        try {
            newsService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/news")
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            newsService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/news/published")
    public ResponseEntity<List<News>> getByPublished() {
        try {
            List<News> news = newsService.findByPublish(true);

            if (news.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(news, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

