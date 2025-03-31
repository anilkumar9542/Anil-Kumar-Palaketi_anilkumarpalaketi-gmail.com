package com.example.backend.controller;

import com.example.backend.dto.PostRequestDTO;
import com.example.backend.dto.PostResponseDTO;
import com.example.backend.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("post")
    public ResponseEntity<String> createPost(@RequestBody PostRequestDTO request) {
        postService.savePost(request);
        return ResponseEntity.ok("Post saved successfully");
    }

    @GetMapping("list")
    public ResponseEntity<List<PostResponseDTO>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }
}
