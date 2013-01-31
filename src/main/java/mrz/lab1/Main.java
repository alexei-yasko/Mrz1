package mrz.lab1;

import mrz.lab1.processor.Processor;

/**
 * @author Q-YAA
 */
public class Main {

    private static String DATA_FILE = "data/data.txt";

    public static void main(String[] args) {
        Processor processor = new Processor(DATA_FILE);
        processor.processData();
    }
}
