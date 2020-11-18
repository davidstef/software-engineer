package service.transaction;


import model.Transaction;
import repository.EntityNotFoundException;

import java.util.List;

public interface TransactionService {

    List<Transaction> findByUsername(String username) throws EntityNotFoundException;

    boolean save(Transaction transaction) throws EntityNotFoundException;

}
