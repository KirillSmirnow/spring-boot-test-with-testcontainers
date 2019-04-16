package tests.repository.mongo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.MongoSpringTest;
import tests.model.Message;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class MongoCleanContextTest extends MongoSpringTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test1() {
        testCleanContext();
    }

    @Test
    public void test2() {
        testCleanContext();
    }

    @Test
    public void test3() {
        testCleanContext();
    }

    private void testCleanContext() {
        assertEquals(0, messageRepository.count());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int count = random.nextInt(1, 10);
        insertMessages(count);
        assertEquals(count, messageRepository.count());
    }

    private void insertMessages(int count) {
        for (int i = 0; i < count; i++) {
            messageRepository.save(new Message(0, "user", "text"));
        }
    }
}
