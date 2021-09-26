package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") //localhost:9090/api/get/hello
    public String hello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    //localhost:9090/api/get/path-variable/{}

    //중괄호값이랑 이름 같아야함
    @GetMapping("path-variable/{name}")
    public String pathVariable(@PathVariable(name="name") String pathName){

        System.out.println("parthVariable : " + pathName);

        return  pathName;
    }

    // localhost:9090/api/get/query-param?user=steve&email=tqall442@gmail.com.com&age=30

    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = " + entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age

    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email+ " " + age;
    }
    
    //현업에서 많이 사용
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }



}
