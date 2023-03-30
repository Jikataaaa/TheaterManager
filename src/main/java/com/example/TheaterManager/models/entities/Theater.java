package com.example.TheaterManager.models.entities;

import com.example.TheaterManager.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater extends BaseEntity {

    private String name;
    private String address;
    private int capacity;

    @OneToMany(mappedBy = "theater_id", targetEntity = Performance.class)
    private Set<Performance> performances;


}
