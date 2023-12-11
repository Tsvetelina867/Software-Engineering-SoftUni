package BankExamPreparation.bankStructure;

import BankExamPreparation.bankStructure.core.Engine;
import BankExamPreparation.bankStructure.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
