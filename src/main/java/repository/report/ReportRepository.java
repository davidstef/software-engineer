package repository.report;

import model.Report;
import repository.EntityNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface ReportRepository {

    boolean save(Report report) throws EntityNotFoundException;

    List<Report> findByUsernameAndPeriod(String username, Long start, Long end) throws EntityNotFoundException;

}
