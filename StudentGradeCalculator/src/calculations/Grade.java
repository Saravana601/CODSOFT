package calculations;

public class Grade {
    public long totalMark;
    public double average;
    public String grades;


    public Grade(int totalMark, double average, String grades) {
        this.totalMark = totalMark;
        this.average = average;
        this.grades = grades;
    }

    public long getTotalMark() {
        return totalMark;
    }

    public double getAverage() {
        return average;
    }

    public String getGrade() {
        return grades;
    }
}
