package com.example.demo;

import com.example.demo.stuff.FeatureRepo;
import com.example.demo.stuff.FeatureState;
import com.example.demo.stuff.UserEntity;
import com.example.demo.stuff.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;

@ConfigurationPropertiesScan
@EnableConfigurationProperties
@EnableAspectJAutoProxy
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FeatureRepo featureRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @EventListener(ApplicationStartedEvent.class)
    public void prefill() {
        userRepo.save(new UserEntity().setId(1L).setEmail("sdvs").setRole("ADMIN"));
        featureRepo.save(new FeatureState().setFeature_name("WORKS_FEATURE").setId(1L).setActive(true));

    }

}
