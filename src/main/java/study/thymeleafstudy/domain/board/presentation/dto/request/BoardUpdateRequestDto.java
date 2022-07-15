package study.thymeleafstudy.domain.board.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardUpdateRequestDto {

    private String title;
    private String content;
    private String writer;

    @Builder
    public BoardUpdateRequestDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
