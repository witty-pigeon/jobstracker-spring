package me.piccioni.jobstrackerspring.controller;


import java.util.List;
import javax.validation.Valid;
import me.piccioni.jobstrackerspring.model.Position;
import me.piccioni.jobstrackerspring.service.PositionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author daniele
 */
@Controller
@RequestMapping("/api/positions")
public class PositionControllerJson {
  
  @Autowired
  private PositionManager positionManager;
  
  @RequestMapping(produces = "application/json")
  public @ResponseBody List<Position> list() {
    return positionManager.listPositions();
  }
  
  @RequestMapping(value = "/{id}", produces = "application/json")
  public @ResponseBody Position showPosition(@PathVariable long id) {
    return positionManager.getPosition(id);
  }
  
  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody Position savePosition(@RequestBody @Valid Position position,
          BindingResult result) {
    if(result.hasErrors()) {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
    
    positionManager.addPosition(position);
    return position;
  }
}
