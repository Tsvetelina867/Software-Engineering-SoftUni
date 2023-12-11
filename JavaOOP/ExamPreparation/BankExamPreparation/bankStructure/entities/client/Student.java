package BankExamPreparation.bankStructure.entities.client;

public class Student extends BaseClient{
    public Student(String name, String id, double income) {
        super(name, id, 2, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 1);
    }
}
