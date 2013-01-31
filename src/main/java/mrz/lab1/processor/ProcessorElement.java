package mrz.lab1.processor;

/**
 * @author Q-YAA
 */
public interface ProcessorElement {

    void process(ProcessingItem processingItem);

    String getName();

    int getNumber();
}
