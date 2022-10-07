import java.io.*;
import java.util.Arrays;

/*
 * @author Gregg
 * Simple Program for buying coffee
 */

class Main {
    // Buffer reader is more easy to use than scanner
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /*
     * Method for computing the change
     * @param money the money of the user
     * @param total the total price of item
     */
    static public double changeCalculation(double money, double total) {
        return money - total;
    }

    /*
     * Method for computing the price
     * @param quantity the quantity of the item
     * @param price the price of the item
     */
    static public double priceCalculation(int quantity, double price) {
        return price * quantity;
    }

    /*
     * Method for checking if an array contains a particular value
     * @param array the array
     * @param contains what the array should contains
     */
    static public boolean arrayHas(String[] array, String contains) {
        return Arrays.stream(array).anyMatch(contains::equals);
    }
    public static void main(String[] args) throws IOException {
        // Declaring the variable to use in the program
        Coffee coffee = new Coffee();
        String customerName, customerDay, menuYnN, customerOrder, size;
        double price = 0;
        double money;
        double change;
        int quantity;
        double total;

        // Array of object for coffee
        CoffeeCons[] lC = 
        {
            coffee.caffeLatte, 
            coffee.cappucino, 
            coffee.flatWhite, 
            coffee.americano,
            coffee.caramelMacchiato,
            coffee.caffeMocha,
            coffee.chocolateCappuccino,
            coffee.velvetVanillaLatte,
            coffee.signatureHotChocolate
        };

        // Boolean for yes or no
        boolean proceed = false;
        String[] yes = {"yes", "y"};

        // String[] no = {"no", "n"}; // Not required anymore

        System.out.println("\n ! Welcome to Gregg's Coffee Shop ! ");
        System.out.print("How are you doing today? ");
        customerDay = input.readLine();

        System.out.print("Do you wish to see the menu? (Y/N) ");
        menuYnN = input.readLine();

        // Checking if the user response yes or no
        if (arrayHas(yes, menuYnN)) {
            proceed = true;
            System.out.println();
            String menu;

            // Listing the menu
            System.out.println("! EXPRESSO & COFFEE !");
            for (int i = 0; i < lC.length; i++) {
                menu = String.format("%d. %s - (S) PHP %.2f (T) PHP %.2f (G) PHP %.2f", i + 1, lC[i].name, lC[i].pShort, lC[i].pTall, lC[i].pGrande);
                System.out.println(menu);
            }

            System.out.print("Please enter your order: ");
            customerOrder = input.readLine();

            // Checking if the customer order is within the menu
            for (int o = 0; o < lC.length; o++) {
                if (customerOrder.equalsIgnoreCase(lC[o].name)) {
                    System.out.printf("What would be the size of your %s: ", customerOrder);
                    size = input.readLine();
                    if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("s")) {
                        price = lC[o].pShort;
                    } else if (size.equalsIgnoreCase("tall") || size.equalsIgnoreCase("t")) {
                        price = lC[o].pTall;
                    }else if (size.equalsIgnoreCase("grande") || size.equalsIgnoreCase("g")) {
                        price = lC[o].pGrande;
                    }


                    System.out.printf("How many %s do you want? ", lC[o].name);
                    quantity = Integer.parseInt(input.readLine());

                    total = priceCalculation(quantity, price);

                    System.out.println(String.format("%d order of %s, The total amount to pay is: %.2f", quantity, lC[o].name, total));

                    System.out.print("How much money do you wish to pay? ");
                    money = Double.parseDouble(input.readLine());

                    // Checking if the user has sufficient money
                    if (money < total) {
                        System.out.println("Insufficient");
                        break;
                    }

                    System.out.print("Please enter your name before proceeding: ");
                    customerName = input.readLine();

                    change = changeCalculation(money, total);

                    System.out.printf("Your change is %.2f \n", change);
                    System.out.printf("Enjoy your %s day Mr/Mrs %s. Thank you for buying! ", customerDay, customerName);
                    break;
                } 

                // If the order isn't in the menu
                if (o + 1 == lC.length) {
                    System.out.println("Invalid");
                    proceed = false;
                    break;
                }
                
            }

        } 
        
        if (proceed == true) {

        } else {
            System.out.print("Thank you, please come again!");
        }

    }
}