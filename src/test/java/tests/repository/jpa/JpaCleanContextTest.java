package tests.repository.jpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.JpaSpringTest;
import tests.model.Chat;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class JpaCleanContextTest extends JpaSpringTest {

    @Autowired
    private ChatRepository chatRepository;

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
        assertEquals(0, chatRepository.count());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int count = random.nextInt(1, 10);
        insertChats(count);
        assertEquals(count, chatRepository.count());
    }

    private void insertChats(int count) {
        for (int i = 0; i < count; i++) {
            chatRepository.save(new Chat("name", "admin"));
        }
    }
}
