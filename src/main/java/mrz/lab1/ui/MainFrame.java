package mrz.lab1.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mrz.lab1.processor.Processor;
import mrz.lab1.processor.ProcessorElement;

/**
 * @author Q-YAA
 */
public class MainFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 640;
    private static final int DEFAULT_HEIGHT = 740;

    private static final String TITLE = "Mrz1";

    private String dataFile;
    private Processor processor;

    private ProcessorElementsContainer processorElementsContainer;

    private JButton nextButton = new JButton("Next");
    private JButton refreshButton = new JButton("Refresh");

    private JLabel tactNumberLabel = new JLabel("");

    public MainFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle(TITLE);
        setLocationRelativeTo(null);

        processorElementsContainer = new ProcessorElementsContainer(Collections.<ProcessorElementUi>emptyList());
        JScrollPane scrollPane = new JScrollPane(processorElementsContainer);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        nextButton.addActionListener(new NextActionListener());
        nextButton.setEnabled(false);
        buttonPanel.add(nextButton);
        refreshButton.addActionListener(new RefreshActionListener());
        refreshButton.setEnabled(false);
        buttonPanel.add(refreshButton);
        JButton loadFileButton = new JButton("Load data");
        loadFileButton.addActionListener(new LoadDataFileActionListener());
        buttonPanel.add(loadFileButton);

        add(buttonPanel, BorderLayout.SOUTH);

        add(tactNumberLabel, BorderLayout.NORTH);
    }

    private List<ProcessorElementUi> createProcessorElementsUi(Processor processor) {
        List<ProcessorElementUi> processorElementsUi = new ArrayList<ProcessorElementUi>();
        for (ProcessorElement processorElement : processor.getProcessorElements()) {
            processorElementsUi.add(new ProcessorElementUi(processorElement));
        }

        return processorElementsUi;
    }

    private void refreshData() {
        processor = new Processor(dataFile);

        processorElementsContainer.setElements(createProcessorElementsUi(processor));

        nextButton.setEnabled(true);
        refreshButton.setEnabled(true);
        tactNumberLabel.setText("");

        MainFrame.this.validate();
        repaint();
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
            refreshData();
        }
    }

    private class LoadDataFileActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setDialogTitle("Choose data file");

            int flag = fileChooser.showDialog(MainFrame.this, "Load data");

            if (flag == JFileChooser.APPROVE_OPTION) {
                dataFile = fileChooser.getSelectedFile().getAbsolutePath();
            }

            refreshData();
        }
    }
}
