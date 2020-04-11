package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

   private List<UserInfo> userInfoList;
   private Integer id;
   private String productName;
}
