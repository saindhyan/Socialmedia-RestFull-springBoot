package com.social.api.socialapi.dao;

import com.social.api.socialapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface userJpaRepo extends JpaRepository<User,Integer> {

}
