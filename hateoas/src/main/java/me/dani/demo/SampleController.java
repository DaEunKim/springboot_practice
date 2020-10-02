package me.dani.demo;

import org.springframework.stereotype.Controller;
import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public Hello hello(){
        Hello hello = new Hello();
        hello.setPrefix("HI");
        hello.setName("dani");
//        Resource<Hello> helloResource = new Resource<Hello>(hello);
//        helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());
        return hello;
    }
}
