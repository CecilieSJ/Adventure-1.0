import java.util.ArrayList;
import java.util.Scanner;

public class UserInterFace {
    Scanner scan = new Scanner(System.in);
    Adventure adventure = new Adventure();

    public void startMenu() {
        boolean isRunning = true;
        System.out.println("Welcome to The Adventure Game!");
        System.out.println("You are now in a " + adventure.getStartRoom().getName() + "\n" + adventure.getStartRoom().getDescription());
        while (isRunning) {
            String direction = scan.nextLine().toLowerCase();
            String[] userInputs = direction.split(" ");

            String command = userInputs[0];
            // int space = command.indexOf(' ');
            //String secondWord = space > 0 ? command.substring(space + 1).trim() : null;

            String userChoice = "";
            if (userInputs.length > 1) {
                userChoice = userInputs[1];
            }


            switch (command) {
                case "go":

                    boolean succes = true;
                    if (adventure.go(userChoice) == true) {
                        System.out.println(adventure.getPlayer().getCurrentRoom().getName() + "\n"
                                + adventure.getPlayer().getCurrentRoom().getDescription());
                    } else {
                        System.out.println("you can not go that way");
                        succes = false;
                    }
                    break;


                case "exit", "ex":
                    System.out.println("Exiting progam...");
                    isRunning = false;
                    break;

                case "help", "h":
                    System.out.print("Help information");
                    //TODO indsæt hjælpinfo til bruger.
                    break;

                case "look", "l":
                    System.out.println("In front of me i see " + adventure.getCurrentRoom().getDescription() + "\n" + adventure.getCurrentRoom().getItemList());
                    break;
                default:
                    System.out.println("Could not find that command");
                    break;

                case "take", "pick up":
                    Item takeItem = adventure.takeItem(userChoice);
                    if (takeItem != null) {
                        System.out.println("You took: " + takeItem.getItemName());
                    } else {
                        System.out.println("Nothing with that name");

                    }
                    break;

                case "drop":
                    Item dropItem = adventure.dropItem(userChoice);
                    if (dropItem != null) {
                        System.out.println("You drop: " + dropItem.getItemName());
                    } else {
                        System.out.println("Nothing with that name");
                    }
                    break;

                case "health":
                    System.out.println(adventure.getPlayer().getLife());
                    break;


                case "inv", "inven", "inventory":
                    ArrayList<Item> inventory = adventure.allInventory();
                    System.out.println("Your inventory contains: " + inventory);
                    break;

                case "equip", "eq":

                    System.out.println(adventure.allInventory());

                break;

                case "attack":
                    break;

                case "eat":
                    Item roomInventory = adventure.takeItem(userChoice);
                    ArrayList<Item> itemInInventory = adventure.getPlayer().getInventory();

                    if (roomInventory != null) {
                        if (roomInventory instanceof Food) {
                            System.out.println("You ate the " + roomInventory.getItemName() + "\nHealth " + ((Food) roomInventory).getHealth());

                            int points = ((Food) roomInventory).getHealth() + adventure.addLife();
                            adventure.getPlayer().setLife(points);
                        } else {
                            System.out.println(roomInventory.getItemName() + " is not edible");
                        }
                    } else if (itemInInventory == null) {
                        System.out.println("There is nothing with that name");

                    }
                        break;






                    /*String foodName = userChoice;
                    ReturnMessage result = adventure.eat(foodName);
                    switch (result) {
                        case NOT_FOUND:
                            System.out.println("There is no food item with that name");
                            break;
                        case OK:
                            System.out.println("jj");
                            break;
                        case CANT:
                            System.out.println("You cant eat that item");
                            break;
                        default:
                            System.out.println("");
                    }*/





            }

        }
    }
}
