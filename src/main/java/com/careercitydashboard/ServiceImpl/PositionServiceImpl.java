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
		
		this.positionRepo.findById(Id);
		return null;
	}

	@Override
	public Position savePosition(Position position) {
		
		return this.positionRepo.save(position);
	}

	@Override
	public Position updatePosition(Position position) {
		// TODO Auto-generated method stub
		return this.positionRepo.save(position);
	}

	@Override
	public Position getPositionMapping(Integer POSITION_ID) {
		// TODO Auto-generated method stub
		Position position=this.positionRepo.findById(POSITION_ID).get();
		Hibernate.initialize(position.getPositionAnswers().size());
		return position;
	}

}
