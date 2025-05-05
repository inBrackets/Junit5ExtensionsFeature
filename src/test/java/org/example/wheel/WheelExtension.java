package org.example.wheel;

import lombok.Getter;
import org.example.CustomTestExtension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class WheelExtension extends CustomTestExtension {

    @Getter
    private Wheel wheel;

    public WheelExtension(int size, String type, float pressure) {
        this.wheel = new Wheel(size, type, pressure);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Wheel.class);
    }

    @Override
    public Wheel resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return this.wheel;
    }


    @Override
    public String getExtensionName() {
        return "WheelExtension";
    }
}
