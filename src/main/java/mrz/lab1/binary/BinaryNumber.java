package mrz.lab1.binary;

import java.util.Arrays;

import org.srplib.contract.Assert;

/**
 * @author Q-YAA
 */
public class BinaryNumber {

    private int digitCapacity;

    private byte[] digits;

    public BinaryNumber(int digitCapacity, byte[] digits) {
        Assert.checkTrue(digitCapacity == digits.length,
            "Digit capacity and number of the digit in the binary digits must be equal.");

        Assert.checkTrue(isDigitsValid(digits), "In the binary number digits must be equal to '1' or '0'.");

        this.digitCapacity = digitCapacity;
        this.digits = digits;
    }

    public static BinaryNumber sum(BinaryNumber first, BinaryNumber second, int digitCapacity) {
        return fromInt(toInt(first) + toInt(second), digitCapacity);
    }

    public static String digitsToString(BinaryNumber binaryNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte digit : binaryNumber.getDigits()) {
            stringBuilder.append(Byte.toString(digit));
        }

        return stringBuilder.toString();
    }

    public static int toInt(BinaryNumber binaryNumber) {
        return Integer.parseInt(digitsToString(binaryNumber), 2);
    }

    public static BinaryNumber getZero(int digitCapacity) {
        return new BinaryNumber(digitCapacity, new byte[digitCapacity]);
    }

    public static BinaryNumber fromBinaryString(String binaryString, int digitCapacity) {
        Assert.checkTrue(binaryString.length() <= digitCapacity, "Digit capacity too small.");

        byte[] digits = new byte[digitCapacity];
        int fromDigit = digitCapacity - binaryString.length();

        for (int i = fromDigit; i < digitCapacity; i++) {
            digits[i] = (byte) Character.getNumericValue(binaryString.charAt(i - fromDigit));
        }

        return new BinaryNumber(digitCapacity, digits);
    }

    public static BinaryNumber fromInt(int decimalNumber, int digitCapacity) {
        return fromBinaryString(Integer.toBinaryString(decimalNumber), digitCapacity);
    }

    public static BinaryNumber fromDecimalString(String decimalString, int digitCapacity) {
        return fromInt(Integer.parseInt(decimalString), digitCapacity);
    }

    public byte[] getDigits() {
        return digits;
    }

    public int getDigitCapacity() {
        return digitCapacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < digitCapacity; i++) {
            if (i != 0 && (digitCapacity - i) % 4 == 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(digits[i]);
        }

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BinaryNumber)) {
            return false;
        }

        BinaryNumber number = (BinaryNumber) o;

        if (digitCapacity != number.digitCapacity) {
            return false;
        }
        if (!Arrays.equals(digits, number.digits)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = digitCapacity;
        result = 31 * result + (digits != null ? Arrays.hashCode(digits) : 0);
        return result;
    }

    private boolean isDigitsValid(byte[] digits) {
        for (int i : digits) {
            if (i != 0 && i != 1) {
                return false;
            }
        }

        return true;
    }
}
