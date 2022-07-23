package service;

import exceptions.CustomerNotFoundException;

import java.util.UUID;

public interface TransactionService {
    String printTransactionInvoice(UUID customerId, UUID cartId) throws CustomerNotFoundException;
    void makeTransactions(UUID customerId, UUID cartId) throws CustomerNotFoundException;

}
