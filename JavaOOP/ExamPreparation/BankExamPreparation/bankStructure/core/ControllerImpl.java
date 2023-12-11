package BankExamPreparation.bankStructure.core;

import BankExamPreparation.bankStructure.entities.bank.Bank;
import BankExamPreparation.bankStructure.entities.bank.BranchBank;
import BankExamPreparation.bankStructure.entities.bank.CentralBank;
import BankExamPreparation.bankStructure.entities.client.Adult;
import BankExamPreparation.bankStructure.entities.client.Client;
import BankExamPreparation.bankStructure.entities.client.Student;
import BankExamPreparation.bankStructure.entities.loan.Loan;
import BankExamPreparation.bankStructure.entities.loan.MortgageLoan;
import BankExamPreparation.bankStructure.entities.loan.StudentLoan;
import BankExamPreparation.bankStructure.repositories.LoanRepository;

import java.util.*;
import java.util.stream.Collectors;

import static BankExamPreparation.bankStructure.common.ConstantMessages.*;
import static BankExamPreparation.bankStructure.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private LoanRepository loans;
    private Map<String, Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new LinkedHashMap<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;
        switch (type) {
            case "BranchBank":
                bank = new BranchBank(name);
                break;
            case "CentralBank":
                bank = new CentralBank(name);
                break;
            default:
                throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }

        banks.put(name, bank);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        switch (type) {
            case "StudentLoan":
                loan = new StudentLoan();
                break;
            case "MortgageLoan":
                loan = new MortgageLoan();
                break;
            default:
                throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }
        loans.addLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loanNeeded = loans.findFirst(loanType);
        if (loanNeeded == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }
        banks.get(bankName).addLoan(loanNeeded);
        loans.removeLoan(loanNeeded);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;
        switch (clientType) {
            case "Student":
                client = new Student(clientName, clientID, income);
                break;
            case "Adult":
                client = new Adult(clientName, clientID, income);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }

        Bank bank = banks.get(bankName);
        String output = "";

        if (isSuitableBank(clientType, bank)) {
            bank.addClient(client);
            output = String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
        } else {
            output = UNSUITABLE_BANK;
        }

        return output;
    }

    private boolean isSuitableBank(String clientType, Bank bank) {
        String bankType = bank.getClass().getSimpleName();
        if (clientType.equals("Student") && bankType.equals("BranchBank")) {
            return true;
        } else if (clientType.equals("Adult") && bankType.equals("CentralBank")) {
            return true;
        }
        return false;
    }
    @Override
    public String finalCalculation(String bankName) {
        Bank bank = banks.get(bankName);
        double clientsIncome = bank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double loansAmount = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        double funds = clientsIncome + loansAmount;

        return String.format(FUNDS_BANK, bankName, funds);
    }

    @Override
    public String getStatistics() {
        return banks.values()
                .stream()
                .map(Bank::getStatistics)
                .collect(Collectors.joining(System.lineSeparator())).trim();
    }
}
