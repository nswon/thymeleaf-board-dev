package study.thymeleafstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.thymeleafstudy.entity.Board;

@Getter
public class BoardRequestDto {

    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

    @Builder
    public BoardRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
