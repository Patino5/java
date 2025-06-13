import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> monthMap = new HashMap<>();
        monthMap.put(1, "January");
        monthMap.put(2, "February");
        monthMap.put(3, "March");
        monthMap.put(4, "April");
        monthMap.put(5, "May");
        monthMap.put(6, "June");
        monthMap.put(7, "July");
        monthMap.put(8, "August");
        monthMap.put(9, "September");
        monthMap.put(10, "October");
        monthMap.put(11, "November");
        monthMap.put(12, "December");

        // part 2. use a keySet method in a for loop to print all keys with their value
        for (Integer key : monthMap.keySet()){
            System.out.println("Month #" + key + " is " + monthMap.get(key));
        }

        // part 3. Create a HashMap<String, List<String>>
        Map<String, List<String>> deck = new HashMap<>();
        List<String> cardValues = Arrays.asList("Ace", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "Jack", "Queen", "King");

        deck.put("Hearts", new ArrayList<>(cardValues));
        deck.put("Diamonds",new ArrayList<>(cardValues));
        deck.put("Clubs", new ArrayList<>(cardValues));
        deck.put("Spades", new ArrayList<>(cardValues));

        for (String suit : deck.keySet()){
            List<String> values = deck.get(suit);
            for (String value : values){
                System.out.println(suit + " of " + value);
            }
        }

    }
}
