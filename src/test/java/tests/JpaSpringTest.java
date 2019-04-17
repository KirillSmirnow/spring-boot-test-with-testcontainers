package tests;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

import javax.transaction.Transactional;

@Transactional
@ContextHierarchy(@ContextConfiguration(classes = JpaTestConfig.class))
public abstract class JpaSpringTest extends SpringTest {
}
