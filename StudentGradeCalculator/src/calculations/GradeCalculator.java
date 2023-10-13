package calculations;

public class GradeCalculator {

    private int[] userInputs = new int[5];

    public GradeCalculator(String[] userInput){

        // Converting the String input to Integer
        for(int i = 0; i < userInput.length; i++){
            userInputs[i] = Integer.parseInt(userInput[i]);
        }

    }

    public Grade calculateResult(){

        int totalMark = 0;
        for(int inputValue : userInputs) {
            totalMark += inputValue;
        }

        // Finds average using total mark
        double average = (double) totalMark / 5;

        String grades;

        /* Assign the grade based on average */
        if(average >= Constants.GRADE_O_Min){
            grades = "O";
        }
        else if (average >= Constants.GRADE_A_PLUS_Min) {
            grades = "A+";
        }
        else if (average >= Constants.GRADE_A_MIN){
            grades = "A";
        }
        else if (average >= Constants.GRADE_B_PLUS_MIN){
            grades = "B+";
        }
        else if(average >= Constants.GRADE_B_MIN){
            grades = "B";
        }
        else{
            grades = "F";
        }

        return new Grade(totalMark,average,grades);
    }
}
