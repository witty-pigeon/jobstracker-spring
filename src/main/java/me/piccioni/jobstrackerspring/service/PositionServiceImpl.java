package me.piccioni.jobstrackerspring.service;

import java.util.List;
import me.piccioni.jobstrackerspring.dao.PositionDao;
import me.piccioni.jobstrackerspring.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class PositionServiceImpl implements PositionManager{

  @Autowired
  private PositionDao positionDao;
  
  @Override
  @Transactional
  public List<Position> listPositions() {
    return positionDao.listPositions();
  }

  @Override
  @Transactional
  public long addPosition(Position pos) {
    return positionDao.addPosition(pos);
  }

  @Override
  @Transactional
  public Position getPosition(long id) {
    return positionDao.getPosition(id);
  }

  @Override
  @Transactional
  public void deletePosition(Position pos) {
    positionDao.deletePosition(pos);
  }

  @Override
  @Transactional
  public void updatePosition(Position pos) {
    positionDao.updatePosition(pos);
  }
  
}
