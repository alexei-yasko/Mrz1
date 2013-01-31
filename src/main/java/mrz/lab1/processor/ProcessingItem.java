package mrz.lab1.processor;

import mrz.lab1.binary.BinaryNumber;

/**
 * @author Q-YAA
 */
public class ProcessingItem {

    private BinaryNumber multiplicand;

    private BinaryNumber factor;

    private BinaryNumber partialSum;

    public ProcessingItem(BinaryNumber multiplicand, BinaryNumber factor) {
        this.multiplicand = multiplicand;
        this.factor = factor;
        this.partialSum = BinaryNumber.getZero(factor.getDigitCapacity() + multiplicand.getDigitCapacity() + 1);
    }

    public BinaryNumber getFactor() {
        return factor;
    }

    public BinaryNumber getMultiplicand() {
        return multiplicand;
    }

    public BinaryNumber getPartialSum() {
        return partialSum;
    }

    public void setPartialSum(BinaryNumber partialSum) {
        this.partialSum = partialSum;
    }
}
