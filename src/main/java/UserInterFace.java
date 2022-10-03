import java.util.Scanner;

public class UserInterFace {
    Scanner scan = new Scanner(System.in);
    Adventure adventure = new Adventure();


    public void startMenu() {
        boolean isRunning = true;
        System.out.println("Welcome to The Adventure Game!");
        System.out.println("You are now in a " + adventure.getStartRoom().getName() + "\n" + adventure.getStartRoom().getDescription());
        while (isRunning) {
            String direction = scan.nextLine();
            switch (direction) {

                case "Go north", "North", "n":

                    if (adventure.goNorth()) {
                        System.out.println("Going north \n" + adventure.getStartRoom().getName() + "\n" + adventure.getStartRoom().getDescription());
                        System.out.println();

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;


                case "Go east", "east", "e":
                    if (adventure.goEast()) {
                        System.out.println("Going east \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription());

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;


                case "Go south", "South", "s":

                    if (adventure.goSouth()) {
                        System.out.println("Going south \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription());

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;


                case " Go west", "west", "w":

                    if (adventure.goWest()) {
                        System.out.println("Going west \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription());

                    } else {
                        System.out.println("You can not go that way");
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

                case "take":
                    Item pickupItem = adventure.getCurrentRoom().removeItem(direction);
                    if (pickupItem == null) {
                        System.out.println("There is nothing with that name...");
                    } else {
                        System.out.println("You have now picked up " + pickupItem);
                        adventure.getCurrentRoom().addItem(pickupItem);
                    }
                    break;

                case "drop":
                    Item dropItem = adventure.getCurrentRoom().removeItem(direction);
                    if (dropItem == null) {
                        System.out.println("There is nothing called that...");
                    } else {
                        System.out.println("You have now dropped " + dropItem);
                        adventure.getCurrentRoom().addItem(dropItem);
                    }
                    break;

                case "inv", "inve", "inven", "inventory":
                    System.out.println("Your inventory contains: " + adventure.getCurrentRoom().getItemList());
                    break;


            }
        }

    }

}
