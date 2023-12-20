package com.example.demo.stuff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepo extends JpaRepository<FeatureState, Long> {
}
