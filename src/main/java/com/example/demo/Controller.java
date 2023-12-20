package com.example.demo;

import com.example.demo.spring_boot_ff.Feature;
import com.example.demo.togglz_based_annotation.TogglzFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import static com.example.demo.general_togglz_config.AppFeatures.WORKS_FEATURE;
import static com.example.demo.general_togglz_config.AppFeatures.WORKS_FEATURE_USERNAME;

@RestController
public class Controller {

    @Autowired
    private FeatureManager featureManager;

    @Autowired
    @Qualifier("getFeatureManagerUsernameBased")
    private FeatureManager featureManagerUsernameBased;


    @Feature(isActive = true)
    @GetMapping("/test/spring_based")
    public ResponseEntity<?> springImpl() {
        return ResponseEntity.ok("Feature is enabled");
    }

    @GetMapping("/test/togglz")
    public ResponseEntity<?> togglzImpl() {
        if (featureManager.isActive(WORKS_FEATURE)) {
            return ResponseEntity.ok("Feature works for ADMIN user");
        }
        return ResponseEntity.ok("User is not ADMIN, feature do not work");
    }

    @GetMapping("/test/togglz/username")
    public ResponseEntity<?> togglzUsernameImpl() {
        if (featureManagerUsernameBased.isActive(WORKS_FEATURE_USERNAME)) {
            return ResponseEntity.ok("Feature works for ADMIN user");
        }
        return ResponseEntity.ok("User is not ADMIN, feature do not work");
    }


    @TogglzFeature(WORKS_FEATURE)
    @GetMapping("/test/togglz-based-annotation")
    public ResponseEntity<?> togglzBasedAnnotation() {
        return ResponseEntity.ok("Feature works for ADMIN user");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test/pre-authorize")
    public String sampleUrl() {
        return "User have access to this feature";
    }

}
