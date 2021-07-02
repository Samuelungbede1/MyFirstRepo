import java.util.Scanner;

public class Cinema {
    //This function will display all the menu options
    public static void MenuDisplay() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "4. Exit");
    }

    //This function will carry out buy ticket
    public static void BuyTicketDisplay(char[][] seats) {

        //Asking for the user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int numRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int numCol = sc.nextInt();

        //checking if the input is greater than the number of seats
        if(numRow>seats.length || numCol>seats.length){
            System.out.println("sorry try again with available seat number");

        }

        // checking if the seat is available
        else if (seats[numRow][numCol] == 'S') {
            System.out.println("Ticket price: $10");
            seats[numRow-1][numCol-1] = 'T';
        } else {
            System.out.println("That ticket has already been purchased!");
            
        }

    }

    //This function will create  seats
    public static void SeatsDisplay(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }




    public static void main(String[] args) {
        //initializing important variables
        double percentage = 0;
        double currentIncome = 0;
        int count = 0;

        // collecting input for creating the cinema seats
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows size of seat:");
        int numRow = sc.nextInt();
        System.out.println("Enter the column size of the seats:");
        int numCol = sc.nextInt();

        //creating all the seats and populating it
        char[][] seats = new char[numRow][numCol];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats.length; j++) {
                seats[i][j] = 'S';
            }
        }

        // calling display menu option
        MenuDisplay();
        System.out.println("select an option");
        int numb = sc.nextInt();


        while (numb != 4) {
            if (numb == 1) {
                SeatsDisplay(seats);

            } else if (numb == 2) {
                BuyTicketDisplay(seats);
                count++;
                double divisor = numRow * numCol;
                percentage = (count / divisor) * 100;
                currentIncome = count * 10;

            } else if (numb == 3) {
                System.out.printf("1. Number of purchased tickets :" + count + " \n" +
                        "2. Percentage :" +percentage+"%"+"\n" +
                        "3. Current income :"+"$"+ currentIncome+ "\n" +
                        "4. Total income :"+"$"+ numRow * numCol * 10);

            } else {
                System.out.println("oops! Please, select a available option");
            }
            System.out.println("");
            System.out.println("");

                MenuDisplay();
                numb = sc.nextInt();
        }
        System.out.println("bye for now");
    }
}


// Create available seats in the cinema manually using a multidimensional array

// collect rows and column and check is the position is available i.e when the position is = 'S'


// if the position is == 'S' perform neccessary task and break from the loop remember to set the position to = 'B'

// if the postion is == "B" print seat has been collected and ask for a new input

    
