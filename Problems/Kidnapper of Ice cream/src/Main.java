import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s");
        String[] neededWords = scanner.nextLine().split("\\s");
        boolean busted = false;

        Map<String, Integer> availableWords = new HashMap<>();
        for (String word : words) {
            if (!availableWords.containsKey(word)) {
                availableWords.put(word, 1);
            } else {
                int count = availableWords.get(word);
                availableWords.put(word, count + 1);
            }
        }

        for (String word : neededWords) {
            if (!availableWords.containsKey(word)) {
                busted = true;
                break;
            } else {
                int count = availableWords.get(word);
                if (count == 1) {
                    availableWords.remove(word);
                } else {
                    availableWords.put(word, count - 1);
                }
            }
        }

        if (busted) {
            System.out.println("You are busted");
        } else {
            System.out.println("You get money");
        }

    }
}
