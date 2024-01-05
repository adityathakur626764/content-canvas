package com.martian.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.martian.blog.payloads.LikeDislikeDto;
import com.martian.blog.services.LikeDislikeService;

@RestController
@RequestMapping("/api/likes-dislikes")
public class LikeDislikeController {

    @Autowired
    private LikeDislikeService likeDislikeService;
    
    //like or dislike the post
    @PostMapping("/user/{userId}/post/{postId}/bool/{isLike}/save")
    public ResponseEntity<?> saveLikeDislike(
    		@PathVariable("userId") int userId,
    		@PathVariable("postId") int postId,
    		@PathVariable("isLike") boolean isLike
    ) {
    	System.out.println("saveLikeDislike api called");
        try {
            likeDislikeService.saveLikeDislike(userId, postId, isLike);
            return ResponseEntity.ok("Like/Dislike saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to save Like/Dislike: " + e.getMessage());
        }
    }
    
    // get all likes count for a post
    @GetMapping("/likes-for-post/{postId}")
    public ResponseEntity<List<LikeDislikeDto>> getAllLikesForPost(@PathVariable("postId") int postId) {
        System.out.println("--------getAllLikesForPost called-----");
    	List<LikeDislikeDto> likes = likeDislikeService.getAllLikesForPost(postId);
        return ResponseEntity.ok(likes);
    }
}

