package mrz.lab1.processor;

import mrz.lab1.binary.BinaryNumber;

/**
 * @author Q-YAA
 */
public class Summator implements ProcessorElement {

    private int number;

    public Summator(int number) {
        this.number = number;
    }

    @Override
    public void process(ProcessingItem processingItem) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return "Summator element";
    }

    @Override
    public int getNumber() {
        return number;
    }
}
