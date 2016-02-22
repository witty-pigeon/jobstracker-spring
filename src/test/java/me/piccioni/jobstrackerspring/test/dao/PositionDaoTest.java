package me.piccioni.jobstrackerspring.test.dao;

import javax.validation.ValidationException;
import me.piccioni.jobstrackerspring.config.HibernateConfiguration;
import me.piccioni.jobstrackerspring.dao.PositionDao;
import me.piccioni.jobstrackerspring.model.Position;
import me.piccioni.jobstrackerspring.test.config.TestConfig;
import me.piccioni.jobstrackerspring.test.config.TestDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

/**
 *
 */
@ContextConfiguration(classes = {
  TestConfig.class,
  TestDataSource.class,
  HibernateConfiguration.class
})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class PositionDaoTest {
  
  @Autowired
  private PositionDao positionDao;
  
  
  @Test
  @Transactional
  @Rollback(true)
  public void addNewPosition() {
    final String TEST_POSITION = "A test position";
    
    Position pos = new Position();
    pos.setPosition(TEST_POSITION);
    long assignedId = positionDao.addPosition(pos);
    
    Position retrievedPos = positionDao.getPosition(assignedId);
    
    assertEquals(retrievedPos.getPosition(), TEST_POSITION);
  }
  
  
  
  @Test(expected = ValidationException.class)
  @Transactional
  @Rollback(true)
  public void missingPosition_Throws_Validation() {
    Position pos = new Position();
    positionDao.addPosition(pos);
  }
  
  
  @Test
  @Transactional
  @Rollback(true)
  public void deletePosition() {
    Position pos = new Position();
    pos.setPosition("Tester");
    
    positionDao.addPosition(pos);
    assertEquals(1, positionDao.listPositions().size());
    
    positionDao.deletePosition(pos);
    assertEquals(0, positionDao.listPositions().size());
    
  }
  
}
