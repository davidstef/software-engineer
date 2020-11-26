package service.report;

import model.Report;
import repository.EntityNotFoundException;

import java.util.List;

public interface ReportService {

    List<Report> findByUsernameAndPeriod(String username, Long start, Long end) throws EntityNotFoundException;

    boolean save(String username, String operation) throws EntityNotFoundException;

}
