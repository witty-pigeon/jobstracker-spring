package me.piccioni.jobstrackerspring.dao;

import java.util.List;
import me.piccioni.jobstrackerspring.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class PositionDaoImpl implements PositionDao{

  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  public List<Position> listPositions() {
    Session session = sessionFactory.getCurrentSession();
    return session.createCriteria(Position.class).list();
  }
  
  @Override
  public long addPosition(Position pos) {
    Session session = sessionFactory.getCurrentSession();
    Long positionId = (Long) session.save(pos);
    return positionId;
  }
  
  @Override
  public Position getPosition(long id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Position.class, id);
  }
  
  @Override
  public void deletePosition(Position pos) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(pos);
  }
  
  @Override
  public void updatePosition(Position pos) {
    Session session = sessionFactory.getCurrentSession();
    session.update(pos);
  }
  
}
