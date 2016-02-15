package me.piccioni.jobstrackerspring.test.service;

import me.piccioni.jobstrackerspring.dao.PositionDao;
import me.piccioni.jobstrackerspring.model.Position;
import me.piccioni.jobstrackerspring.service.PositionManager;
import me.piccioni.jobstrackerspring.service.PositionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnit44Runner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@RunWith(MockitoJUnit44Runner.class)
public class PositionManagerTest {
  
  @Mock
  private PositionDao positionDaoMock;
  
  @InjectMocks
  private final PositionManager positionManager = new PositionServiceImpl();
  
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void testCreatePosition () {
    when(positionDaoMock.addPosition(any(Position.class)))
            .thenReturn((long) 123123);
    
    assertNotNull(positionManager);
    
    Position pos = new Position();
    pos.setAgency("foo");
    pos.setCompany("bar");
    pos.setCompany("comics reader");
    assertEquals(123123, positionManager.addPosition(pos));
  }
  
}
