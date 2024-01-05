package com.martian.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.martian.blog.entities.LikeDislike;

public interface LikeDislikeRepo extends JpaRepository<LikeDislike, Integer> {
	
	// fetch all likes for a post
	@Query("SELECT ld FROM LikeDislike ld WHERE ld.post.id = :postId AND ld.isLike = true")
    List<LikeDislike> findAllLikesForPost(int postId);
	
	// fetch all disLikes for a post
	 @Query("SELECT ld FROM LikeDislike ld WHERE ld.post.id = :postId AND ld.isLike = false")
	 List<LikeDislike> findAllDislikesForPost(int postId);
}
