package mrz.lab1.binary;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Q-YAA
 */
public class BinaryNumberTest {

    @Test
    public void testDecimalIntToBinaryNumber() {
        int decimal = 14;

        BinaryNumber binaryNumber = BinaryNumber.fromInt(decimal, 4);

        Assert.assertThat(binaryNumber.toString(), is("1110"));
    }

    @Test
    public void testDecimalStringToBinaryNumber() {
        String decimal = "27";

        BinaryNumber binaryNumber = BinaryNumber.fromDecimalString(decimal, 6);

        Assert.assertThat(binaryNumber.toString(), is("01 1011"));
    }

    @Test
    public void testDecimalIntSmallToBinaryNumber() {
        int decimal = 1;

        BinaryNumber binaryNumber = BinaryNumber.fromInt(decimal, 8);

        Assert.assertThat(binaryNumber.toString(), is("0000 0001"));
    }

    @Test
    public void testSum() {
        BinaryNumber first = new BinaryNumber(4, new byte[] {1, 1, 1, 0});
        BinaryNumber second = new BinaryNumber(4, new byte[] {1, 1, 1, 1});

        BinaryNumber result = BinaryNumber.sum(first, second, 8);

        Assert.assertThat(result.toString(), is("0001 1101"));
    }

}
