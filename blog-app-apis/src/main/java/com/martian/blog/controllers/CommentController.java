package com.martian.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martian.blog.payloads.ApiResponse;
import com.martian.blog.payloads.CommentDto;
import com.martian.blog.services.CommentService;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId) {
//		System.out.println("createComment called------");
		CommentDto createComment = this.commentService.createComment(comment, postId);
//		System.out.println("commentid: "+createComment.getId()+" content: "+createComment.getContent());
		return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
	}

	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {

		this.commentService.deleteComment(commentId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully !!", true), HttpStatus.OK);
	}

}
