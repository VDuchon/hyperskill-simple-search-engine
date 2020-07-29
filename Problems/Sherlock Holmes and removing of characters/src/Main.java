import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine().toLowerCase();
        String word2 = scanner.nextLine().toLowerCase();
        int toRemove = 0;

        Map<Character, Integer> wordMap1 = new HashMap<>(createWordMap(word1));
        Map<Character, Integer> wordMap2 = new HashMap<>(createWordMap(word2));

        for (Character character : wordMap1.keySet()) {
            if (!wordMap2.containsKey(character)) {
                toRemove += wordMap1.get(character);
            } else {
                toRemove += Math.abs(wordMap1.get(character) - wordMap2.get(character));
            }
        }

        for (Character character : wordMap2.keySet()) {
            if (!wordMap1.containsKey(character)) {
                toRemove += wordMap2.get(character);
            }
        }

        System.out.println(toRemove);
    }

    static Map<Character, Integer> createWordMap(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Integer> wordMap = new HashMap<>();

        for (char character : chars) {
            if (wordMap.containsKey(character)) {
                wordMap.replace(character, wordMap.get(character) + 1);
            } else {
                wordMap.put(character, 1);
            }
        }
        return wordMap;
    }
}