import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String number : line) {
            numbers.add(Integer.parseInt(number));
        }
        int n = scanner.nextInt();

        List<Integer> distances = new ArrayList<>();
        for (Integer number : numbers) {
            distances.add(Math.abs(number - n));
        }
        int minDistance = Collections.min(distances);
        List<Integer> closesInts = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (distances.get(i).equals(minDistance)) {
                closesInts.add(numbers.get(i));
            }
        }
        Collections.sort(closesInts);
        for (Integer i : closesInts) {
            System.out.print(i + " ");
        }

    }
}