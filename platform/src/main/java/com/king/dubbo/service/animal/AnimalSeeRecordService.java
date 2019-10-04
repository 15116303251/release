package com.king.dubbo.service.animal;

import com.king.dubbo.dto.AnimalSeeRecordDto;

import java.util.List;

public interface AnimalSeeRecordService {

    /**
     * 根据宠物id获取相应的宠物的救诊情况
     * @param animalId 宠物id
     * @return
     */
    public List<AnimalSeeRecordDto> getAnimalSeeRecordByAnimalId(Integer animalId);
}
