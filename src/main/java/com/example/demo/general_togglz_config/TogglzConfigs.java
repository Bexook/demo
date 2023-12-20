package com.example.demo.general_togglz_config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.user.UserProvider;
import org.togglz.spring.security.SpringSecurityUserProvider;

@Configuration
@RequiredArgsConstructor
public class TogglzConfigs implements TogglzConfig {

    @Override
    public Class<? extends Feature> getFeatureClass() {
        return AppFeatures.class;
    }

    @Bean
    @Primary
    public FeatureManager getFeatureManager() {
        return new FeatureManagerBuilder().featureEnum(AppFeatures.class)
                .userProvider(getUserProvider())
                .build();
    }


    @Bean
    public FeatureManager getFeatureManagerUsernameBased() {
        return new FeatureManagerBuilder().featureEnum(AppFeatures.class)
                .userProvider(getUserProviderUserNameBased())
                .build();
    }


    @Override
    public StateRepository getStateRepository() {
        return null;
    }

    @Override
    public UserProvider getUserProvider() {
        return new SpringSecurityUserProvider("ADMIN");
    }

    public UserProvider getUserProviderUserNameBased() {
        return new UsernameUserProvider("Zack");
    }
}
