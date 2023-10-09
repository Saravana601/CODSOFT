import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGame extends JFrame implements ActionListener {

    private int randomNumber;
    private int attempts;
    private static final int MAX_ATTEMPTS = 10;
    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 500;
    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 200;

    private JTextField numberField;
    private JLabel feedbackLabel;
    private JLabel attemptsLabel;
    private JButton guessButton;
    private int score;


    NumberGuessingGame(){
        int frameWidth = FRAME_WIDTH;
        int frameHeight = FRAME_HEIGHT;
        setSize(frameWidth,frameHeight);
        setResizable(false);

        ImageIcon logo = new ImageIcon("logo.png");
        setIconImage(logo.getImage());

        ImageIcon backgroundImage = new ImageIcon("bglabel.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);

        setContentPane(backgroundLabel);

        JPanel centerPanel = getCenterPanel(frameWidth,frameHeight);
        backgroundLabel.add(centerPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        randomNumber = generateRandomNumber();
        attempts = 0;
    }

    // Setting Center Panel
    private JPanel getCenterPanel(int frameWidth, int frameHeight) {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);

        int panelWidth = PANEL_WIDTH;
        int panelHeight = PANEL_HEIGHT;
        int panelX = (frameWidth - panelWidth) / 2;
        int panelY  = (frameHeight - panelHeight) / 2;
        centerPanel.setBounds(panelX,panelY,panelWidth,panelHeight);

        centerPanel.setBackground(Color.WHITE);

        numberField = new JTextField();
        numberField.setBounds(100,30,200,30);
        centerPanel.add(numberField);

        guessButton = new JButton("Guess");
        guessButton.setBounds(150,70,100,30);
        guessButton.addActionListener(this);
        centerPanel.add(guessButton);

        feedbackLabel = new JLabel("");
        feedbackLabel.setBounds(100,100,700,30);
        centerPanel.add(feedbackLabel);

        attemptsLabel = new JLabel("[You've Only "+ MAX_ATTEMPTS +" Attempts to Guess]");
        attemptsLabel.setBounds(100,130,500,30);
        centerPanel.add(attemptsLabel);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(150,160,100,30);
        resetButton.addActionListener(e -> resetGame());
        centerPanel.add(resetButton);

        return centerPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberGuessingGame frame = new NumberGuessingGame();
            frame.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Guess")){
            String userInput = numberField.getText();
            try {
                int userGuess = Integer.parseInt(userInput);

                if(userGuess > 100 || userGuess < 0){
                    feedbackLabel.setText("Enter the number within 1 to 100.");
                }
                else if (userGuess == randomNumber) {
                    feedbackLabel.setText("Congratulations! You guessed the correct Number");
                    attempts++;
                    score = (MAX_ATTEMPTS - attempts) * 10;
                    attemptsLabel.setText("Your Score - " + score);
                } else {
                    String feedback = userGuess > randomNumber ? "Your guess is too high" : "Your guess is too low";
                    feedbackLabel.setText(feedback);
                    attempts++;
                    attemptsLabel.setText("Attempts - " +attempts);
                }

                if(attempts == MAX_ATTEMPTS){
                    disableGame(e);
                }
            }
            catch (NumberFormatException ex){
                feedbackLabel.setText("Please enter a valid number.");
            }
        }
    }

    // This method used to disable TextField and buttons when attempt reached MAX_ATTEMPTS
    private void disableGame(ActionEvent e){
        numberField.setEnabled(false);
        ((JButton) e.getSource()).setEnabled(false);
    }

    // It is used to reset the game to initial position
    private void resetGame(){
        randomNumber = generateRandomNumber();
        attempts = 0;
        feedbackLabel.setText("");
        attemptsLabel.setText("[You've Only "+ MAX_ATTEMPTS +" Attempts to Guess]");
        numberField.setText("");
        numberField.setEnabled(true);
        guessButton.setEnabled(true);
    }

    // It is used to generate a random Number within the range of 0 to 100
    public static int generateRandomNumber() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(101);
    }
}
