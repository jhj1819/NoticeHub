package com.example.noticehub.service;

import com.example.noticehub.domain.Notice;
import com.example.noticehub.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    // 생성자 주입 방식
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    // 공지사항 전체 조회
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    // 공지사항 단건 조회
    public Notice getNotice(Long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 공지를 찾을 수 없습니다. ID: " + id));
    }

    // 공지사항 저장
    public Notice saveNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    // 공지사항 삭제
    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    // 카테고리별 조회
    public List<Notice> getNoticesByCategory(String category) {
        return noticeRepository.findByCategory(category);
    }
}