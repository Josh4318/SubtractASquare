//Subtract a square game coursework

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubtractASquare {
    public static void main(String[] args) {

        //Create array for heaps
        Integer[] heapArray = new Integer[]{13, 13, 13};
        ArrayList<Integer> heaps = new ArrayList<>(Arrays.asList(heapArray));

        //create array for square numbers
        final Integer[] numArray = new Integer[]{1, 4, 9};
        final ArrayList<Integer> SQUARE_NUMBERS = new ArrayList<>(Arrays.asList(numArray));

        boolean player = false; //sets player 1 as starting player

        int heap;
        int amount;
        Scanner in = new Scanner(System.in);


        do {

            int playerInt = (player ? 1 : 0) + 1; // Convert boolean to player number
            System.out.printf("Remaining coins: %d, %d, %d%n",
                    heaps.get(0), heaps.get(1), heaps.get(2));

            do {
                System.out.printf("Player %d: choose a heap: ", playerInt);
                while (!in.hasNextInt()) {
                    in.next();
                    System.out.println("Sorry you must enter an integer or skip.");
                    System.out.printf("Player %d: choose a heap: ", playerInt);
                    in.nextLine();
                }
                heap = in.nextInt();

                //Checks if integer is outside boundaries and sends error message if it is
                if ((!(heap >= 1 && heap <= 3)) || (heaps.get(heap - 1) == 0)) {
                    System.out.println("Sorry, that's not a legal heap choice.");
                }

                //checks input is 1-3 and heap isn't 0
            } while ((!(heap >= 1 && heap <= 3)) || (heaps.get(heap - 1) == 0));

            do {
                System.out.print("Now choose a square number of coins: ");
                while (!in.hasNextInt()) {
                    in.next();
                    System.out.println("Sorry you must enter an integer.");
                    System.out.print("Now choose a square number of coins: ");
                    in.nextLine();
                }
                amount = in.nextInt();

                //Checks if integer is a square number and sends error message if it is
                if ((!SQUARE_NUMBERS.contains(amount)) || (amount > heaps.get(heap - 1))) {
                    System.out.println("Sorry that's not a legal number of coins for that heap.");
                }

                //checks input is a square number and smaller or equal to the number in heap
            } while ((!SQUARE_NUMBERS.contains(amount)) || (amount > heaps.get(heap - 1)));

            heaps.set(heap - 1, heaps.get(heap - 1) - amount); // sets new heap amount

            player = !player; //switches player

            //Will loop until all 3 heaps equal 0
        } while (heaps.get(0) != 0 || heaps.get(1) != 0 || heaps.get(2) != 0);

        if (player) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}
