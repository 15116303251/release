package com.king.controller.animal;

import com.king.dubbo.dto.AnimalSeeRecordDto;
import com.king.dubbo.service.animal.AnimalSeeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AnimalSeeRecordController {

    @Autowired
    AnimalSeeRecordService animalSeeRecordService;

    public List<AnimalSeeRecordDto> getAnimalSeeRecordByAnimalId(Integer animalId){
        return animalSeeRecordService.getAnimalSeeRecordByAnimalId(animalId);
    }

    @RequestMapping("/toAnimalsSeeRecord")
    public ModelAndView redictAnimalInfoPage(HttpServletRequest request){
        int animalId=Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView=new ModelAndView();
        List<AnimalSeeRecordDto> animalSeeRecordDtoList=animalSeeRecordService.getAnimalSeeRecordByAnimalId(animalId);
        modelAndView.addObject("animalSeeRecordDtoList",animalSeeRecordDtoList);
        modelAndView.setViewName("animalsSeeRecord");
        modelAndView.addObject("animalId",animalId);

        return modelAndView;
    }
}
