package tests.service.message;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tests.model.Message;
import tests.repository.mongo.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message create(String user, long chatId, String text) {
        Message message = new Message(chatId, user, text);
        return messageRepository.save(message);
    }

    @Override
    public Page<Message> getAllByChatId(String user, long chatId, Pageable pageable) {
        return messageRepository.findAllByChatId(chatId, pageable);
    }
}
