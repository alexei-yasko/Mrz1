package mrz.lab1.processor;

import org.junit.Assert;
import org.junit.Test;

import mrz.lab1.binary.BinaryNumber;

import static org.hamcrest.core.Is.is;

/**
 * @author Q-YAA
 */
public class ShiftElementTest {

    @Test
    public void testShift() {
        BinaryNumber partialSum = new BinaryNumber(8, new byte[] {1, 0, 1, 0, 1, 0, 0, 1});
        ProcessingItem processingItem = new ProcessingItem();
        processingItem.setPartialSum(partialSum);

        ShiftElement shiftElement = new ShiftElement(1);
        shiftElement.process(processingItem);

        Assert.assertThat(processingItem.getPartialSum().getDigits(), is(new byte[] {1, 1, 0, 1, 0, 1, 0, 0}));
    }

}
