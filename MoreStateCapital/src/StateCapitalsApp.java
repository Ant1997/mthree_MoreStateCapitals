import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class StateCapitalsApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Scanner sc = null;

        Map<String, Capital> statesCapital = new HashMap<>();

        try {
            sc = new Scanner(new BufferedReader(new FileReader("src/MoreStateCapitals.txt")));
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] arrOfStr = currentLine.split("::", 4);

                Capital capital = new Capital();
                capital.setName(arrOfStr[1]);
                capital.setPopulation(arrOfStr[2]);
                capital.setSquareMileage(arrOfStr[3]);

                statesCapital.put(arrOfStr[0], capital);

                //for (String a : arrOfStr) {
                //    System.out.println(a);
                //}

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("50 STATE/CAPITAL PAIRS LOADED.");
        System.out.println("==============================");

        Set<String> keys = statesCapital.keySet();
        for (String k : keys) {
            System.out.println(k + " - " +
                    statesCapital.get(k).getName() + " | " +
                    "Pop: " + statesCapital.get(k).getPopulation() + " | " +
                    "Area: " + statesCapital.get(k).getSquareMileage() + " sq mi");
        }


        System.out.println("\nPlease enter the lower limit for capital city population:");
        String userInputPop = userInput.nextLine();
        System.out.println(userInputPop);
        System.out.println("\nLISTING CAPITALS WITH POPULATIONS GREATER THAN " + userInputPop + ":\n");
        for (String k : keys) {
            if (Float.parseFloat(statesCapital.get(k).getPopulation()) > (Float.parseFloat(userInputPop))) {
                System.out.println(k + " - " +
                        statesCapital.get(k).getName() + " | " +
                        "Pop: " + statesCapital.get(k).getPopulation() + " | " +
                        "Area: " + statesCapital.get(k).getSquareMileage() + " sq mi");
            }
        }


        System.out.println("\nPlease enter the upper limit for capital city sq mileage:");
        String userInputSquareMileage = userInput.nextLine();
        System.out.println("\nLISTING CAPITALS WITH AREAS LESS THAN " + userInputSquareMileage + ":\n");
        for (String k : keys) {
            if (Float.parseFloat(statesCapital.get(k).getSquareMileage()) < (Float.parseFloat(userInputSquareMileage))) {
                System.out.println(k + " - " +
                        statesCapital.get(k).getName() + " | " +
                        "Pop: " + statesCapital.get(k).getPopulation() + " | " +
                        "Area: " + statesCapital.get(k).getSquareMileage() + " sq mi");
            }
        }
    }
}
