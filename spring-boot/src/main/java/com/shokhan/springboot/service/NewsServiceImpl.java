package com.shokhan.springboot.service;

import com.shokhan.springboot.model.News;
import com.shokhan.springboot.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> getOneById(int id) {
        return newsRepository.findById(id);
    }

    @Override
    @Transactional
    public News create(News news) {
        News _news = newsRepository.save(news);
        return _news;
    }

    @Override
    @Transactional
    public void update(int id, News news) {
        news.setId(id);
        newsRepository.save(news);
    }

    @Override
    @Transactional
    public void delete(int id) {
        newsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        newsRepository.deleteAll();
    }

    @Override
    public List<News> findByPublish(boolean b) {
        return newsRepository.findByPublished(b);
    }

    @Override
    public List<News> findByTitleCont(String title) {
        return null;
    }
}
