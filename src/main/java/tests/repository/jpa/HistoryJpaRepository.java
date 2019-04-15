package tests.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tests.model.History;

import java.util.UUID;

public interface HistoryJpaRepository extends JpaRepository<History, UUID> {
}
