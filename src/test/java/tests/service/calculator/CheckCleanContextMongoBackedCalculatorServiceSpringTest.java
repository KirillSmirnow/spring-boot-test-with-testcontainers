package tests.service.calculator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tests.MongoSpringTest;
import tests.model.History;
import tests.repository.mongo.HistoryMongoRepository;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = MongoBackedCalculatorServiceTestConfig.class)
public class CheckCleanContextMongoBackedCalculatorServiceSpringTest extends MongoSpringTest {

    @Autowired
    private HistoryMongoRepository historyMongoRepository;

    @Test
    public void checkContextIsClean1() {
        assertEquals(0, historyMongoRepository.count());
        Random random = ThreadLocalRandom.current();
        historyMongoRepository.save(new History(random.nextInt(), random.nextInt(), random.nextInt()));
        historyMongoRepository.save(new History(random.nextInt(), random.nextInt(), random.nextInt()));
        assertEquals(2, historyMongoRepository.count());
    }

    @Test
    public void checkContextIsClean2() {
        assertEquals(0, historyMongoRepository.count());
        Random random = ThreadLocalRandom.current();
        historyMongoRepository.save(new History(random.nextInt(), random.nextInt(), random.nextInt()));
        assertEquals(1, historyMongoRepository.count());
    }

    @Test
    public void checkContextIsClean3() {
        assertEquals(0, historyMongoRepository.count());
        Random random = ThreadLocalRandom.current();
        historyMongoRepository.save(new History(random.nextInt(), random.nextInt(), random.nextInt()));
        historyMongoRepository.save(new History(random.nextInt(), random.nextInt(), random.nextInt()));
        historyMongoRepository.save(new History(random.nextInt(), random.nextInt(), random.nextInt()));
        assertEquals(3, historyMongoRepository.count());
    }
}
