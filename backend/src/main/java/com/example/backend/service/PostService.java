package com.example.backend.service;

import com.example.backend.dto.PostRequestDTO;
import com.example.backend.dto.PostResponseDTO;
import com.example.backend.config.AuthFilter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final List<PostResponseDTO> posts = new ArrayList<>();

    public void savePost(PostRequestDTO request) {
        String authHeader = AuthFilter.getAuthHeader();
        posts.add(new PostResponseDTO(request.getTitle(), request.getBody(), authHeader));
    }

    public List<PostResponseDTO> getPosts() {
        return posts;
    }
}
