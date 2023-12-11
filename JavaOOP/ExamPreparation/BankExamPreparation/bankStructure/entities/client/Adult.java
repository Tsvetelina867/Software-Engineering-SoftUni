package BankExamPreparation.bankStructure.entities.client;

public class Adult extends BaseClient{
    public Adult(String name, String id, double income) {
        super(name, id, 4, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 2);
    }
}
