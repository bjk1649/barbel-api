package com.example.barbel.repository;


import com.example.barbel.dto.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findAll();

    Post save(Post post);
    void deleteById(Long id);

    Optional<Post> findById(Long id);
}

