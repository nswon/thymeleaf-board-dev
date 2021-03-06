package study.thymeleafstudy.domain.board.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import study.thymeleafstudy.domain.board.domain.Board;

@Getter
public class BoardRequestDto {

    private String title;
    private String content;
    private String writer;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

    @Builder
    public BoardRequestDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
