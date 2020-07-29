import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfWords = Integer.parseInt(scanner.nextLine());
        Set<String> words = new TreeSet<>();
        for (int i = 0; i < numOfWords; i++) {
            words.add(scanner.nextLine());
        }
        words.forEach(System.out::println);
    }
}