package com.king.dubbo.service.animal;

import com.king.dubbo.dto.AnimalHabitDto;

public interface AnimalHabitService {

    /**
     * 根据宠物习惯id获取宠物习惯信息
     * @param AnimalHabitId
     * @return
     */
    public AnimalHabitDto getAnimalHabitById(Integer AnimalHabitId);

}
