package com.social.api.socialapi.dao;

import com.social.api.socialapi.entity.Post;
import com.social.api.socialapi.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cm2JpaRepo extends JpaRepository<Reply,Integer> {
}
