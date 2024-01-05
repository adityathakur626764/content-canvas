package com.martian.blog.payloads;

import com.martian.blog.entities.Post;
import com.martian.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LikeDislikeDto {
	private int id;

    private User user;

    private Post post;

    private boolean isLike;
}
