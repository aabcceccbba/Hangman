import java.awt.BorderLayout;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

import acm.io.IOConsole;
import acm.program.ConsoleProgram;

public class Hangman extends ConsoleProgram {
	
	private HangmanCanvas canvas;
	
	public void init() {
		canvas = new HangmanCanvas();
		 add(canvas);
		 canvas.reset();
	}
	
	public static void test(IOConsole console) {
        console.println("IOConsole class test");
        int n = console.readInt("Enter an integer: ");
        console.println("That integer was " + n);
        double d = console.readDouble("Enter a real number: ");
        console.println("That number was " + d);
        boolean b = console.readBoolean("Enter a boolean value: ");
        console.println("That value was " + b);
        String line = console.readLine("Enter a line: ");
        console.println("That line was \"" + line + "\"");
     }
	
	public void run() {
		Random rand = new Random();
		int random = rand.nextInt(10);
		HangmanLexicon hl = new HangmanLexicon();
		String word = "";
		try {
			word = hl.getWord(random);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test purpose: the random word is " + word);
		println("test purpose: the random word is " + word);
		int lives = 8;
		String guess = "";
		for(int i = 0; i < word.length(); i++) {
			guess += "-";
		}
		
		System.out.println("Welcome to Hangman!");
		this.println("Welcome to Hangman!");
		while(lives > 0 && !guess.equals(word)) {
//			System.out.println("The word now looks like this: " + guess);
			println("The word now looks like this: " + guess);
//			System.out.println("You have " + lives + " guesses left.");
			println("You have " + lives + " guesses left.");
//			System.out.println("Your guess: ");
			println("Your guess: ");
//			Scanner scan = new Scanner(System.in);
//			String letter = scan.next().trim();
			String letter = readLine("");
//			println("letter is: " + letter);
			// while the input is not a single char
			while(letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
				System.out.println("You could only input one single letter for each time! Try again:");
				letter = readLine("").trim();
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

	public static void main(String[] args) {
//		JFrame frame = new JFrame("IOConsole");
//		IOConsole console = new IOConsole();
//	    frame.getContentPane().add(BorderLayout.CENTER, console);
//	    frame.setSize(500, 300);
//	    frame.show();
//		test(console);
		Hangman hm = new Hangman();
		hm.init();
		
		hm.run();
	}
}
