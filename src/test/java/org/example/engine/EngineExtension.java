package org.example.engine;

import lombok.Getter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class EngineExtension implements ParameterResolver {

    @Getter
    private Engine engine;

    public EngineExtension(int horsepower, String fuelType) {
        this.engine = new Engine(horsepower, fuelType);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Engine.class);
    }

    @Override
    public Engine resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return this.engine;
    }
}
