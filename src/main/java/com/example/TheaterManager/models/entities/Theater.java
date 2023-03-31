package com.example.TheaterManager.models.entities;

import com.example.TheaterManager.models.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater extends BaseEntity {

    private String name;
    private String address;
    private int capacity;




}
