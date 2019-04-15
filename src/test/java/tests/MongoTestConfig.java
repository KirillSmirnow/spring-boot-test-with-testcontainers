package tests;

import com.mongodb.MongoClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testcontainers.containers.GenericContainer;

@TestConfiguration
@EnableMongoRepositories("tests.repository.mongo")
public class MongoTestConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "test");
    }

    @Bean
    public MongoClient mongoClient() {
        int port = mongoContainer().getFirstMappedPort();
        return new MongoClient("localhost", port);
    }

    @Bean
    public GenericContainer<?> mongoContainer() {
        GenericContainer<?> mongoContainer = new GenericContainer<>("mongo")
                .withExposedPorts(27017);
        mongoContainer.start();
        return mongoContainer;
    }
}
