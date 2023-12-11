package BankExamPreparation.bankStructure.entities.bank;

import BankExamPreparation.bankStructure.entities.client.Client;
import BankExamPreparation.bankStructure.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static BankExamPreparation.bankStructure.common.ExceptionMessages.*;

public abstract class BaseBank implements Bank{
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    protected BaseBank(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return this.loans;
    }

    @Override
    public void addClient(Client client) {
        if (clients.size() < capacity) {
            this.clients.add(client);
            return;
        }
        throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CLIENT);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public String getStatistics() {
        return String.format("Name: %s, Type: %s%n", this.name, this.getClass().getSimpleName())
                + String.format("Clients: %s%n", getClients().isEmpty()
                ? "none"
                : this.getClients().stream().map(Client::getName).collect(Collectors.joining(", ")).trim())
                + String.format("Loans: %s, Sum of interest rates: %s", this.getLoans().size(), this.sumOfInterestRates());
    }
}
