import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String number : line) {
            numbers.add(Integer.parseInt(number));
        }

        for (int i = 0; i < numbers.size(); i++) {
            numbers.remove(i);
        }
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}