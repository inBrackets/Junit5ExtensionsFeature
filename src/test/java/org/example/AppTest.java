package org.example;

import org.example.body.Body;
import org.example.body.BodyExtension;
import org.example.car.Car;
import org.example.car.CarExtension;
import org.example.engine.Engine;
import org.example.engine.EngineExtension;
import org.example.wheel.Wheel;
import org.example.wheel.WheelExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for {@link CarExtension }
 */
public class AppTest {

    @Order(1)
    @RegisterExtension
    protected static BodyExtension bodyExtension = new BodyExtension("Red", 4, "Aluminum");

    @Order(2)
    @RegisterExtension
    protected static EngineExtension engineExtension = new EngineExtension(150, "Petrol");

    @Order(3)
    @RegisterExtension
    protected static WheelExtension wheelExtension = new WheelExtension(16, "Alloy", 2.2F);

    @Order(4)
    @RegisterExtension
    protected static CarExtension carExtension = new CarExtension("Toyota", 2022, bodyExtension, wheelExtension, engineExtension);

    @BeforeAll
    public static void beforeAll() {
        System.out.println("BEFORE ALL: AppTest");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("BEFORE EACH: AppTest");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("AFTER ALL: AppTest");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("AFTER EACH: AppTest");
    }

    @Test
    public void test1(Body body, Engine engine, Wheel wheel, Car car) {

        System.out.println("TEST 1: AppTest");

        Body body2 = new Body("Red", 4, "Aluminum");

        assertThat(car.getBody())
                .as("Body does not match")
                .isEqualTo(body);

        assertThat(car.getBody())
                .as("Body matches wrong body")
                .isNotEqualTo(body2);

        assertThat(car.getEngine())
                .as("Engine does not match")
                .isEqualTo(engine);

        assertThat(car.getWheel())
                .as("Wheel does not match")
                .isEqualTo(wheel);
    }

    @Test
    public void test2(Body body, Engine engine, Wheel wheel, Car car) {

        System.out.println("TEST 2: AppTest");

        Body body2 = new Body("Red", 4, "Aluminum");

        assertThat(car.getBody())
                .as("Body does not match")
                .isEqualTo(body);

        assertThat(car.getBody())
                .as("Body matches wrong body")
                .isNotEqualTo(body2);

        assertThat(car.getEngine())
                .as("Engine does not match")
                .isEqualTo(engine);

        assertThat(car.getWheel())
                .as("Wheel does not match")
                .isEqualTo(wheel);
    }
}
