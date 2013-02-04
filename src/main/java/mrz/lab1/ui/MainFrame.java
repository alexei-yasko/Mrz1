package mrz.lab1.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mrz.lab1.processor.Processor;
import mrz.lab1.processor.ProcessorElement;

/**
 * @author Q-YAA
 */
public class MainFrame extends JFrame {

    private static final String TITLE = "Mrz1";

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 700;

    private String dataFile;
    private Processor processor;

    private List<ProcessorElementUi> processorElementsUi;

    private JButton nextButton = new JButton("Next");
    private JButton refreshButton = new JButton("Refresh");

    private JLabel tactNumberLabel = new JLabel("");

    public MainFrame(String dataFile) {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle(TITLE);
        setLocationRelativeTo(null);

        this.dataFile = dataFile;
        processor = new Processor(dataFile);

        processorElementsUi = createProcessorElementsUi();
        add(new ProcessorElementsContainer(processorElementsUi), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        nextButton.addActionListener(new NextActionListener());
        buttonPanel.add(nextButton);
        refreshButton.addActionListener(new RefreshActionListener());
        buttonPanel.add(refreshButton);

        add(buttonPanel, BorderLayout.SOUTH);

        add(tactNumberLabel, BorderLayout.NORTH);
    }

    private List<ProcessorElementUi> createProcessorElementsUi() {
        List<ProcessorElementUi> processorElementsUi = new ArrayList<ProcessorElementUi>();
        for (ProcessorElement processorElement : processor.getProcessorElements()) {
            processorElementsUi.add(new ProcessorElementUi(processorElement));
        }

        return processorElementsUi;
    }

    private class NextActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!processor.isProcessingFinished()) {
                processor.nextTact();
            }
            else {
                nextButton.setEnabled(false);
            }

            tactNumberLabel.setText(String.format("Tact number: %s", processor.getTactNumber()));

            repaint();
        }
    }

    private class RefreshActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            processor = new Processor(dataFile);
            for (int i = 0; i < processor.getProcessorElements().size(); i++) {
                processorElementsUi.get(i).setProcessorElement(processor.getProcessorElements().get(i));
            }

            tactNumberLabel.setText("");
            nextButton.setEnabled(true);

            repaint();
        }
    }
}
