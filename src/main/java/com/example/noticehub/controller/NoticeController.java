package com.example.noticehub.controller;

import com.example.noticehub.domain.Notice;
import com.example.noticehub.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // 공지사항 전체 조회
    @GetMapping
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

    // 공지사항 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<Notice> getNotice(@PathVariable Long id) {
        Notice notice = noticeService.getNotice(id);
        return new ResponseEntity<>(notice, HttpStatus.OK);
    }

    // 공지사항 생성
    @PostMapping
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        Notice saved = noticeService.saveNotice(notice);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // 공지사항 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Notice>> getNoticesByCategory(@PathVariable String category) {
        List<Notice> notices = noticeService.getNoticesByCategory(category);
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }
}
