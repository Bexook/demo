package com.example.demo.general_togglz_config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

import java.util.Set;

import static org.togglz.spring.security.SpringSecurityUserProvider.createAuthentication;

public class UsernameUserProvider implements UserProvider {

    private Set<String> featureAdminUsernames;

    public UsernameUserProvider(final String... featureAdminUsernames) {
        this.featureAdminUsernames = Set.of(featureAdminUsernames);
    }

    @Override
    public FeatureUser getCurrentUser() {
        Authentication authentication = createAuthentication();

        // null if no authentication data is available for the current thread
        if (authentication == null) {
            return null;
        }

        // try to obtain the name of this user
        String name = getUserName(authentication);

        // check is admin username
        boolean featureAdmin = isFeatureAdmin(name);

        return new SimpleFeatureUser(name, featureAdmin);
    }


    private String getUserName(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails)) {
            return principal.toString();
        }
        UserDetails userDetails = (UserDetails) principal;
        return userDetails.getUsername();
    }

    protected boolean isFeatureAdmin(final String username) {
        return featureAdminUsernames.contains(username);
    }
}
