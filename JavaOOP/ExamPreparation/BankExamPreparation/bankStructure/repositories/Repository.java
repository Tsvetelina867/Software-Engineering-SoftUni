package BankExamPreparation.bankStructure.repositories;

import BankExamPreparation.bankStructure.entities.loan.Loan;

public interface Repository {

    void addLoan(Loan loan);

    boolean removeLoan(Loan loan);

    Loan findFirst(String type);
}
