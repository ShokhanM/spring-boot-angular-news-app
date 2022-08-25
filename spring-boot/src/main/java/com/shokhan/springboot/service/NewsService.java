package com.shokhan.springboot.service;

import com.shokhan.springboot.model.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    List<News> getAll();
    Optional<News> getOneById(int id);
    News create(News news);
    void update(int id, News news);
    void delete(int id);
    void deleteAll();
    List<News> findByPublish(boolean b);
    List<News> findByTitleCont(String title);
}
