package mrz.lab1.processor;

import org.junit.Assert;
import org.junit.Test;

import mrz.lab1.binary.BinaryNumber;

import static org.hamcrest.core.Is.is;

/**
 * @author Q-YAA
 */
public class SummatorElement {

    @Test
    public void testFirstSum() {
        BinaryNumber first = BinaryNumber.fromInt(14, 4);
        BinaryNumber second = BinaryNumber.fromInt(15, 4);

        BinaryNumber result = BinaryNumber.sum(first, second, 9);

        Assert.assertThat(BinaryNumber.toInt(result), is(29));
    }

}
