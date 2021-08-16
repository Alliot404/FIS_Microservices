package com.fis.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ormlearn.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
