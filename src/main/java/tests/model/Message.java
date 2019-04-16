package tests.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Message {

    private UUID id;
    private long chatId;
    private String author;
    private String text;
    private LocalDateTime dateTime;

    public Message(long chatId, String author, String text) {
        this.id = randomUUID();
        this.chatId = chatId;
        this.author = author;
        this.text = text;
        this.dateTime = now();
    }
}
