package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.SocialMediaProfiles;

@Repository
public interface SocialMediaProfilesDAO extends JpaRepository<SocialMediaProfiles, Integer>{

}
