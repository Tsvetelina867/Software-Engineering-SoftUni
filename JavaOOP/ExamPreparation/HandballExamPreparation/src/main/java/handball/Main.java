package HandballExamPreparation.src.main.java.handball;


import HandballExamPreparation.src.main.java.handball.core.Engine;
import HandballExamPreparation.src.main.java.handball.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
