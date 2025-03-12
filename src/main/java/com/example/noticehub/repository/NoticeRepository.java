package com.example.noticehub.repository;

import com.example.noticehub.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    // 카테고리별로 Notice를 조회
    List<Notice> findByCategory(String category);
}