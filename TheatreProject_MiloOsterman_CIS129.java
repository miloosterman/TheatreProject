/*******************************************************************************************************************
  * TheatreProject_MiloOsterman_CIS129
  * Author: Milo Osterman
  * CIS 129 - Programming and Problem Solving I
  * Pima Community College
  ******************************************************************************************************************
  * This program allows a user to enter seats sold in different sections within a theatre.
  * The program will return the amount made in each section as well as the total amount made.
  ******************************************************************************************************************/

import java.util.*;
public class TheatreProject_MiloOsterman_CIS129{

  static Scanner keyboard = new Scanner(System.in);

  public static final String A = "Section A";
  public static final String B = "Section B";
  public static final String C = "Section C";

  public static final int SECTION_A_COST = 20;
  public static final int SECTION_B_COST = 15;
  public static final int SECTION_C_COST = 10;

  public static final int SECTION_A_SEATS = 300;
  public static final int SECTION_B_SEATS = 500;
  public static final int SECTION_C_SEATS = 200;

  public static final int MIN_VALUE = 0;

  public static void main(String args []){

    int soldInA;
    int soldInB;
    int soldInC;

    int sectionARevenue;
    int sectionBRevenue;
    int sectionCRevenue;
    int totalRevenue;

    int totalSeatsInA;
    int totalSeatsInB;
    int totalSeatsInC;

    soldInA = 0;
    soldInB = 0;
    soldInC = 0;

    introMessage();

//Get seats sold and then ask if they want to add more for each section.
    do {
    soldInA = getTotalSeats("Please enter the seats sold in " + A, SECTION_A_SEATS, soldInA);
  }
  while ( (soldInA != SECTION_A_SEATS) && IR.getYorN("Would you like to add more seats? (y/n)"));

    do {
    soldInB = getTotalSeats("Please enter the seats sold in " + B, SECTION_B_SEATS, soldInB);
  }
  while ((soldInB != SECTION_B_SEATS) && IR.getYorN("Would you like to add more seats? (y/n)"));

    do {
    soldInC = getTotalSeats("Please enter the seats sold in " + C, SECTION_C_SEATS, soldInC);
  }
  while ((soldInC != SECTION_C_SEATS) &&IR.getYorN("Would you like to add more seats? (y/n)"));



    sectionARevenue = calculateTotal(soldInA, SECTION_A_COST);
    sectionBRevenue = calculateTotal(soldInB, SECTION_B_COST);
    sectionCRevenue = calculateTotal(soldInC, SECTION_C_COST);
    totalRevenue = (sectionARevenue + sectionBRevenue + sectionCRevenue);

    displayTicketsSold(soldInA, A);
    displayTicketsSold(soldInB, B);
    displayTicketsSold(soldInC, C);

    displayResults(sectionARevenue, A);
    displayResults(sectionBRevenue, B);
    displayResults(sectionCRevenue, C);
    displayResults(totalRevenue, "all sections");


    endMessage();
  //End Main
  }

  public static void introMessage(){

    System.out.println(" _   _                _  ");
    System.out.println("| | | |              | |");
    System.out.println("| |_| |__   ___  __ _| |_ _ __ ___ ");
    System.out.println("| __| '_ \\ / _ \\/ _` | __| '__/ _ \\");
    System.out.println("| |_| | | |  __/ (_| | |_| | |  __/");
    System.out.println(" \\__|_| |_|\\___|\\__,_|\\__|_|  \\___|" + "\n");



    System.out.println("Hello, this theatre has three seating sections." + "\n");

    System.out.println("The theatre has: ");
    System.out.println("-----------------------------");
    System.out.println(SECTION_A_SEATS + " seats in " + A);
    System.out.println(SECTION_B_SEATS + " seats in " + B);
    System.out.println(SECTION_C_SEATS + " seats in " + C);

    System.out.println("-----------------------------");
    System.out.println(A + " seats cost $" + SECTION_A_COST + " each.");
    System.out.println(B + " seats cost $" + SECTION_B_COST + " each.");
    System.out.println(C + " seats cost $" + SECTION_C_COST + " each.");
    System.out.println("-----------------------------");

    System.out.println("You will be entering the number of tickets sold in each section.");
    System.out.println("The program will return the amount made in each section as well as the total amount made." + "\n");

  }

  //Gets user input and checks to see if it is valid.
  public static int getTotalSeats(String message, int maxSeats, int totalSeats){

    int seatsSold;

    seatsSold = IR.getInteger(message) + totalSeats;


    while (isInvalid(seatsSold, maxSeats)){
      seatsSold = IR.getInteger(message) + totalSeats;
    }

    if (seatsSold == maxSeats){
      System.out.println("You have now sold the maximum amount of seats in this section.");
    return seatsSold;
  }
    else{
    System.out.println("You have now sold " + seatsSold + " seats in this section.");
    System.out.println((maxSeats - seatsSold) + " seats remain.");
    return seatsSold;
  }
  }


  public static boolean isInvalid(int seatsSold, int maxSeats){

    if (seatsSold > maxSeats){
      System.out.println("There aren't that many seats available.");
      System.out.println("There are only " + maxSeats + " seats in this section.");
      return true;
    }

    if (seatsSold < MIN_VALUE){
      System.out.println("You have entered a negative value. Try again.");
      return true;
    }
    return false;

  }

  public static int calculateTotal(int seatsSold, int ticketCost){

    int totalCost;
    totalCost = (seatsSold * ticketCost);
    return totalCost;

  }

  public static void displayTicketsSold(int totalSeats, String section){

    System.out.println("You sold " + totalSeats + " tickets in " + section + ".");

  }
  //Display the output of tickets sold in each section and total.
  public static void displayResults(int sectionRevenue, String section){

    System.out.println("You made $" + sectionRevenue + " in " + section + ".");

  }

  public static void endMessage(){

    System.out.println("-----------------------------");
    System.out.println("Thank you for using the theatre ticket cost calculator.");
    System.out.println("Have a nice day.");

  }






}
