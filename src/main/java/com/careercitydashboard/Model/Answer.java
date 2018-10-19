package com.careercitydashboard.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
	
	@Id
	private Integer ANSWER_ID;
	
	private Integer QUESTION_ID;
	
	private String ANSWER;

	public Integer getANSWER_ID() {
		return ANSWER_ID;
	}

	public void setANSWER_ID(Integer aNSWER_ID) {
		ANSWER_ID = aNSWER_ID;
	}

	public Integer getQUESTION_ID() {
		return QUESTION_ID;
	}

	public void setQUESTION_ID(Integer qUESTION_ID) {
		QUESTION_ID = qUESTION_ID;
	}

	public String getANSWER() {
		return ANSWER;
	}

	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	}

	@Override
	public String toString() {
		return "Answer [ANSWER_ID=" + ANSWER_ID + ", QUESTION_ID=" + QUESTION_ID + ", ANSWER=" + ANSWER + "]";
	}
	
	
}
