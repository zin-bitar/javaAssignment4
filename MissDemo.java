// ---------------------------------------------------------
// Assignment 4
// Written by: Zin Bitar 40305895
// For COMP 248 Section H 2242– Fall 2024
// ---------------------------------------------------------

//this program keeps track of registries for a shipment company named Montreal Intercampuses shipping services

import java.util.Scanner;

public class MissDemo {

    public static void main(String[] args) {

        //creating the 5 registries and their stamps and labels
        Stamps sameStamps = new Stamps(1,2,3,4,5);
        Label label1 = new Label("Standard", 98989898, 25, 11);


        Stamps sameStampsValue = new Stamps(1,0,20,0,0);


        Stamps sameStamps2 = new Stamps (5,4,3,2,1);
        Label labelA = new Label("Small", 98000000, 12, 6);
        Label labelB = new Label("Express", 98111111, 28, 2);
        Label labelC = new Label("Fragile", 98222222,17,3);

        Registry sameReg1 = new Registry(sameStamps,new Label[]{label1});
        Registry sameReg2 = new Registry(sameStamps, new Label[]{label1});
        Registry sameRegA = new Registry(sameStamps2, new Label[]{});
        Registry sameRegB = new Registry(sameStamps2, new Label[]{});
        Registry sameStampsValues = new Registry(sameStampsValue, new Label[]{labelA,labelB,labelC});

        Registry[] registries = {sameReg1, sameReg2, sameStampsValues, sameRegA, sameRegB};


        Scanner scanner = new Scanner(System.in);

        //welcoming user
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("  Welcome to Montreal Intercampuses Shipping Sercive (MISS©) Application");
        System.out.println("+++++++++++++++++++++++++++++++");

        //making a while loop to keep program running until user wants to leave
        //initializing choice at whatever value that isn't 0
        int choice = 5;
        while(choice != 0) {

            //displaying options to users
            System.out.print("What would you like to do?\n 1  >> See the content of all Registries\n 2  >> See the content of one Registry\n 3  >> List Registries with the same $ amount of shipment Stamps\n 4  >> List Registries with same number of shipment Stamps types\n 5  >> List Registries with same $ amount of Stamps and same number of prepaid Labels\n 6  >> Add a prepaid label to an existing Registry\n 7  >> Remove an existing prepaid label from a Registry\n 8  >> Update the expiry date of an existing prepaid label\n 9  >> Add Stamps to a Registry\n 0  >> To quit\n+++++++++++++++++++++++++++++++\n\nPlease enter your choice and press <Enter>:");

            //getting repeated user input
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Content of each Registry\n-------------------");

                    //for loop to display all registries
                    for (int i = 0; i < registries.length; i++) {
                        System.out.println("Registry #"+ (i+1) +":");
                        System.out.println(registries[i].toString());
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Which registry would you like to see the content of? (Enter number 0 to 4): ");
                    //getting registry number to show the one that they want
                    int regNum = validRegistry();

                    //verifying that the registry that they chose has labels
                    if(registries[regNum].numberOfLabels()==0)
                        System.out.println("No labels");
                    else
                        System.out.println(registries[regNum].toString());
                    break;
                case 3:
                    System.out.println("List of Registries with same total $ Stamps:");

                    //initializing boolean
                    boolean sameStampPrice = true;

                    //2 for loops: each iteration of the first one checks all iteration of the second one
                    //to compare each registry with all if the $ of stamps is the same
                    for (int i = 0; i < registries.length-1; i++) {
                        for (int j = (i+1); j < registries.length; j++) {
                            if(registries[i].equalPriceStamps(registries[j])){
                                System.out.println("Registries "+i+ " and " + j + " both have " + registries[i].priceOfStamps());
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("List of Registries with same Stamps categories:\n");

                    //same as case 3, but for the stamps instead of their price
                    for (int i = 0; i < registries.length-1; i++) {
                        for (int j = (i+1); j < registries.length; j++) {
                            if(registries[i].equalNumStamps(registries[j])){
                                System.out.println("\tRegistries "+i+ " and " + j + " both have " + registries[i].stampsBreakDown());
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("List of Registries with same $ amount of Stamps and same number of Labels:");

                    //same as 3, but to check if they have the same labels and stamps
                    for (int i = 0; i < registries.length-1; i++) {
                        for (int j = (i+1); j < registries.length; j++) {
                            if(registries[i].equals(registries[j])){
                                System.out.println("\tRegistries "+i+ " and " + j);
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.print("Which Registry do you want to add an Label to? (Enter number 0 to 4): ");

                    //getting user input for which registry to add label to
                    int addLab = validRegistry();

                    //eating the next line for the nextLine() right after
                    String junk = scanner.nextLine();

                    //getting user input for the label type, id and expiry date for the added label
                    System.out.print("Please enter the following information so that we may complete the Label-\n--> Type of Label (Confidential, Small, Oversize, Express, Standard, Fragile): ");
                    String addLabType = scanner.nextLine();

                    System.out.print("\n--> Id of the prepaid label possessor: ");
                    int addLabId = scanner.nextInt();

                    System.out.print("\n--> Expiry day number and month (seperate by a space): ");
                    int addLabExDay = scanner.nextInt();
                    int addLabExMonth = scanner.nextInt();

                    Label addedLabel = new Label(addLabType, addLabId, addLabExDay, addLabExMonth);
                    registries[addLab].addLabel(addedLabel);


                    //checking if they have multiple labels or 1 to make label plural or not
                    if(addLab == 1)
                        System.out.println("You now have " + registries[addLab].numberOfLabels() + " Label");
                    else
                        System.out.println("You now have " + registries[addLab].numberOfLabels() + " Labels");

                    break;

                case 7:
                    System.out.print("Which Registry do you want to remove a Label from? (Enter number 0 to 4): ");

                    //getting user input for which registry to remove label from
                    int remLab = validRegistry();

                    //making sure the registry has labels to remove
                    if(registries[remLab].numberOfLabels() == 0){
                        System.out.println("Sorry that Registry has no Labels");
                        break;
                    }

                    //getting user input for which label to remove
                    System.out.print("Enter number 0 to " + (registries[remLab].numberOfLabels()-1) + ":");
                    int labelToRemove = scanner.nextInt();

                    //handling wrong user input with while loop until they make it right
                    while(labelToRemove < 0 || labelToRemove > (registries[remLab].numberOfLabels()-1)){
                        System.out.print("Invalid number. Please Try again: ");
                        labelToRemove = scanner.nextInt();
                    }

                    //removing the label from the registry
                    Label labelToBeRemoved = registries[remLab].getLabel(labelToRemove);
                    registries[remLab].removeLabel(labelToBeRemoved);
                    System.out.println("Label was removed successfully");

                    break;

                case 8:

                    System.out.print("Which Registry do you want to update a Label from? (Enter number 0 to 4): ");

                    //getting user input for which label to update the expiry date
                    int updateLabel = validRegistry();

                    //making sure the registry has a label
                    if(registries[updateLabel].numberOfLabels() == 0){
                        System.out.println("This registry is empty");
                        break;
                    }

                    //getting user input for which label to update
                    System.out.print("Which Label to you want to update? (Enter number 0 to " + (registries[updateLabel].numberOfLabels()-1) + "): ");
                    int labelToUpdate = scanner.nextInt();

                    //handling wrong user input with while loop until they make it right
                    while(labelToUpdate < 0 || labelToUpdate > (registries[updateLabel].numberOfLabels()-1)) {
                        System.out.print("Invalid label number. Please Try again. ");
                        labelToUpdate = scanner.nextInt();
                    }

                    //getting user input for the new date
                    System.out.print("--> Enter new expiry date day number and month (seperated by a space): ");
                    int newDay = scanner.nextInt();
                    int newMonth = scanner.nextInt();

                    //handling wrong user input with while loop until they make it right
                    if(newDay > 31 || newDay < 0 || newMonth < 0 || newMonth > 12){
                        System.out.print("Invalid day or month. Please try again.");
                        newDay = scanner.nextInt();
                        newMonth = scanner.nextInt();
                    }

                    //changing the expiry date and confirming for user
                    registries[updateLabel].changeExpiryDate(registries[updateLabel].getLabel(labelToUpdate), newDay, newMonth);
                    System.out.println("Expiry Date updated.");
                    break;

                case 9:

                    System.out.print("Which Registry do you want to add Stamps to? (Enter number 0 to 4): ");

                    //getting user input for which registry to add stamps to
                    int addStamps = validRegistry();

                    //getting user input for how many of each category of stamps to add
                    System.out.print("How many category_A($2), category_B($5), category_C($10), category_D($15) and category_E($20) parcel stamps do you want to add?\nEnter 5 numbers seperated by a space: ");
                    int addCatA = scanner.nextInt();
                    int addCatB = scanner.nextInt();
                    int addCatC = scanner.nextInt();
                    int addCatD = scanner.nextInt();
                    int addCatE = scanner.nextInt();

                    //handling wrong user input with while loop until they make it right
                    if(addCatA <0 || addCatB < 0 || addCatC < 0 || addCatD < 0 || addCatE < 0){
                        System.out.print("One of the stamps numbers is negative, therefore invalid. Please try again. ");
                        addCatA = scanner.nextInt();
                        addCatB = scanner.nextInt();
                        addCatC = scanner.nextInt();
                        addCatD = scanner.nextInt();
                        addCatE = scanner.nextInt();
                    }

                    //adding the stamps to the chosen registry
                    registries[addStamps].addStamps(addCatA, addCatB, addCatC, addCatD, addCatE);

                    System.out.println("You now have $" + registries[addStamps].priceOfStamps());

                    break;


                case 0:

                    //closing message
                    System.out.println("Thank you for using Montreal Intercampuses Shipping Service(MISS©) Application!");
                    break;
                default:

                    //handling wrong user input with while loop until they make it right
                    System.out.println("Sorry that is not a valid choice. Try again.");
            }


        }



    }
    public static int validRegistry (){
        Scanner scanner = new Scanner(System.in);
        //getting user input for which registry to add stamps to
        int regNum = scanner.nextInt();

        //handling wrong user input with while loop until they make it right
        while(regNum < 0 || regNum > 4) {
            System.out.print("Invalid Registry. Please try again. ");
            regNum = scanner.nextInt();
        }
        return regNum;
    }
}