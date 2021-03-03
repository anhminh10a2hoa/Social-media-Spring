package com.example.demo.repository;

import com.example.demo.model.Post;
import com.example.demo.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);
}
