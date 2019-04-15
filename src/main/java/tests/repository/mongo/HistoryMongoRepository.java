package tests.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tests.model.History;

import java.util.UUID;

public interface HistoryMongoRepository extends MongoRepository<History, UUID> {
}
