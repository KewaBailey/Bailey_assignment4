
public class Application {

	public static void main(String[] args) {
		DuplicateCounter duplicateCounter =new DuplicateCounter();
		duplicateCounter.remove("problem2.txt");
		duplicateCounter.write("unique_word_counts.txt");

	}

}
