package BankExamPreparation.bank;


import BankExamPreparation.main.Bank;
import BankExamPreparation.main.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTests {

    @Test(expected = NullPointerException.class)
    public void settingName_NullShouldReturn_Exception() {
        new Bank("  ", 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void settingCapacity_LessThanZero_ShouldReturnException() {
        new Bank("DSK", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addClient_ShouldThrow_WhenCapacityIsReached() {
        Bank bank = new Bank("DSK", 0);
        bank.addClient(new Client("client"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeClient_ShouldThrow_IfPersonIsNotPresent() {
        Bank bank = new Bank("DSK", 2);
        bank.removeClient("client");
    }

    @Test
    public void loanWithdrawal_SetsApprovedProperly() {
        Bank bank = new Bank("DSK", 1);
        Client client = new Client("client");
        bank.addClient(client);
        bank.loanWithdrawal("client");

        assertFalse(client.isApprovedForLoan());
    }

    @Test
    public void testStatistics() {
        Bank bank = new Bank("DSK", 3);
        bank.addClient(new Client("Client"));
        bank.addClient(new Client("Client1"));
        bank.addClient(new Client("Client2"));

        String expected = "The client Client, Client1, Client2 is at the DSK BankUnitTesting.bank!";

        assertEquals(expected, bank.statistics());
    }

    @Test
    public void getCount_ShouldReturnCorrect_AfterAddingClient(){
        Bank bank = new Bank("DSK", 3);
        bank.addClient(new Client("client"));
        assertEquals(1, bank.getCount());
    }

    @Test
    public void getCount_ShouldReturnCorrect_AfterRemoving() {
        Bank bank = new Bank("DSK", 3);
        bank.addClient(new Client("client"));
        bank.removeClient("client");
        assertEquals(0, bank.getCount());
    }
}
