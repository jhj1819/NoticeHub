package com.example.noticehub;

import com.example.noticehub.domain.Notice;
import com.example.noticehub.repository.NoticeRepository;
import com.example.noticehub.service.NoticeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NoticeServiceTest {

    private NoticeRepository noticeRepository;
    private NoticeService noticeService;

    @BeforeEach
    void setUp() {
        // Mock(가짜) Repository 생성
        noticeRepository = Mockito.mock(NoticeRepository.class);
        // Service에 주입
        noticeService = new NoticeService(noticeRepository);
    }

    @Test
    void testSaveNotice() {
        // given
        Notice notice = new Notice("Title", "Content", "Category", "2025-03-14");
        // save 로직이 호출되면, 동일한 Notice 객체가 반환된다고 가정(Stubbing)
        Mockito.when(noticeRepository.save(notice)).thenReturn(notice);

        // when
        Notice saved = noticeService.saveNotice(notice);

        // then
        assertNotNull(saved);
        assertEquals("Title", saved.getTitle());
        Mockito.verify(noticeRepository, Mockito.times(1)).save(notice);
    }

    @Test
    void testGetNotice() {
        // given
        Notice notice = new Notice("Title", "Content", "Category", "2025-03-14");
        notice.setId(1L);
        Mockito.when(noticeRepository.findById(1L)).thenReturn(Optional.of(notice));

        // when
        Notice found = noticeService.getNotice(1L);

        // then
        assertNotNull(found);
        assertEquals("Title", found.getTitle());
        Mockito.verify(noticeRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void testGetNoticeNotFound() {
        // given
        Mockito.when(noticeRepository.findById(99L)).thenReturn(Optional.empty());

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            noticeService.getNotice(99L);
        });
    }
}