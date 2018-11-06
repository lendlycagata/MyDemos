package com.careercitydashboard.Service;

import java.util.List;

import com.careercitydashboard.Model.Position;

public interface PositionService {
	
	public List<Position> getallPositions();
	public Position getpositonbyId(Integer Id);
	public Position savePosition(Position position);
	public Position updatePosition(Position position);
	
	public Position getPositionMapping(Integer POSITION_ID);
	
}
