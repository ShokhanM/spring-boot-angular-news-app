package com.shokhan.springboot.repo;

import com.shokhan.springboot.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    List<News> findByPublished(boolean b);

}
