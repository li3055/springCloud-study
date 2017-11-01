package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@RestController
@EnableEurekaClient
public class DemoApplication {
    public static void main(String[] args) {


       // System.out.println(metho());
  SpringApplication.run(DemoApplication.class, args);
    }


    static int metho(   ){
        int a =0    ;
        try{
            a  = a/a;

        return  metho2();


        }catch(Exception e  ){
            System.out.println("error");
            return methoCat();
        }finally {
            System.exit(0);
            return methoFinal();
        }
    }
    static int metho2(){
        System.out.println("try return  ");
        return 1;
    }
    static int methoCat(){
        System.out.println("catch  ");
        return 2;
    }
    static int methoFinal(){
        System.out.println("methoFinal  ");
        return 3;
    }

    @RequestMapping("/hi")
    public String home() {
        System.out.println("hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        System.out.println("info is being called");
        return restTemplate.getForObject("http://userService/info", String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
