package com.example.TheaterManager.models.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterView {
    private String name;
    private String address;
    private int capacity;
}
