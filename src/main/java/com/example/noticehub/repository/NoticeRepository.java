package com.example.noticehub.repository;

import com.example.noticehub.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    // 필요에 따라 쿼리 메서드 추가 가능
    // 예: List<Notice> findByCategory(String category);
}