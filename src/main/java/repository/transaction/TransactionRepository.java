package repository.transaction;

import model.Transaction;
import repository.EntityNotFoundException;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> findByUsername(String username) throws EntityNotFoundException;

    boolean save(Transaction transaction);

}
