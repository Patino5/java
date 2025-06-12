import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameService game = new GameService(10, new RandomNumberGenerator());
        Scanner scanner = new Scanner(System.in);


        game.startGame();
        GuessResult guessResult = GuessResult.HIGHER;

        do {
            System.out.print("Enter a guess: ");
            int guess = Integer.parseInt(scanner.nextLine());
            guessResult = game.guess(guess);

            System.out.println(guessResult);
        } while(guessResult != GuessResult.WIN);

    }
}
