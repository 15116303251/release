package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {


        List<ProductDto> productDtos=new ArrayList<>();
        UserInfo userInfo=new UserInfo();
        userInfo.setAge(1);
        userInfo.setName("1");
        UserInfo userInfo1=new UserInfo();
        userInfo1.setAge(11);
        userInfo1.setName("11");
        List<UserInfo> list=new ArrayList<>();
        list.add(userInfo);
        list.add(userInfo1);

        ProductDto productDto=new ProductDto();
        productDto.setUserInfoList(list);
        productDto.setId(1);
        productDto.setProductName("产品一号");
        productDtos.add(productDto);



        UserInfo userInfo3=new UserInfo();
        userInfo3.setAge(3);
        userInfo3.setName("3");

        List<UserInfo> list1=new ArrayList<>();
        list1.add(userInfo3);
        ProductDto productDto1=new ProductDto();
        productDto1.setUserInfoList(list1);
        productDto1.setId(3);
        productDto1.setProductName("产品三号");
        productDtos.add(productDto1);




        ProductDto productDto4=new ProductDto();
        productDto4.setUserInfoList(null);
        productDto4.setId(4);
        productDto4.setProductName("产品四号");
        productDtos.add(productDto4);

        List<ProductDto> titleSortList = productDtos.stream().sorted(Comparator.comparing(ProductDto::getProductName)).collect(Collectors.toList());

        System.out.println(titleSortList);
    }
}
