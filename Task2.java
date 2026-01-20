import java.util.Scanner;

public class Task2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of subjects:");
        int num=sc.nextInt();
        int total=0;
        for(int i=1;i<=num;i++){
            System.out.print("Enter mark of subject "+i+": ");
            int mark=sc.nextInt();
            total+=mark;
        }
        double avg=total/num;
        char grade;
        if (avg >= 90) {
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        } else if (avg >= 70) {
            grade = 'C';
        } else if (avg >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\n------RESULT------");
        System.out.println("Total Marks: "+total);
        System.out.println("Average Marks: "+avg);
        System.out.println("Grade: "+grade);

        sc.close();
    }
}