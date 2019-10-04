package com.king.dubbo.service.animal;

import com.king.dubbo.dto.AnimalDto;

import java.util.List;

/**
 * @description 宠物的服务类
 * @author shenwang
 *
 */
public interface AnimalService {

    /**
     * 获取宠物的列表页
     * @return 宠物的集合
     */
    public List<AnimalDto> getAnimalPanel();

    /**
     * 根据宠物id获取相应的宠物信息
     * @param id 宠物id
     * @return
     */
    public AnimalDto getAnimalById(Integer id);

    /**
     *
     * @param id
     */
    public void updateAnimal(Integer id);

}
