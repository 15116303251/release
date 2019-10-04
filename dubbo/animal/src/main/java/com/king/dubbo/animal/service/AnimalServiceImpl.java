package com.king.dubbo.animal.service;

import com.king.dubbo.animal.dao.AnimalMapper;
import com.king.dubbo.animal.dao.model.Animal;
import com.king.dubbo.dto.AnimalDto;
import com.king.dubbo.service.animal.AnimalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalMapper animalMapper;

    @Override
    public List<AnimalDto> getAnimalPanel() {

        List<Animal>list=animalMapper.selectAnimalList();
        List<AnimalDto> animalDtosList=new ArrayList<>();

        if(list!=null && list.size()>=0){
            for(int i=0;i<list.size();i++){
                AnimalDto animalDto=new AnimalDto();
                BeanUtils.copyProperties(list.get(i),animalDto);

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String createTime=sdf.format(list.get(i).getCreateTime());
                animalDto.setCreateTime(createTime);

                animalDtosList.add(animalDto);
            }
        }

        return animalDtosList;
    }


    @Override
    public AnimalDto getAnimalById(Integer animalId) {
        Animal animal=animalMapper.selectByPrimaryKey(animalId);

        AnimalDto animalDto=new AnimalDto();

        if(animal!=null){
            BeanUtils.copyProperties(animal,animalDto);
        }
        return animalDto;
    }

    @Override
    public void updateAnimal(Integer id) {


        Lock lock=new ReentrantLock();
        lock.lock();
        try{
            Animal animal=animalMapper.selectByPrimaryKey(id);
            if(animal.getAge()<=10){
                animal.setAge(animal.getAge()+1);
                animalMapper.updateByPrimaryKeySelective(animal);
            }
        }finally {
           lock.unlock();
        }
    }


}
