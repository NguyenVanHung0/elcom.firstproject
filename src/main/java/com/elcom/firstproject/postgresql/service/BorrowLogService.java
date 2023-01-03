
package com.elcom.firstproject.postgresql.service;

import com.elcom.firstproject.postgresql.dto.BorrowLogDto;
import com.elcom.firstproject.postgresql.dto.BorrowLogNameWithTime;
import com.elcom.firstproject.postgresql.dto.BorrowLogWithTime;
import java.util.List;


public interface BorrowLogService {
    BorrowLogDto createBorrowLog(BorrowLogDto borrowLogDto);
    BorrowLogDto updateBorrowLog(Long id, BorrowLogDto borrowLogDto);
    BorrowLogWithTime countBorrowLogWithTime(BorrowLogWithTime borrowLogWithTime);
    List<BorrowLogNameWithTime> maxBorrowLogBook(BorrowLogNameWithTime borrowLogNameWithTime);
}
