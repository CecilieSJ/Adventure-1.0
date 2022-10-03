import java.sql.SQLOutput;
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
            String userChoice = "";
            if(userInputs.length > 1){
                userChoice = userInputs[1];
            }


            switch (command) {

                case "go":

                   boolean succes = true;
                    if(adventure.go(userChoice) == true){
                        System.out.println(adventure.getPlayer().getCurrentRoom().getName() + "\n"
                                + adventure.getPlayer().getCurrentRoom().getDescription());
                    }else{
                        System.out.println("you can not go that way");
                        succes=false;
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
                    if( takeItem != null){
                        System.out.println("You took: "  + takeItem.getItemName());
                    }else {
                        System.out.println("Nothing with that name");

                    }
                    break;

                case "drop":
                   Item dropItem = adventure.dropItem(userChoice);
                    if( dropItem != null){
                        System.out.println("You drop: " + dropItem.getItemName() );
                    }else {
                        System.out.println("Nothing with that name");
                    }
                    break;


                case "inv", "inven", "inventory":
                    System.out.println("Your inventory contains: " + adventure.getCurrentRoom().getItemList());
                    break;


            }
        }

    }

}
