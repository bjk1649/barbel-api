package com.example.barbel.service;

import com.example.barbel.dto.Post;
import com.example.barbel.repository.PostRepository;
import java.util.List;

public class PostService {

        private final PostRepository postRepository;

        public PostService(PostRepository postRepository) {
            this.postRepository = postRepository;
        }

        public List<Post> getPosts() {
            return postRepository.findAll();
        }

        public Post getPost(Long id) {
            return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        }

        public void savePost(Post post) {
            postRepository.save(post);
        }

        public void updatePost(Long id, Post post) {
            Post postEntity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
            postEntity.setTitle(post.getTitle());
            postEntity.setContent(post.getContent());
            postEntity.setLocation(post.getLocation());
            postEntity.setAuthor(post.getAuthor());
            postRepository.save(postEntity);
        }

        public void deletePost(Long id) {
            postRepository.deleteById(id);
        }
}
