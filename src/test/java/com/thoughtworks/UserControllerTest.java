package com.thoughtworks;

import com.thoughtworks.domain.User;
import com.thoughtworks.domain.ValueHolder;
import com.thoughtworks.repository.ValueHolderInterface;
import com.thoughtworks.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private UserService userService;

    @Autowired
    private ValueHolderInterface valueHolderInterface;

    @Autowired
    ValueHolder<String> valueHolder;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(applicationContext).build();
        valueHolder.setValue("");
    }

    @Test
    void should_get_true() {
        assertTrue(true);
    }

    @Test
    void should_test_before_aop() {
        userService.postUser(new User(1, "liu yanping"));
    }

    @Test
    void should_get_before_message() {
        valueHolderInterface.beforeValueHolder(valueHolder);
        assertEquals("AspectBefore OverrideBefore ", valueHolder.getValue());
    }

    @Test
    void should_get_after_message() {
        valueHolderInterface.afterValueHolder(valueHolder);
        assertEquals("OverrideAfter AspectAfter ", valueHolder.getValue());
    }

    @Test
    void should_get_after_returning_message() {
        String expected = valueHolderInterface.afterReturningValueHolder(valueHolder) + "AspectAfterReturning ";
        assertEquals(expected, valueHolder.getValue());
    }

    @Test
    void should_get_after_throwing_message() {
        try {
            valueHolderInterface.afterThrowingValueHolder(valueHolder);
        }catch (Exception e) {

        }
        assertEquals("OverrideAfterThrowing AspectAfterThrowing ", valueHolder.getValue());
    }

    @Test
    void should_get_around_message() {
        valueHolderInterface.aroundValueHolder(valueHolder);
        assertEquals("Aspect Aspect Before OverrideAround Aspect Aspect After ", valueHolder.getValue());
    }
}
