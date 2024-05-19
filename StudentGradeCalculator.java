import java.util.Scanner;

public class StudentGradeCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++)
        {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            totalMarks += scanner.nextInt();
        }
        
        double averagePercentage = totalMarks / (double) numSubjects;
        
        char grade = averagePercentage >= 90 ? 'A' : 
                     averagePercentage >= 80 ? 'B' : 
                     averagePercentage >= 70 ? 'C' :
                     averagePercentage >= 60 ? 'D' : 'F';
        
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
