package com.company;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;




public class Main {



    public static void main(String[] args) throws IOException {





        Cabin[] shipCabins = new Cabin[12];

        shipCabins[0] = new Cabin();
        shipCabins[1] = new Cabin();
        shipCabins[2] = new Cabin();
        shipCabins[3] = new Cabin();
        shipCabins[4] = new Cabin();
        shipCabins[5] = new Cabin();
        shipCabins[6] = new Cabin();
        shipCabins[7] = new Cabin();
        shipCabins[8] = new Cabin();
        shipCabins[9] = new Cabin();
        shipCabins[10] = new Cabin();
        shipCabins[11] = new Cabin();

        int roomNum = 0;

        initialise(shipCabins);



            while (true) {
                System.out.println();
                System.out.println("Hello and Welcome to our Hotel Program\nPlease keep hands and feet in the vehicle at all time.");
                System.out.println();
                System.out.println("Please select one of the options.");
                System.out.println();
                System.out.println("A: Book A New Room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("E: Display Empty Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("V: View all Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("D: Delete customer from room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("F: Find room from customer name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("S: Store program data in to file.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("L: Load program data from file.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("O: View rooms Ordered alphabetically by name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println();


                Scanner input = new Scanner(System.in);
                System.out.print(" Enter your Optin here :");
                String Selection =input.nextLine();


                Selection = Selection.toUpperCase();

                switch (Selection){
                    case "A":
                        BookARoom(shipCabins, roomNum);
                        break;
                    case "E":
                        CheckIfEmpty(shipCabins);
                        break;
                    case "V":
                        ViewAllRooms(shipCabins);
                        break;
                    case "D":
                        DeleteCustomerFromRoom(shipCabins, roomNum);
                        break;
                    case "F":
                        FindRoomFromCustomerName(shipCabins);
                        break;
                    case "S":
                        StoreProgramDataInToFile(shipCabins);
                        break;
                    case "L":
                        LoadProgramDataFromFile(shipCabins);
                        break;
                    case "O":
                        ViewRoomsOrderedAlphabeticallyByName(shipCabins);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }

                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println();
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println();
                if (input.nextInt() == 1) {
                   continue;
                }

                else {



                    System.out.println();
                    System.out.println("Would you like exit  ?\n1 ) Quit \n2 ) Back to Main Menu");
                    System.out.println();


                    if (input.nextInt() == 1) {

                        System.exit(0);


                    } else if(input.nextInt() == 2) {
                        continue;


                    }
                }
            }


    }




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     static void initialise(Cabin[] shipCabins) {

        for (int x = 0; x < shipCabins.length; x++) {
            shipCabins[x].setName("nobody");
        }
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


     static void CheckIfEmpty(Cabin[] shipCabins) {

        for (int x = 0; x < shipCabins.length; x++) {

            if (shipCabins[x].getName().equals("nobody")) {

                System.out.println("room " + (x + 1) + " is empty");
            }
        }
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


     static void BookARoom(Cabin[] shipCabins, int roomNum) {

        String roomName;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (1-10):");

        roomNum = input.nextInt() - 1;
        System.out.println("Enter name for room " + (roomNum + 1) + " :");
        roomName = input.next();

         shipCabins[roomNum].setName(roomName);
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


     static void ViewAllRooms(Cabin[] shipCabins) {

        for (int x = 0; x < shipCabins.length; x++) {

            System.out.println("room " + (x + 1) + " occupied by " + shipCabins[x].getName());
        }
    }




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void DeleteCustomerFromRoom(Cabin[] shipCabins, int roomNum) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-10):");
        roomNum = input.nextInt() - 1;
        shipCabins[roomNum].setName("nobody");
        System.out.println("Entery Deleted :)");
    }



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private static void FindRoomFromCustomerName(Cabin[] shipCabins) {

        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to Search for:");
        roomName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < shipCabins.length; x++) {
            if (roomName.equals(shipCabins[x].getName())) {
                System.out.println("The Account That Matches That name is Account number " + x);
                Checker = true;
            }
        }
        if (Checker == false) {
            System.out.println("There are no Rooms Booked with that name\n(make sure you've used the correct CAP's)");
        }
    }




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    private static void StoreProgramDataInToFile(Cabin[] shipCabins) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("D:\\2nd sem\\sd dev_2_pro\\courseWork\\task_2\\data.txt"))) {
            int x;
            for (x = 0; x < shipCabins.length; x++) {
                out.println("Name and Room number is: " + shipCabins[x].getName() + "at: " + x);
            }

        }
        System.out.println("All Room Names have been Saved.");
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    private static void LoadProgramDataFromFile(Cabin[] shipCabins) throws IOException {
        FileInputStream fs = new FileInputStream("D:\\2nd sem\\sd dev_2_pro\\courseWork\\task_2\\data.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        for (int i = 0; i < shipCabins.length; i++) {
            shipCabins[i].setName(br.readLine());
        }
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    private static void ViewRoomsOrderedAlphabeticallyByName(Cabin[] shipCabins) {
        String[] myStrArray = new String[shipCabins.length];
        for (int i = 0; i < shipCabins.length; i++) {
            myStrArray[i] = shipCabins[1].getName();
        }

        Arrays.sort(myStrArray);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);
        }

    }





}