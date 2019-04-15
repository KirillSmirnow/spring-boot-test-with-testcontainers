package tests.service.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tests.model.History;
import tests.repository.mongo.HistoryMongoRepository;

@Service
@RequiredArgsConstructor
public class MongoBackedCalculatorService implements CalculatorService {

    private final HistoryMongoRepository historyMongoRepository;

    @Override
    public int sum(int a, int b) {
        int sum = a + b;
        History history = new History(a, b, sum);
        historyMongoRepository.save(history);
        return sum;
    }
}
