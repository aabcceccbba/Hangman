import java.util.Random;
import java.util.Scanner;

public class Hangman {
	
	public static void run() throws Exception {
		Random rand = new Random();
		int random = rand.nextInt(10);
		String word = HangmanLexicon.getWord(random);
//		System.out.println("test purpose: the random word is " + word);
		int lives = 8;
		String guess = "";
		for(int i = 0; i < word.length(); i++) {
			guess += "-";
		}
		
		System.out.println("Welcome to Hangman!");
		while(lives > 0 && !guess.equals(word)) {
			System.out.println("The word now looks like this: " + guess);
			System.out.println("You have " + lives + " guesses left.");
			System.out.println("Your guess: ");
			Scanner scan = new Scanner(System.in);
			String letter = scan.next().trim();
			while(letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
				letter = scan.next().trim();
			}
			char c = Character.toUpperCase(letter.charAt(0));
			
			if(word.indexOf(c) == -1) {
				System.out.println("There is no " + c + "'s in the word.");
				lives--;
			}
			else {
				System.out.println("That guess is correct.");
				for(int i = 0; i < word.length(); i++) {
					if(word.charAt(i) == c)
						guess = guess.substring(0, i) + c + guess.substring(i + 1);
				}
			}
		}
		
		if(lives == 0) {
			System.out.println("You're completely hung.\nThe word was: " + word + "\nYou lose.");;
		}
		else {
			System.out.println("That guess is correct.");
			System.out.println("You guessed the word: " + word);
			System.out.println("You win.");
		}
	}

	public static void main(String[] args) throws Exception {
		run();
	}
}
