package study.thymeleafstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import study.thymeleafstudy.entity.Board;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.createdDate = board.getCreatedDate();
        this.modifiedDate = board.getModifiedDate();
    }

}
