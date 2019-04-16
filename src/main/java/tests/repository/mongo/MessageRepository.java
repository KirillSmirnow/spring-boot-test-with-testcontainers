package tests.repository.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import tests.model.Message;

import java.util.UUID;

public interface MessageRepository extends MongoRepository<Message, UUID> {

    Page<Message> findAllByChatId(long chatId, Pageable pageable);
}
