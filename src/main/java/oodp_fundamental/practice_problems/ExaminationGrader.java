import java.util.*;

interface Question {
    double grade();
}

class MCQ implements Question {

    private String correctAnswer;
    private String studentAnswer;
    private double points;

    MCQ(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double grade() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TrueFalse implements Question {

    private String correctAnswer;
    private String studentAnswer;
    private double points;

    TrueFalse(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double grade() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class Essay implements Question {

    private String correctAnswer;
    private String studentAnswer;
    private double points;

    Essay(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double grade() {

        String[] keywords = correctAnswer.split(",");

        int count = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        }

        if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            List<String> values = new ArrayList<>();

            int start = -1;

            for (int j = 0; j < line.length(); j++) {

                if (line.charAt(j) == '"') {

                    if (start == -1) {
                        start = j + 1;
                    } 
                    else {
                        values.add(
                            line.substring(start, j)
                        );

                        start = -1;
                    }
                }
            }

            String type = line.split(" ", 2)[0];

            String questionText = values.get(0);
            String correctAnswer = values.get(1);
            String studentAnswer = values.get(2);

            String lastPart =
                line.substring(
                    line.lastIndexOf("\"") + 1
                ).trim();

            double points = Double.parseDouble(lastPart);

            Question question;

            if (type.equals("MCQ")) {

                question = new MCQ(
                    correctAnswer,
                    studentAnswer,
                    points
                );

            } 
            else if (type.equals("TF")) {

                question = new TrueFalse(
                    correctAnswer,
                    studentAnswer,
                    points
                );

            } 
            else {

                question = new Essay(
                    correctAnswer,
                    studentAnswer,
                    points
                );
            }

            double score = question.grade();

            System.out.printf(
                "%s: %.2f%n",
                type,
                score
            );

            total += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            total
        );

        sc.close();
    }
}
