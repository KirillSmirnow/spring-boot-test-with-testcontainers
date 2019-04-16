package tests;

import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

@Transactional
@ContextConfiguration(classes = JpaTestConfig.class)
public abstract class JpaSpringTest extends SpringTest {
}
