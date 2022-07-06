package study.thymeleafstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import study.thymeleafstudy.entity.Board;

@Getter
@AllArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }

}
