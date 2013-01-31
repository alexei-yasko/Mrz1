package mrz.lab1.processor;

/**
 * @author Q-YAA
 */
public class ShiftElement implements ProcessorElement {

    private int number;

    public ShiftElement(int number) {
        this.number = number;
    }

    @Override
    public void process(ProcessingItem processingItem) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return "Shift element";
    }

    @Override
    public int getNumber() {
        return number;
    }
}
