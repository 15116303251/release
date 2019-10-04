package com.king.controller.animal;

import com.king.dubbo.dto.AdoptConditionDto;
import com.king.dubbo.service.animal.AdoptConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AdoptConditionController {

    @Autowired
    AdoptConditionService adoptConditionService;

    /**
     * 获取所有的领养请求
     * @return modelAndView
     */
    public ModelAndView getAllAdoptCondition(){
        List<AdoptConditionDto>list= adoptConditionService.getAllAdoptCondition();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("adoptCondition");
        return modelAndView;
    }

}
