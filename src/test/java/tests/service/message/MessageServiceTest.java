package tests.service.message;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import tests.MongoSpringTest;
import tests.model.Message;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = MessageServiceTestConfig.class)
public class MessageServiceTest extends MongoSpringTest {

    @Autowired
    private MessageService messageService;

    private Message existingMessage;

    @Before
    public void setUp() {
        existingMessage = messageService.create("user", 123, "Message text");
    }

    @Test
    public void whenCreateMessage_thenReturnMessageWithIdDateTimeAndSameContent() {
        Message message = messageService.create("user", 123, "Message text");
        assertNotNull(message.getId());
        assertNotNull(message.getDateTime());
        assertEquals("user", message.getAuthor());
        assertEquals(123, message.getChatId());
        assertEquals("Message text", message.getText());
    }

    @Test
    public void givenExistingMessage_whenGetMessagesByChatId_thenExistingMessageWithSameContentFound() {
        long chatId = existingMessage.getChatId();
        List<Message> messages = messageService.getAllByChatId("user", chatId, PageRequest.of(0, 100))
                .getContent();
        assertEquals(1, messages.size());
        Message message = messages.get(0);
        assertNotNull(message.getId());
        assertNotNull(message.getDateTime());
        assertEquals(existingMessage.getAuthor(), message.getAuthor());
        assertEquals(existingMessage.getChatId(), message.getChatId());
        assertEquals(existingMessage.getText(), message.getText());
    }
}
