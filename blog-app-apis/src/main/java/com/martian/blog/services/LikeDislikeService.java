package com.martian.blog.services;

import java.util.List;

import com.martian.blog.entities.User;
import com.martian.blog.payloads.LikeDislikeDto;


public interface LikeDislikeService {

    void saveLikeDislike(int userId,int postId,boolean isLike);

    void unsaveLikeDislike(Long likeDislikeId);

    List<LikeDislikeDto> getAllLikesAndDislikesForPost(Long postId);

    List<LikeDislikeDto> getAllLikesForPost(int postId);

    List<LikeDislikeDto> getAllDislikesForPost(int postId);

//    LikeDislikeDto findLikeDislikeById(Long likeDislikeId);
//
//    LikeDislikeDto findByUserAndPost(User user, Post post);

}

