package com.example.synchronize.synchronize12;

public class Run {

    public static void main(String[] args) {

        PublicClass publicClass=new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");

        System.out.println(publicClass.getUsername()+" "+publicClass.getPassword());


        PublicClass.PrivateClass privateClass=publicClass.new PrivateClass();

        privateClass.setAddress("addressValue");
        privateClass.setAge("123");

        System.out.println(privateClass.getAge()+" "+privateClass.getAddress());
     }
}
