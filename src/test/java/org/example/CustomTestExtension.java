package org.example;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterResolver;

public abstract class CustomTestExtension implements ParameterResolver,
        BeforeAllCallback, BeforeEachCallback, BeforeTestExecutionCallback,
        AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback {

    public abstract String getExtensionName();

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("AFTER ALL: " + getExtensionName());
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("AFTER EACH: " + getExtensionName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("AFTER TEST EXECUTION: " + getExtensionName());
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("BEFORE ALL: " + getExtensionName());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("BEFORE EACH: " + getExtensionName());
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("BEFORE TEST EXECUTION: " + getExtensionName());
    }
}
