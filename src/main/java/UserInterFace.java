import java.util.Scanner;

public class UserInterFace {
    Scanner scan = new Scanner(System.in);
    Adventure adventure = new Adventure();


    public void startMenu() {
        boolean isRunning = true;
        System.out.println("You are now in a " + adventure.getStartRoom().getName() + "\n" + adventure.getStartRoom().getDescription());
        while (isRunning) {
            String direction = scan.nextLine();
            switch (direction) {

                case "Go north", "North", "n":

                    if(adventure.goNorth()){
                        System.out.println("Going north \n" + adventure.getStartRoom().getName() + "\n" + adventure.getStartRoom().getDescription() );

                    } else{
                        System.out.println("You can not go that way" );
                    } break;


                case "Go east", "east", "e":
                    if(adventure.goEast()){
                        System.out.println("Going east \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription() );

                    }else {
                        System.out.println("You can not go that way" );
                    }break;


                case "Go south", "South", "s":

                    if(adventure.goSouth()){
                        System.out.println("Going south \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription() );

                    }else {
                        System.out.println("You can not go that way" );
                    }break;


                case " Go west", "west", "w":

                    if(adventure.goWest()){
                        System.out.println("Going west \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription() );

                    }else {
                        System.out.println("You can not go that way" );
                    }break;

                case "exit", "ex":
                    System.out.println("Exiting progam...");
                    isRunning = false;
                    break;

                case "help", "h":
                    System.out.print("Help information");
                    //TODO indsæt hjælpinfo til bruger.
                    break;

                case "look", "l":
                    System.out.println();
                    break;
                default:
                    System.out.println("Could not find that command");
                    break;
            }

        }

    }
}