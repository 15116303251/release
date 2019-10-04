package com.king.dubbo.animal.service;

import com.king.dubbo.animal.dao.AnimalSeeRecordMapper;
import com.king.dubbo.animal.dao.model.AnimalSeeRecord;
import com.king.dubbo.dto.AnimalSeeRecordDto;
import com.king.dubbo.service.animal.AnimalSeeRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service("animalSeeRecordService")
public class AnimalSeeRecordServiceImpl implements AnimalSeeRecordService {


    @Autowired
    AnimalSeeRecordMapper animalSeeRecordMapper;

    @Override
    public List<AnimalSeeRecordDto> getAnimalSeeRecordByAnimalId(Integer animalId) {

        List<AnimalSeeRecord>list=animalSeeRecordMapper.selectByAnimalId(animalId);

        System.out.println(list);
        List<AnimalSeeRecordDto> animalSeeRecordDtoList=new ArrayList<>();

        if(list!=null &&list.size()!=0){
            for(int i=0;i<list.size();i++){
                AnimalSeeRecordDto animalSeeRecordDto=new AnimalSeeRecordDto();

                BeanUtils.copyProperties(list.get(i),animalSeeRecordDto);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String createTime=sdf.format(list.get(i).getCreateTime());
                animalSeeRecordDto.setCreateTime(createTime);
                animalSeeRecordDtoList.add(animalSeeRecordDto);
            }
        }
        return animalSeeRecordDtoList;
    }

}
