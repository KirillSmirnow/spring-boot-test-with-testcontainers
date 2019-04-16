package tests.service.message;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tests.model.Message;

public interface MessageService {

    Message create(String user, long chatId, String text);

    Page<Message> getAllByChatId(String user, long chatId, Pageable pageable);
}
