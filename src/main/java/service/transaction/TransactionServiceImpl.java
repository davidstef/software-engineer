package service.transaction;

import model.Transaction;
import repository.EntityNotFoundException;
import repository.transaction.TransactionRepository;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transaction> findByUsername(String username) throws EntityNotFoundException {
        return repository.findByUsername(username);
    }

    @Override
    public boolean save(Transaction transaction) throws EntityNotFoundException {
        return repository.save(transaction);
    }
}
