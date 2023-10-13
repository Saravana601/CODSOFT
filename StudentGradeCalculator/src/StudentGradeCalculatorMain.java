import uiComponents.GradeCalculatorFrame;

import javax.swing.*;

public class StudentGradeCalculatorMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeCalculatorFrame frame = new GradeCalculatorFrame();
            frame.setVisible(true);
        });
    }

}