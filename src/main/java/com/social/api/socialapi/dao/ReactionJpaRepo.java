package com.social.api.socialapi.dao;

import com.social.api.socialapi.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionJpaRepo extends JpaRepository<Reaction,Integer> {
}
