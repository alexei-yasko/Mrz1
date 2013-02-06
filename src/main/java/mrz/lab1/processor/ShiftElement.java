package mrz.lab1.processor;

import mrz.lab1.binary.BinaryNumber;

/**
 * @author Q-YAA
 */
public class ShiftElement implements ProcessorElement {

    private int number;

    private ProcessingItem state;

    public ShiftElement(int number) {
        this.number = number;
    }

    @Override
    public void process(ProcessingItem processingItem) {
        BinaryNumber partialSum = processingItem.getPartialSum();

        byte[] digits = partialSum.getDigits();
        byte[] shiftDigits = new byte[digits.length];

        System.arraycopy(digits, 0, shiftDigits, 1, digits.length - 1);
        shiftDigits[0] = digits[digits.length - 1];

        processingItem.setPartialSum(new BinaryNumber(partialSum.getDigitCapacity(), shiftDigits));

        state = processingItem;
    }

    @Override
    public String getName() {
        return "Shift element";
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public ProcessingItem getState() {
        return state;
    }

    @Override
    public void setState(ProcessingItem processingItem) {
        state = processingItem;
    }
}
