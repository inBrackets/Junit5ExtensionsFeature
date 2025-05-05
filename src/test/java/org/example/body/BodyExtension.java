package org.example.body;

import lombok.Getter;
import org.example.CustomTestExtension;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class BodyExtension extends CustomTestExtension {

    @Getter
    private Body body;

    public BodyExtension(String color, int numberOfDoors, String material) {
        this.body = new Body(color, numberOfDoors, material);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Body.class);
    }

    @Override
    public Body resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return this.body;
    }

    @Override
    public String getExtensionName() {
        return "BodyExtension";
    }
}
