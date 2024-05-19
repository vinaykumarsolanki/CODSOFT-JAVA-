import java.util.Random;
import java.util.Scanner;

public class NumberGame
{
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in)) 
        {
            Random generator = new Random();
            int attemptsAllowed = 7;
            boolean replay = true;
            
            while (replay)
            {
                int target = generator.nextInt(100) + 1;
                System.out.println("Guess the hidden number between 01 and 100:");
                for (int attempt = 1; attempt <= attemptsAllowed; attempt++) {
                    int guess = input.nextInt();
                    if (guess == target)
                    {
                        System.out.println("Congratulations! You've exposed the mystery in " + attempt + " attempts.");
                        break;
                    } else if (guess < target) {
                        System.out.println("Too low! Keep thinking.");
                    } else {
                        System.out.println("Too high! Make a tricky guess.");
                    }
                    if (attempt == attemptsAllowed) {
                        System.out.println("Sorry, you've exhausted all attempts. The mystery number was " + target + ".");
                    }
                }
                System.out.println("Want another round? (Of course/nope)");
                replay = input.next().equalsIgnoreCase("yes");
            }
            System.out.println("End of the game. Hope you enjoyed the mysteries!");
        }
    }
}
