package com.elcom.firstproject.postgresql.repository;

import com.elcom.firstproject.postgresql.dto.BorrowLogNameWithTime;
import com.elcom.firstproject.postgresql.model.BorrowLog;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BorrowLogRepository extends JpaRepository<BorrowLog, Long> {

    @Query(value = "select count(*) from borrow_log where borrow_date between ?1 and ?2", nativeQuery = true)
    Long countNumberOfBorrowLog(Date dateStart, Date dateEnd);

    @Query(
            name = "maxBorrowLogBook",
            nativeQuery = true
            )
    List<BorrowLogNameWithTime> listBorrowLogNameWithTime(Date dateStart, Date dateEnd);
}
