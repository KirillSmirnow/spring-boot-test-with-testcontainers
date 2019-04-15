package tests.service.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tests.model.History;
import tests.repository.jpa.HistoryJpaRepository;

@Service
@RequiredArgsConstructor
public class JpaBackedCalculatorService implements CalculatorService {

    private final HistoryJpaRepository historyJpaRepository;

    @Override
    public int sum(int a, int b) {
        int sum = a + b;
        History history = new History(a, b, sum);
        historyJpaRepository.save(history);
        return sum;
    }
}
