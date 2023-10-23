//Task2 codsoft project #2
//programming in java to generate STUDENT GRADE CALCULATOR
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame {
    private JTextField[] subjectFields;
    private JTextArea resultArea;

    public StudentGradeCalculator() {
        // Set up the JFrame
        setTitle("Student Grade Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the input panel
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        JLabel[] subjectLabels = new JLabel[6];
        subjectFields = new JTextField[6];

        for (int i = 0; i < 6; i++) {
            subjectLabels[i] = new JLabel("Subject " + (i + 1) + " Marks: ");
            subjectFields[i] = new JTextField(10);
            inputPanel.add(subjectLabels[i]);
            inputPanel.add(subjectFields[i]);
        }

        // Create buttons
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());

        // Create a text area for displaying results
        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(calculateButton, BorderLayout.CENTER);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double totalMarks = 0;

            for (int i = 0; i < 6; i++) {
                try {
                    totalMarks += Double.parseDouble(subjectFields[i].getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for Subject " + (i + 1));
                    return;
                }
            }

            double averagePercentage = totalMarks / 6;
            String grade = calculateGrade(averagePercentage);

            resultArea.setText("Total Marks: " + totalMarks + "\n");
            resultArea.append("Average Percentage: " + averagePercentage + "%\n");
            resultArea.append("Grade: " + grade);
        }

        private String calculateGrade(double averagePercentage) {
            // You can define your grading criteria here and return the corresponding grade
            if (averagePercentage >= 90) {
                return "A+";
            } else if (averagePercentage >= 80) {
                return "A";
            } else if (averagePercentage >= 70) {
                return "B";
            } else if (averagePercentage >= 60) {
                return "C";
            } else {
                return "F";
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentGradeCalculator calculator = new StudentGradeCalculator();
            calculator.setVisible(true);
        });
    }
}
