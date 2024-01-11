package com.social.api.socialapi.dao;

import com.social.api.socialapi.entity.Comment;
import com.social.api.socialapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepo extends JpaRepository<Comment,Integer> {
}
