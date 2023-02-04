package com.example.barbel.controller;

import com.example.barbel.dto.Post;
import com.example.barbel.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/post/save")
    public String postSave() {
        return "post-save";
    }

    @PostMapping("/post/save")
    public String postSave(Post post) {
        postService.savePost(post);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String postDetail(@PathVariable Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post-detail";
    }

    @GetMapping("/post/{id}/edit")
    public String postEdit(@PathVariable Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post-edit";
    }

    @PostMapping("/post/{id}/edit")
    public String postEdit(@PathVariable Long id, Post post) {
        postService.updatePost(id, post);
        return "redirect:/";
    }

    @GetMapping("/post/{id}/delete")
    public String postDelete(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}