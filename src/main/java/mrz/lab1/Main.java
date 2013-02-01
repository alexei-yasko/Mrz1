package mrz.lab1;

import java.util.List;

import mrz.lab1.binary.BinaryNumber;
import mrz.lab1.processor.ProcessingItem;
import mrz.lab1.processor.Processor;

/**
 * @author Q-YAA
 */
public class Main {

    public static void main(String[] args) {
        String dataFile = args[0];
        //String dataFile = "data/data.txt";

        Processor processor = new Processor(dataFile);
        List<ProcessingItem> result = processor.processData();

        StringBuilder stringBuilder = new StringBuilder("\n------------------------- Result -------------------------\n");
        for (ProcessingItem processingItem : result) {
            stringBuilder.append("\n").append(processingItem.getFactor()).append(" (2) = ")
                .append(BinaryNumber.toInt(processingItem.getFactor())).append(" (10)\n")

                .append(processingItem.getMultiplicand()).append(" (2) = ")
                .append(BinaryNumber.toInt(processingItem.getMultiplicand())).append(" (10)\n")

                .append(processingItem.getPartialSum()).append(" (2) = ")
                .append(BinaryNumber.toInt(processingItem.getPartialSum())).append(" (10)\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
