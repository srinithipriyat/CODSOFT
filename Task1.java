import java.util.Random;
import java.util.Scanner;

public class Task1{
    public static void main(String[] args){ 
    Scanner sc=new Scanner(System.in);
    Random r=new Random();

    int score=0;
    char again;

    do{
        int num=r.nextInt(100)+1;
        int max=5;
        boolean guessed=false;
        System.out.println("\nThe Game is to guess a number between 1-100 that have been generated...");
        System.out.println("You have "+max+" attempts to guess the number!");
        for(int i=1;i<=max;i++){
            System.out.print("Attempt "+i+": Enter your guess:");
            int guess=sc.nextInt();
            if(guess==num){
                System.out.println("Congratulations! You guessed it right!!!");
                guessed=true;
                score++;
                break;
            }
            else if(guess>num){
                System.out.println("Too high!");
            }
            else{
                System.out.println("Too Low!");
            }
        }
        if(!guessed){
            System.out.println("Oops! You are out of attempts...The number was: "+num);
        }
        System.out.println("\nDo you want to play again(Y/N): ");
        again=sc.next().charAt(0);
    }while(again=='y' || again=='Y');
    System.out.println("\nGame Over! Thanks for playing...");
    System.out.println("Your Score(rounds won) is: "+score);
    sc.close();
    }
}