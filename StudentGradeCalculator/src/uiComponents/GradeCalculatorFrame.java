package uiComponents;

import calculations.Grade;
import calculations.GradeCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GradeCalculatorFrame extends JFrame implements ActionListener {
    private static final int FRAME_WIDTH = 1020;
    private static final int FRAME_HEIGHT = 800;

    public static JTextField[] markFields = new JTextField[5];

    public GradeCalculatorFrame(){

        // Initialize the frame
        initializeFrame();


        // It creates the text fields
        createTextField("Enter your mark1 :", 0);
        createTextField("Enter your mark2 :", 1);
        createTextField("Enter your mark3 :", 2);
        createTextField("Enter your mark4 :", 3);
        createTextField("Enter your mark5 :", 4);


        // calculate button
        JButton calculateButton = calculateButton();
        add(calculateButton);
    }

    public void initializeFrame(){
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setResizable(false);
        setTitle("Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Logo
        ImageIcon logo = new ImageIcon("logo.jpg");
        setIconImage(logo.getImage());

        // Background Image
        ImageIcon bgImage = new ImageIcon("bg.png");
        JLabel backgroundLabel = new JLabel(bgImage);
        backgroundLabel.setLayout(null);
        backgroundLabel.setBounds(0,0,FRAME_WIDTH,FRAME_HEIGHT);
        setContentPane(backgroundLabel);


        // Title
        JLabel title = new JLabel("Grade Calculator");
        title.setBounds(400,40,300,40);
        title.setForeground(new Color(184, 35, 241));
        Font titleFont = title.getFont();
        title.setFont(new Font(titleFont.getName(), Font.ITALIC,26));
        title.setSize(200,40);
        add(title);

        setLayout(null);
    }

    // This method creates text field
    private void createTextField(String labelText, int index){
        JPanel markPanel = new JPanel();
        markPanel.setLayout(new BorderLayout());
        markPanel.setBounds(350,100 + index * 70,300,50);

        // Label above the text field
        JLabel markLabel = new JLabel(labelText);
        markPanel.add(markLabel, BorderLayout.NORTH);

        // Text field
        markFields[index] = new JTextField();
        markFields[index].setBackground(Color.WHITE);
        markFields[index].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                markFields[index].setBackground(new Color(240, 198, 225));
            }

            @Override
            public void focusLost(FocusEvent e) {
                markFields[index].setBackground(Color.WHITE);
            }
        });
        markPanel.add(markFields[index], BorderLayout.CENTER);

        add(markPanel);
    }

    // creates calculate button
    private JButton calculateButton() {

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(450,470,100,40);
        calculateButton.setFont(Font.getFont(Font.SANS_SERIF));
        calculateButton.addActionListener(this);
        return calculateButton;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Calculate")){
            String[] userInput = new String[5];

            // flag to check the error
            boolean hasError = false;
            for(int i = 0; i < markFields.length; i++){
                userInput[i] = markFields[i].getText();

                try{
                    double mark = Double.parseDouble(userInput[i]);

                    // Here we're checking the mark that user entering is within the range of 0 to 100
                    if(!isValidMark(mark)){

                        // it shows the error message to user
                        JOptionPane.showMessageDialog(this,"Mark should be within 0 to 100" ,"Input error", JOptionPane.ERROR_MESSAGE);
                        markFields[i].setText("");
                        markFields[i].requestFocus();

                        // setting it to true, so it doesn't go next step
                        hasError = true;
                    }
                }

                // It gives an exception if the user input is not an integer
                catch(NumberFormatException ex){

                    // it shows the error message to user
                    JOptionPane.showMessageDialog(this,"Please enter valid numeric values", "Input error", JOptionPane.ERROR_MESSAGE);
                    markFields[i].setText("");
                    markFields[i].requestFocus();

                    hasError = true;
                }
            }


            // It allows to perform next step only when hasError is false;
            if(!hasError) {
                GradeCalculator gradeCalculator = new GradeCalculator(userInput);

                Grade grade = gradeCalculator.calculateResult();

                ResultFrame resultFrame = new ResultFrame(grade.totalMark, grade.average, grade.grades);
                resultFrame.setVisible(true);
            }
        }
    }

    // This method used to check the mark is valid or not
    private boolean isValidMark(double v) {
        return v >= 0 && v <= 100;
    }
}
