package uiComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import static uiComponents.GradeCalculatorFrame.markFields;

public class ResultFrame extends JFrame {

    public ResultFrame(long totalMark, double average, String grade){
        setTitle("Result");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        // Setting background image
        ImageIcon imageIcon = new ImageIcon("BackImg.jpg");
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setBounds(0,0,500,300);
        setContentPane(backgroundLabel);


        JPanel totalMarkPanel = createPanel(200,60,"Total Mark: " + totalMark);
        JPanel averagePanel = createPanel(200,110,"Average: " + average + " %");
        JPanel gradePanel = createPanel(200,160,"Grade: " + grade);
        JPanel resetPanel = createResetPanel();


        add(totalMarkPanel);
        add(averagePanel);
        add(gradePanel);
        add(resetPanel);

        // It ensures that when user clicks the close button ('X'), the text fields are reset.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                resetFields(); // Resetting text fields on window close
            }
        });
    }

    private JPanel createPanel(int x, int y, String labelText) {
        JPanel panel = new JPanel();
        panel.setBounds(160,y,170,40);
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD,18));
        panel.add(label);
        return panel;
    }

    private JPanel createResetPanel() {
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetFields());
        JPanel resetPanel = new JPanel();
        resetPanel.add(resetButton);
        resetPanel.setBounds(200,200,100,40);
        return resetPanel;
    }

    // This method reset's the text field
    private void resetFields() {
        for(int i = 0; i < 5; i++) {
            markFields[i].setText("");
        }
        dispose();
    }
}
