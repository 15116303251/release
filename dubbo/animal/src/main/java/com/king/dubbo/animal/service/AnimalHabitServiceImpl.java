package com.king.dubbo.animal.service;

import com.king.dubbo.animal.dao.AnimalHabitMapper;
import com.king.dubbo.animal.dao.model.AnimalHabit;
import com.king.dubbo.dto.AnimalHabitDto;
import com.king.dubbo.service.animal.AnimalHabitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("animalHabitService")
public class AnimalHabitServiceImpl implements AnimalHabitService {

    @Autowired
    AnimalHabitMapper animalHabitMapper;

    @Override
    public AnimalHabitDto getAnimalHabitById(Integer animalHabitId) {
        AnimalHabit animalHabit=animalHabitMapper.selectByPrimaryKey(animalHabitId);

        AnimalHabitDto animalHabitDto=new AnimalHabitDto();
        if(animalHabit!=null){
            BeanUtils.copyProperties(animalHabit,animalHabitDto);
        }else {
            animalHabitDto=null;
        }

        return animalHabitDto;
    }


}
