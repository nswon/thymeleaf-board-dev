package study.thymeleafstudy.domain.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.thymeleafstudy.global.entity.TimeEntity;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends TimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String writer;

    @Builder
    public Board(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
