package me.piccioni.jobstrackerspring.controller;

import java.util.List;
import javax.validation.Valid;
import me.piccioni.jobstrackerspring.model.Position;
import me.piccioni.jobstrackerspring.service.PositionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller
@RequestMapping("/positions")
public class PositionController {
  
  @Autowired
  PositionManager positionManager;
  
  @RequestMapping
  public String listPositions(Model model) {
    List<Position> positions = positionManager.listPositions();
    model.addAttribute("positions", positions);
    return "positions/list";
  }
  
  @RequestMapping("/new")
  public String createPosition(Model model) {
    model.addAttribute("position", new Position());
    return "positions/new";
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public String savePosition(
          @RequestBody @ModelAttribute @Valid Position pos, BindingResult result) {
    
    if(result.hasErrors()) {
      return "positions/new";
    }
    long val = positionManager.addPosition(pos);
    return "positions/show";
  }
  
  @RequestMapping("/{id}/edit")
  public String editPosition(@PathVariable long id, Model model) {
    Position position = positionManager.getPosition(id);
    if(null == position) throw new HttpNotFoundException();
    
    model.addAttribute("position", position);
    return "positions/edit";
  }
  
  @RequestMapping("/{id}")
  public String showPosition(@PathVariable long id, Model model) {
    Position position = positionManager.getPosition(id);
    if(null == position) throw new HttpNotFoundException();
    
    model.addAttribute("position", position);
    return "positions/show";
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public String updatePosition(@PathVariable long id,
          @RequestBody @ModelAttribute @Valid Position position,
          BindingResult result) {
    
    if(result.hasErrors()) {
      return "positions/edit";
    }
    if(id != position.getId()) throw new HttpNotFoundException();
    
    positionManager.updatePosition(position);
    
    return "positions/show";
  }
  
}
