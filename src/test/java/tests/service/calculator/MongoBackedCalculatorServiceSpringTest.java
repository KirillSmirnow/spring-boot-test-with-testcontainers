package tests.service.calculator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import tests.MongoSpringTest;
import tests.repository.mongo.HistoryMongoRepository;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = MongoBackedCalculatorServiceTestConfig.class)
public class MongoBackedCalculatorServiceSpringTest extends MongoSpringTest {

    @Autowired
    @Qualifier("mongoBackedCalculatorService")
    private CalculatorService calculatorService;

    @Autowired
    private HistoryMongoRepository historyMongoRepository;

    @Test
    public void checkContextIsClean1() {
        assertEquals(0, historyMongoRepository.count());
        Random random = ThreadLocalRandom.current();
        calculatorService.sum(random.nextInt(), random.nextInt());
        assertEquals(1, historyMongoRepository.count());
    }

    @Test
    public void whenCalculateSum_thenGetCorrectAnswer() {
        Random random = ThreadLocalRandom.current();
        int a = random.nextInt();
        int b = random.nextInt();
        int expectedSum = a + b;
        int actualSum = calculatorService.sum(a, b);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void checkContextIsClean2() {
        assertEquals(0, historyMongoRepository.count());
        Random random = ThreadLocalRandom.current();
        calculatorService.sum(random.nextInt(), random.nextInt());
        assertEquals(1, historyMongoRepository.count());
    }

    @Test
    public void checkContextIsClean3() {
        assertEquals(0, historyMongoRepository.count());
        Random random = ThreadLocalRandom.current();
        calculatorService.sum(random.nextInt(), random.nextInt());
        assertEquals(1, historyMongoRepository.count());
    }
}
