package tests;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = JpaTestConfig.class)
public abstract class JpaSpringTest extends SpringTest {
}
