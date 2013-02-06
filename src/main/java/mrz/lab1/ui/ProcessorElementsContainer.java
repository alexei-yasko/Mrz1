package mrz.lab1.ui;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;

/**
 * @author Q-YAA
 */
public class ProcessorElementsContainer extends JPanel {

    private Box verticalBox;

    public ProcessorElementsContainer(List<ProcessorElementUi> processorElementsUi) {
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        verticalBox = Box.createVerticalBox();

        initializeContainer(processorElementsUi);

        add(verticalBox);
    }

    public void setElements(List<ProcessorElementUi> processorElementsUi) {
        verticalBox.removeAll();
        initializeContainer(processorElementsUi);
    }

    private void initializeContainer(List<ProcessorElementUi> processorElementsUi) {
        for (ProcessorElementUi processorElementUi : processorElementsUi) {
            verticalBox.add(Box.createVerticalStrut(20));
            verticalBox.add(processorElementUi);
        }
    }
}
