package com.careercitydashboard.ServiceImpl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.careercitydashboard.Dao.PositionRepo;
import com.careercitydashboard.Model.Position;
import com.careercitydashboard.Service.PositionService;


@Service
@Transactional
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	private PositionRepo positionRepo;

	@Override
	public List<Position> getallPositions() {
		return (List<Position>) this.positionRepo.findAll();
		
	}

	@Override
	public Position getpositonbyId(Integer Id) {
		
		return this.positionRepo.findById(Id).get();
	}

	@Override
	public Position savePosition(Position position) {
		
		return this.positionRepo.save(position);
	}

	@Override
	public Position updatePosition(Position position) {
		Position updatedPosition = getpositonbyId(position.getPOSITION_ID());
		updatedPosition.setJOB_PROFILE(position.getJOB_PROFILE());
		updatedPosition.setDEPARTMENT(position.getDEPARTMENT());
		updatedPosition.setIMAGE_PATH(position.getIMAGE_PATH());
		updatedPosition.setSUPPORT_TYPE(position.getSUPPORT_TYPE());
		updatedPosition.setEDUCATIONAL_BACKGROUND(position.getEDUCATIONAL_BACKGROUND());
		updatedPosition.setEXPERIENCE_REQUIRED(position.getEXPERIENCE_REQUIRED());
		updatedPosition.setDESCRIPTION(position.getDESCRIPTION());
		updatedPosition.setSKILLS_REQUIRED(position.getSKILLS_REQUIRED());
		updatedPosition.setCERTIFICATION(position.getCERTIFICATION());
		updatedPosition.setOTHER_SKILLS(position.getOTHER_SKILLS());
		updatedPosition.setTRAININGS(position.getTRAININGS());
		updatedPosition.setCREATED_BY(position.getCREATED_BY());
		
		// TODO Auto-generated method stub
		return this.positionRepo.save(updatedPosition);
	}

	@Override
	public Position getPositionMapping(Integer POSITION_ID) {
		// TODO Auto-generated method stub
		Position position=this.positionRepo.findById(POSITION_ID).get();
		Hibernate.initialize(position.getPositionAnswers().size());
		return position;
	}

}
