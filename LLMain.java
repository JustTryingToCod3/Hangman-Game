package school;
import java.util.Scanner;

public class LLMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedBag<Character> bag = new LinkedBag<>();
		int score = 0;
		
		System.out.println("Welcome to the two player guessing game!");
		System.out.println("Player One: Enter a word");
		
		String mysteryWord = input.nextLine().toLowerCase().trim().replace(" ", "");		
		for (int i = 0; i < mysteryWord.length(); i++) {
			System.out.println("Guess A letter");
			char guess = input.next().toLowerCase().charAt(0);
			
			if(bag.contains(guess)) {
				System.out.println("You have already tried " + guess + ". You have lost this turn, please continue.");
			}
			bag.add(guess);
			
			if(mysteryWord.indexOf(guess) >= 0) {
				score ++;
				System.out.println("Good Job! " + guess + " Is correct!");
			}else {
				System.out.println("Sorry! " + guess + " Is incorrect!");	
				}
			
			StringBuilder hangMan = new StringBuilder();
			for (char letter : mysteryWord.toCharArray()) {
				if (bag.contains(letter)) {
					hangMan.append(letter);
				} else {
					hangMan.append('_');
				}
				hangMan.append(' ');
			}
			System.out.println(hangMan.toString().trim());
			
			if (hangMan.toString().trim().replace(" ", "").equals(mysteryWord)) {
				score = mysteryWord.length();
				System.out.println("Congrats you have guessed the word: " + mysteryWord);
				break;
			}
			
			}
		
		System.out.println("Your score " + score);
		
		if (score < mysteryWord.length()) {
			System.out.println("Game Over! The word was: " + mysteryWord);

		}
		input.close();
	}
}
