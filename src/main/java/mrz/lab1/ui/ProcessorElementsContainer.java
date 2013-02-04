package mrz.lab1.ui;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;

/**
 * @author Q-YAA
 */
public class ProcessorElementsContainer extends JPanel {

    public ProcessorElementsContainer(List<ProcessorElementUi> processorElementsUi) {
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Box verticalBox = Box.createVerticalBox();
        for (ProcessorElementUi processorElementUi : processorElementsUi) {
            verticalBox.add(Box.createVerticalStrut(20));
            verticalBox.add(processorElementUi);
        }

        add(verticalBox);
    }
}
