package com.example.noticehub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id; // 공지 고유 ID

    private String title; // 공지 제목
    private String content; // 공지 내용
    private String category; // 카테고리(학사, 장학 등)
    private String author; // 작성자
    private String postedDate; // 작성일

    // 생성자, 게터/세터 등
    public Notice(String title, String content, String category, String postedDate) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.postedDate = postedDate;
    }

}
