package com.careercitydashboard.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="position")
public class Position {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer POSITION_ID;
	
	private String DEPARTMENT;
	
	private String SUPPORT_TYPE;
	
	private String JOB_PROFILE;
	
	private String DESCRIPTION;
	
	private String CERTIFICATION;
	
	private String EDUCATIONAL_BACKGROUND;
	
	private String EXPERIENCE_REQUIRED;
	
	private String SKILLS_REQUIRED;
	
	private String OTHER_SKILLS;
	
	private String CATEGORY;
	
	private String IMAGE_PATH;
	
	private String TRAININGS;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="POSITION_ID")
	private List<PositionAnswers> positionAnswers;
	
	

	public Integer getPOSITION_ID() {
		return POSITION_ID;
	}

	public void setPOSITION_ID(Integer pOSITION_ID) {
		POSITION_ID = pOSITION_ID;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

	public String getSUPPORT_TYPE() {
		return SUPPORT_TYPE;
	}

	public void setSUPPORT_TYPE(String sUPPORT_TYPE) {
		SUPPORT_TYPE = sUPPORT_TYPE;
	}

	public String getJOB_PROFILE() {
		return JOB_PROFILE;
	}

	public void setJOB_PROFILE(String jOB_PROFILE) {
		JOB_PROFILE = jOB_PROFILE;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public String getCERTIFICATION() {
		return CERTIFICATION;
	}

	public void setCERTIFICATION(String cERTIFICATION) {
		CERTIFICATION = cERTIFICATION;
	}

	public String getEDUCATIONAL_BACKGROUND() {
		return EDUCATIONAL_BACKGROUND;
	}

	public void setEDUCATIONAL_BACKGROUND(String eDUCATIONAL_BACKGROUND) {
		EDUCATIONAL_BACKGROUND = eDUCATIONAL_BACKGROUND;
	}

	public String getEXPERIENCE_REQUIRED() {
		return EXPERIENCE_REQUIRED;
	}

	public void setEXPERIENCE_REQUIRED(String eXPERIENCE_REQUIRED) {
		EXPERIENCE_REQUIRED = eXPERIENCE_REQUIRED;
	}

	public String getSKILLS_REQUIRED() {
		return SKILLS_REQUIRED;
	}

	public void setSKILLS_REQUIRED(String sKILLS_REQUIRED) {
		SKILLS_REQUIRED = sKILLS_REQUIRED;
	}

	public String getOTHER_SKILLS() {
		return OTHER_SKILLS;
	}

	public void setOTHER_SKILLS(String oTHER_SKILLS) {
		OTHER_SKILLS = oTHER_SKILLS;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getIMAGE_PATH() {
		return IMAGE_PATH;
	}

	public void setIMAGE_PATH(String iMAGE_PATH) {
		IMAGE_PATH = iMAGE_PATH;
	}

	public String getTRAININGS() {
		return TRAININGS;
	}

	public void setTRAININGS(String tRAININGS) {
		TRAININGS = tRAININGS;
	}
	
	

	public List<PositionAnswers> getPositionAnswers() {
		return positionAnswers;
	}

	public void setPositionAnswers(List<PositionAnswers> positionAnswers) {
		this.positionAnswers = positionAnswers;
	}

	@Override
	public String toString() {
		return "Position [POSITION_ID=" + POSITION_ID + ", DEPARTMENT=" + DEPARTMENT + ", SUPPORT_TYPE=" + SUPPORT_TYPE
				+ ", JOB_PROFILE=" + JOB_PROFILE + ", DESCRIPTION=" + DESCRIPTION + ", CERTIFICATION=" + CERTIFICATION
				+ ", EDUCATIONAL_BACKGROUND=" + EDUCATIONAL_BACKGROUND + ", EXPERIENCE_REQUIRED=" + EXPERIENCE_REQUIRED
				+ ", SKILLS_REQUIRED=" + SKILLS_REQUIRED + ", OTHER_SKILLS=" + OTHER_SKILLS + ", CATEGORY=" + CATEGORY
				+ ", IMAGE_PATH=" + IMAGE_PATH + ", TRAININGS=" + TRAININGS + ", positionAnswers=" + positionAnswers
				+ "]";
	}
	
	

}
