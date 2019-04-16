package tests.service.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tests.model.Chat;
import tests.repository.jpa.ChatRepository;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public Chat create(String user, String name) {
        Chat chat = new Chat(name, user);
        return chatRepository.save(chat);
    }

    @Override
    public Chat getById(String user, long id) {
        return chatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat not found"));
    }
}
