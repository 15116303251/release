package com.king.controller.animal;

import com.king.dubbo.dto.AnimalHabitDto;
import com.king.dubbo.service.animal.AnimalHabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AnimalHabitController {

    @Autowired
    AnimalHabitService animalHabitService;

    @RequestMapping("getAnimalHabit")
    public AnimalHabitDto getAnimalHabitByAnimalId(Integer animalId){
        return animalHabitService.getAnimalHabitById(animalId);
    }

    @RequestMapping("/toAnimalsHabit")
    public ModelAndView redictAnimalInfoPage(HttpServletRequest request){
        int animalId=Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView=new ModelAndView();
        AnimalHabitDto animalHabitDto=animalHabitService.getAnimalHabitById(animalId);
        modelAndView.addObject("animalHabitDto",animalHabitDto);
        modelAndView.setViewName("animalsHabit");
        modelAndView.addObject("animalId",animalId);
        return modelAndView;
    }
}
