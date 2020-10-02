package me.dani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication app = new SpringApplication(SpringApplication.class);
//        app.addListeners(new SampleListener()); // 이거 객체만 넘겨주면 됨. bean으로 등록안해도

        app.run(args);

    }
}
