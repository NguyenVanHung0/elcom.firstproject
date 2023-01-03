package com.elcom.firstproject.postgresql.service.imp;

import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.exception.NoSuchElementException;
import com.elcom.firstproject.postgresql.dto.BorrowLogDto;
import com.elcom.firstproject.postgresql.dto.BorrowLogNameWithTime;
import com.elcom.firstproject.postgresql.dto.BorrowLogWithTime;
import com.elcom.firstproject.postgresql.model.BorrowLog;
import com.elcom.firstproject.postgresql.repository.BorrowLogRepository;
import com.elcom.firstproject.postgresql.service.BorrowLogService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowLogServiceImp implements BorrowLogService {

    @Autowired
    BorrowLogRepository borrowLogRepository;

    @Autowired
    Mapper mapper;


    @Override
    public BorrowLogDto createBorrowLog(BorrowLogDto borrowLogDto) {
        BorrowLog borrowLog = new BorrowLog();
        if (borrowLogDto != null) {
            borrowLog = mapper.toBorrowLog(borrowLogDto);
            borrowLogRepository.save(borrowLog);
        }
        return mapper.toBorrowLogDto(borrowLog);
    }

    @Override
    public BorrowLogDto updateBorrowLog(Long id, BorrowLogDto borrowLogDto) {
        BorrowLog borrowLog = new BorrowLog();
        if (borrowLogDto != null) {
            BorrowLog borrowLogOld = borrowLogRepository.findById(id).orElse(null);
            if (borrowLogOld != null) {
                borrowLog = mapper.toBorrowLog(borrowLogOld, borrowLogDto);
                borrowLogRepository.save(borrowLog);
                return mapper.toBorrowLogDto(borrowLog);
            }
            throw new NoSuchElementException("ban ghi muon sach khong ton tai");

        }
        return mapper.toBorrowLogDto(borrowLog);
    }

    @Override
    public BorrowLogWithTime countBorrowLogWithTime(BorrowLogWithTime borrowLogWithTime) {
        try {
            borrowLogWithTime.setCount(borrowLogRepository.countNumberOfBorrowLog(new SimpleDateFormat("yyyy-MM-dd").parse(borrowLogWithTime.getDateStart()), new SimpleDateFormat("yyyy-MM-dd").parse(borrowLogWithTime.getDateEnd())));
            return borrowLogWithTime;
        } catch (ParseException ex) {
            Logger.getLogger(BorrowLogServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<BorrowLogNameWithTime> maxBorrowLogBook(BorrowLogNameWithTime borrowLogNameWithTime) {
        try {
            List<BorrowLogNameWithTime> listBorrowLogNameWithTime = new ArrayList<>();
            listBorrowLogNameWithTime = borrowLogRepository.listBorrowLogNameWithTime(new SimpleDateFormat("yyyy-MM-dd").parse(borrowLogNameWithTime.getDateStart()), new SimpleDateFormat("yyyy-MM-dd").parse(borrowLogNameWithTime.getDateEnd()));
            for (BorrowLogNameWithTime borrowLogNameWithTime1 : listBorrowLogNameWithTime) {
                borrowLogNameWithTime1.setDateStart(borrowLogNameWithTime.getDateStart());
                borrowLogNameWithTime1.setDateEnd(borrowLogNameWithTime.getDateEnd());
           }
            return listBorrowLogNameWithTime;
        } catch (ParseException ex) {
            Logger.getLogger(BorrowLogServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
