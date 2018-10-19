package com.careercitydashboard.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careercitydashboard.Model.Answer;

@Repository
public interface  AnswerRepo extends JpaRepository<Answer , Integer> {

}
