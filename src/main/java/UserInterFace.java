import java.util.ArrayList;
import java.util.Scanner;

import ENUM.Attack;
import ENUM.EatFood;
import ENUM.EquipItem;

public class UserInterFace {
    Scanner scan = new Scanner(System.in);
    Adventure adventure = new Adventure();
    final String ANSI_RESET = "\u001b[0m";
    final String ANSI_BAGGROUND= "\u001b[44m";
    final String ANSI_FED = "\u001b[1m";


    public void startMenu() {
        boolean isRunning = true;
        System.out.println(ANSI_BAGGROUND+"Escape the abandoned village!" + ANSI_RESET);
        System.out.println("┌──────────────────────────────┐");
        System.out.println( ANSI_FED + "You are now in a " + adventure.getStartRoom().getName() + "\n└" + "─".repeat(30) + "┘"+ ANSI_RESET + "\n" + adventure.getStartRoom().getDescription());
        while (isRunning) {
            String direction = scan.nextLine().toLowerCase();
            String[] userInputs = direction.split(" ");

            String command = userInputs[0];

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
                    System.out.print("Help information" + "\nType: exit or ex to exit the game" + "\ntype: look or l, to look in the room that you are in" +
                            "\ntype: take or pick up, to take an item " + "type: drop to drop an item that you have in your inventory" +
                            "\ntype: health to see your current health" + "type: inv, invent or inventory to see what you have in your inventory" +
                            "\ntype: equip or eq, to equip the wearable or weapon that you have collected" +
                            "\ntype attack to attack an enemy " + "type eat to eat a food item");
                    break;

                case "look", "l":
                    System.out.println("In front of me i see " + adventure.getCurrentRoom().getDescription());
                    System.out.println(adventure.getCurrentRoom().getItemList());
                    System.out.println(adventure.getCurrentRoom().getEnemies());
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
                    EquipItem equipItem = adventure.equipItem(userChoice);
                    Item itemInPlayer = adventure.searchItemInv(userChoice);
                    Item searchEquippedItem = adventure.getCurrentWeapon();

                    if (equipItem == EquipItem.EQUIPPING_WEAPON) {
                        System.out.println(searchEquippedItem + " equipped");
                    } else if (equipItem == EquipItem.NOT_WEAPON) {
                        System.out.println(itemInPlayer + " can not be equipped");
                    } else if (equipItem == EquipItem.NOT_FOUND) {
                        System.out.println("No item was found");
                    }

                    break;

                case "unequip", "Unequip":
                    EquipItem unEquipItem = adventure.unEquipItem(userChoice);
                    Item inventory1 = adventure.searchItemInv(userChoice);

                    if (unEquipItem == EquipItem.UNEQUIP) {
                        System.out.println(inventory1 + " unequipped");
                    } else if (unEquipItem == EquipItem.NOT_FOUND) {
                        System.out.println(inventory1 + "unequipped");
                    }

                    break;


                case "eat":
                    Item roomInventory1 = adventure.takeItem(userChoice);
                    ArrayList<Item> itemInInventory = adventure.getPlayer().getInventory();

                    if (roomInventory1 != null) {
                        if (roomInventory1 instanceof Food) {
                            System.out.println("You ate the " + roomInventory1.getItemName() + "\nHealth " + ((Food) roomInventory1).getHealth());

                            int points = ((Food) roomInventory1).getHealth() + adventure.addLife();
                            adventure.getPlayer().setLife(points);
                        } else {
                            System.out.println(roomInventory1.getItemName() + " is not edible");
                        }
                    } else if (itemInInventory == null) {
                        System.out.println("There is nothing with that name");

                    }
                    break;
                case "attack", "shoot":

                    Attack attack = adventure.attack(userChoice);
                    Item searchForEquippedItem = adventure.getCurrentWeapon();
                    Item roomInventory = adventure.searchItemInv(userChoice);

                    if (attack == Attack.ATTACK_ENEMY) {
                        System.out.println("Enemy attack. " + ((Weapon) searchForEquippedItem).getDamage() + " damage dealt");
                        System.out.println(((Weapon) searchForEquippedItem).getAmmunition() + " shots left");
                    } else if (attack == Attack.KILLED_ENEMY) {
                        System.out.println(userChoice + " is dead");
                    } else if (attack == Attack.NO_AMMO) {
                        System.out.println("No ammunition left");
                    } else if (attack == Attack.NOT_EQUIPPED) {
                        System.out.println("You dont have " + roomInventory + " equipped");
                    } else {
                        System.out.println("Invalid input (nothing matched your search)");
                        break;
                    }
            }
        }
    }
}






                   /* String foodName = userChoice;
                    Item roomInventory = adventure.takeItem(userChoice);
                    EatFood result = adventure.eatFood(foodName);
                    switch (result) {
                        case NOT_FOUND:
                            System.out.println("There is no food item with that name");
                            break;
                        case YOU_ATE_THE_FOOD:
                            System.out.println(roomInventory.getItemName()+ "\nHealth " + ((Food) roomInventory).getHealth());
                            int points = ((Food) roomInventory).getHealth() + adventure.addLife();
                            adventure.getPlayer().setLife(points);
                            break;
                        case CANT_EAT_THAT:
                            System.out.println("You cant eat that item");
                            break;
                        default:
                            System.out.println("Something went wrong. Please try again");
                    }*/

