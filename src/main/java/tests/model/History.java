package tests.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class History {

    @Id
    private UUID id;

    private LocalDateTime dateTime;

    private double a;
    private double b;
    private double sum;

    public History(double a, double b, double sum) {
        this.id = UUID.randomUUID();
        this.dateTime = LocalDateTime.now();
        this.a = a;
        this.b = b;
        this.sum = sum;
    }
}
