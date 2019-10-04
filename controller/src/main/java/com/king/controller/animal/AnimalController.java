package com.king.controller.animal;

import com.king.dubbo.dto.AnimalDto;
import com.king.dubbo.service.animal.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @RequestMapping("/toAnimalsList")
    public String redictAnimalListPage(Model model){
        List<AnimalDto> animalDtosList = animalService.getAnimalPanel();
        model.addAttribute("animalDtosList",animalDtosList);
        return "/animalsList";
    }

    @RequestMapping("/toAnimals")
    public ModelAndView redictAnimalInfoPage(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView=new ModelAndView();
        AnimalDto animalDto=animalService.getAnimalById(id);
        modelAndView.addObject("animalDto",animalDto);
        modelAndView.addObject("animalId",id);
        modelAndView.setViewName("animals");
        return modelAndView;
    }

    @RequestMapping("/updateAnimal")
    public String updateAnimal(@RequestParam("id")int id){
        animalService.updateAnimal(id);
        return "/animalsList";
    }
}
