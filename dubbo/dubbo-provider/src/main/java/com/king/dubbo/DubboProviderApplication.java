package com.king.dubbo;

import com.king.dubbo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = "/spring/spring-context.xml")
public class DubboProviderApplication implements CommandLineRunner {

//    @Autowired
//    AnimalService animalService;

//    @Autowired
//    IParamConstantService paramConstantService;
//
//    @Autowired
//    IWxMenuService wxMenuService;

    @Autowired
    UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        System.out.println(userService.getUserByUserName("1"));
//        System.out.println(animalService.getAnimalPanel());
//        animalService.updateAnimal(2);
//        paramConstantService.selectAllConstrant();
//        wxMenuService.createMenu("ENABLE",1,-1);
    }
}
