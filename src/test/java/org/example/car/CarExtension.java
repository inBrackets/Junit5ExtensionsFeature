package org.example.car;

import lombok.Getter;
import org.example.body.Body;
import org.example.body.BodyExtension;
import org.example.engine.Engine;
import org.example.engine.EngineExtension;
import org.example.wheel.Wheel;
import org.example.wheel.WheelExtension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CarExtension implements ParameterResolver {

    @Getter
    private Car car;

    public CarExtension(String model, int year, BodyExtension bodyExtension, WheelExtension wheelExtension, EngineExtension engineExtension) {
        this.car = new Car(model, year, bodyExtension.getBody(), wheelExtension.getWheel(), engineExtension.getEngine());
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Car.class);
    }

    @Override
    public Car resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return this.car;
    }
}
