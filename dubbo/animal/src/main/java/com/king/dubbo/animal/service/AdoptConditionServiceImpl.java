package com.king.dubbo.animal.service;

import com.king.dubbo.animal.dao.AdoptConditionMapper;
import com.king.dubbo.animal.dao.model.AdoptCondition;
import com.king.dubbo.dto.AdoptConditionDto;
import com.king.dubbo.service.animal.AdoptConditionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service("adoptConditionService")
public class AdoptConditionServiceImpl implements AdoptConditionService {

    @Autowired
    AdoptConditionMapper adoptConditionMapper;

    @Override
    public List<AdoptConditionDto> getAllAdoptCondition() {
        List<AdoptCondition>list=adoptConditionMapper.getAllAdoptCondition();
        List<AdoptConditionDto> adoptConditionDtoList=new ArrayList<>();

        for(int i=0;i<list.size();i++){
            AdoptConditionDto adoptConditionDto=new AdoptConditionDto();
            BeanUtils.copyProperties(list.get(i),adoptConditionDto);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String createTime=sdf.format(list.get(i).getCreateTime());
            adoptConditionDto.setCreateTime(createTime);
            adoptConditionDtoList.add(adoptConditionDto);
        }
        return adoptConditionDtoList;
    }
}
