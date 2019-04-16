package tests.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tests.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
