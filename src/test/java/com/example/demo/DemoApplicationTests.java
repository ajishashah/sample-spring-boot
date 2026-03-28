package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void greetingControllerReturnsHello() {
        GreetingController controller = new GreetingController();
        assertThat(controller.greeting("Alice")).isEqualTo("Hello, Alice!");
    }
}
