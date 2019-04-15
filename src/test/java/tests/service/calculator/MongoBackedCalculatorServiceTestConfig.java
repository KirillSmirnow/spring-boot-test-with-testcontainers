package tests.service.calculator;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import tests.repository.jpa.HistoryJpaRepository;

@TestConfiguration
@ComponentScan
@MockBean(HistoryJpaRepository.class)
public class MongoBackedCalculatorServiceTestConfig {
}
