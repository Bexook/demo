package com.example.demo.general_togglz_config;

import org.togglz.core.Feature;
import org.togglz.core.activation.UserRoleActivationStrategy;
import org.togglz.core.activation.UsernameActivationStrategy;
import org.togglz.core.annotation.ActivationParameter;
import org.togglz.core.annotation.DefaultActivationStrategy;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum AppFeatures implements Feature {

    @Label("WORKS_FEATURE")
    @EnabledByDefault
    @DefaultActivationStrategy(id = UserRoleActivationStrategy.ID, parameters = {
            @ActivationParameter(name = UserRoleActivationStrategy.PARAM_ROLES_NAME, value = "ADMIN")
    })
    WORKS_FEATURE,


    @Label("WORKS_FEATURE_USERNAME")
    @EnabledByDefault
    @DefaultActivationStrategy(id = UsernameActivationStrategy.ID, parameters = {
            @ActivationParameter(name = UsernameActivationStrategy.PARAM_USERS, value = "admin_user")})
    WORKS_FEATURE_USERNAME;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
