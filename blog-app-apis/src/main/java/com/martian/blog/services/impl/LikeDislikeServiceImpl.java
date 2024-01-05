package com.martian.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martian.blog.entities.LikeDislike;
import com.martian.blog.entities.Post;
import com.martian.blog.entities.User;
import com.martian.blog.exceptions.ResourceNotFoundException;
import com.martian.blog.payloads.LikeDislikeDto;
import com.martian.blog.repositories.LikeDislikeRepo;
import com.martian.blog.repositories.PostRepo;
import com.martian.blog.repositories.UserRepo;
import com.martian.blog.services.LikeDislikeService;

@Service
public class LikeDislikeServiceImpl implements LikeDislikeService{
	@Autowired
	private LikeDislikeRepo likeDislikeRepo;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
		
	

	@Override
	public void saveLikeDislike(int userId,int postId,boolean isLike) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", " Id ", postId));
		
		LikeDislike likeDislike = new LikeDislike();
		likeDislike.setLike(isLike);
		likeDislike.setUser(user);
		likeDislike.setPost(post);
		likeDislikeRepo.save(likeDislike);	
		
	}

	@Override
	public void unsaveLikeDislike(Long likeDislikeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LikeDislikeDto> getAllLikesAndDislikesForPost(Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
    public List<LikeDislikeDto> getAllLikesForPost(int postId) {
        List<LikeDislike> likes = likeDislikeRepo.findAllLikesForPost(postId);

        // Map the LikeDislike entities to DTOs
        List<LikeDislikeDto> likeDislikeDtos = likes.stream()
            .map(this::mapToLikeDislikeDto)
            .collect(Collectors.toList());

        return likeDislikeDtos;
    }


	@Override
	public List<LikeDislikeDto> getAllDislikesForPost(int postId) {
		 List<LikeDislike> dislikes = likeDislikeRepo.findAllDislikesForPost(postId);

	        // Map the LikeDislike entities to DTOs
	        List<LikeDislikeDto> likeDislikeDtos = dislikes.stream()
	            .map(this::mapToLikeDislikeDto)
	            .collect(Collectors.toList());

	        return likeDislikeDtos;
	}
	
	private LikeDislikeDto mapToLikeDislikeDto(LikeDislike likeDislike) {
        LikeDislikeDto likeDislikeDto = new LikeDislikeDto();
//        likeDislikeDto.getUser().setId(likeDislike.getUser().getId());
//        likeDislikeDto.getPost().setPostId(likeDislike.getPost().getPostId());
        likeDislikeDto.setUser(likeDislike.getUser());
        likeDislikeDto.setPost(likeDislike.getPost());
        
        likeDislikeDto.setLike(likeDislike.isLike());

        return likeDislikeDto;
    }
	
}
