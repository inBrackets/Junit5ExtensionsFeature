package org.example.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.example.body.Body;
import org.example.engine.Engine;
import org.example.wheel.Wheel;

@AllArgsConstructor
@Getter
public class Car {
    private String model;
    private int year;
    private Body body;
    private Wheel wheel;
    private Engine engine;
}
