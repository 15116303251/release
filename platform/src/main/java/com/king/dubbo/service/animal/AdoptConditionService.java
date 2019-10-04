package com.king.dubbo.service.animal;

import com.king.dubbo.dto.AdoptConditionDto;

import java.util.List;

public interface AdoptConditionService {

    /**
     * 获取所有的领养请求
     * @return
     */
    public List<AdoptConditionDto> getAllAdoptCondition();
}
