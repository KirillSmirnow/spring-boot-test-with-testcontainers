package tests.service.chat;

import tests.model.Chat;

public interface ChatService {

    Chat create(String user, String name);

    Chat getById(String user, long id);
}
