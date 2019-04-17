package tests.service.chat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tests.JpaSpringTest;
import tests.model.Chat;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = ChatServiceTestConfig.class)
public class ChatServiceTest extends JpaSpringTest {

    @Autowired
    private ChatService chatService;

    private Chat existingChat;

    @Before
    public void setUp() {
        existingChat = chatService.create("user", "My chat");
    }

    @Test
    public void whenCreateChat_thenReturnChatWithIdAndSameContent() {
        Chat chat = chatService.create("user", "My chat");
        assertNotNull(chat.getId());
        assertEquals("user", chat.getAdmin());
        assertEquals("My chat", chat.getName());
    }

    @Test
    public void givenExistingChat_whenGetChatById_thenReturnExistingChatWithSameContent() {
        Chat chat = chatService.getById("user", existingChat.getId());
        assertEquals(existingChat.getId(), chat.getId());
        assertEquals(existingChat.getAdmin(), chat.getAdmin());
        assertEquals(existingChat.getName(), chat.getName());
    }

    @Test(expected = Exception.class)
    public void whenGetNonExistingChat_thenFailure() {
        chatService.getById("user", ThreadLocalRandom.current().nextInt());
    }
}
