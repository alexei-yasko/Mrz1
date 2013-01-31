package mrz.lab1.processor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import mrz.lab1.binary.BinaryNumber;

/**
 * @author Q-YAA
 */
public class Processor {

    private static final String DIGIT_CAPACITY_PATTERN = "digitCapacity\\s*=\\s*(\\d+)";

    private static final String PROCESSING_ITEM_PATTERN = "\\[(\\d+)\\s*\\*\\s*(\\d+)\\]";

    private List<ProcessingItem> processingItems;

    private int digitCapacity;

    public Processor(String dataFile) {
        loadData(dataFile);
    }

    private void loadData(String dataFile) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(dataFile);
            String text = new String(IOUtils.toByteArray(inputStream));

            digitCapacity = loadDigitCapacity(text);
            processingItems = loadProcessingItems(text);

            int i = 0;
        }
        catch (FileNotFoundException e) {
            throw new IllegalStateException("Error when load data file.", e);
        }
        catch (IOException e) {
            throw new IllegalStateException("Error when load data file.", e);
        }
        finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    private int loadDigitCapacity(String text) {
        Pattern pattern = Pattern.compile(DIGIT_CAPACITY_PATTERN);
        Matcher matcher = pattern.matcher(text);
        matcher.find();

        return Integer.parseInt(matcher.group(1));
    }

    private List<ProcessingItem> loadProcessingItems(String text) {
        Pattern pattern = Pattern.compile(PROCESSING_ITEM_PATTERN);
        Matcher matcher = pattern.matcher(text);

        List<ProcessingItem> processingItems = new ArrayList<ProcessingItem>();
        while (matcher.find()) {
            BinaryNumber multiplicand = BinaryNumber.fromDecimalString(matcher.group(1), digitCapacity);
            BinaryNumber factor = BinaryNumber.fromDecimalString(matcher.group(2), digitCapacity);

            processingItems.add(new ProcessingItem(multiplicand, factor));
        }

        return processingItems;
    }
}
