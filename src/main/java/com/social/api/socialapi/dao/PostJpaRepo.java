package com.social.api.socialapi.dao;

import com.social.api.socialapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepo extends JpaRepository<Post,Integer> {
}
