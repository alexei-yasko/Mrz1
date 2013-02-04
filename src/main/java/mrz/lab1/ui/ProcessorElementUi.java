package mrz.lab1.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import mrz.lab1.processor.ProcessorElement;

/**
 * @author Q-YAA
 */
public class ProcessorElementUi extends JPanel {

    private ProcessorElement processorElement;

    public ProcessorElementUi(ProcessorElement processorElement) {
        this.processorElement = processorElement;

        setPreferredSize(new Dimension(400, 50));

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void setProcessorElement(ProcessorElement processorElement) {
        this.processorElement = processorElement;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;

        String elementName = String.format("%s (%s)", processorElement.getName(), processorElement.getNumber());
        graphics2D.drawString(elementName, 200, 30);

        if (processorElement.getState() != null) {
            g.drawString(processorElement.getState().getFactor().toString(), 20, 15);
            g.drawString(processorElement.getState().getMultiplicand().toString(), 20, 30);
            g.drawString(processorElement.getState().getPartialSum().toString(), 10, 45);
        }
    }
}
