package com.example.demo.stuff;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "feature_state")
@Accessors(chain = true)
public class FeatureState {

    @Id
    private Long id;
    private String feature_name;
    private boolean active;
}
