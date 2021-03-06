package me.piccioni.jobstrackerspring.dao;

import java.util.List;
import me.piccioni.jobstrackerspring.model.Position;

/**
 *
 */
public interface PositionDao {

  public List<Position> listPositions();
  public long addPosition(Position pos);
  public Position getPosition(long id);
  public void deletePosition(Position pos);
  public void updatePosition(Position pos);

}
