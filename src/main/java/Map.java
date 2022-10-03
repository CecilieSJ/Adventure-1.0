import java.util.ArrayList;

public class Map {

    private Room startRoom;

    public Map() {

        Room cabin = new Room("Cabin", "Something startled you in your sleep and you woke up with shock. You find yourself in a cabin fare fare away from everything. " +
                "Even with only a messy bed and an old chair it feels like the walls are coming down on you.  The smell gives you an itch nose. How you got there is a big mystery you have got to solve." +
                "You reaching out for the cold doorknob that sends chills down your spine and you slowly open the door. ");
        Room forest = new Room("Forest", "It has become dark. The thin air feels like a knife cutting through your skin." +
                "You have been walking around for hours but it is like the darkness has swallowed you. ");
        Room gateToVillage = new Room("Gate to village", "You keep moving forward though the dark forest " +
                "and after what feels like forever you finally arrive to a clearing. " +
                "Where their is a gate but if you look closer to it, you can see that the gate has a lock on it, which requires a key");
        Room hill = new Room("Hill", "Behind the cabin you find a hidden bike. You decide to ride the bike down the rockey road meanwhile the rust from the bike falls as you go.. " +
                " Your hands tightens the gib around the handles as the bike struggles to find its gib trough the wet leaves and stones. Your heading in full speed down towards a big gate where multiple house are hiding from the rough landscape." +
                "There must be someone down there that can help you...... or can they?");
        Room tainStation = new Room("Trainstation", " As you desire for air get bigger, you suddenly see light spreading throughout the tunnel." +
                "You ascends to the surface. As your head is peeking up, you find yourself in a big fountain. Peoples eyes gets huge and some even smaller as their puzzle builds." +
                "While you find your legs, people has already forgotten all about you and is moving on in the middle of rush hour on New Your Penn Station");
        Room theVillage = new Room("The village", "You open the gate, walks in. But the moment you do so," +
                "the gate closes shut behind you and you are now unable to go back to your cabin from that way" +
                "As the key only works one way and you would have to find another way to pass the gate." +
                " You look away from the gate and you can see what seems to be an abandoned village, however you have a feel that it might not be the case");
        Room payphone = new Room("Payphone", "As you drive though the wight open gate, you suddenly stop. You can feel a huge lump forming in your stomach,that was not there before." +
                "All the small house har pitch black and can only be seen because of to streetlamps lightning the darkness of the night. In a narrow window a angry face meets yours. You are not welcome so you are on your own." +
                "Further ahead, beneath the streetlamp is a payphone. You run over to the payphone, only to find out, that the unknown voice in the other end says: Go to the lake and you will find what you seek.  ");
        Room theLake = new Room("Lake", "You fight your way though the darkness until you arrives to a tiny lake, formed as a snake. Something is off. A around circle is forming in the middle of the lake and you take a leap of faith and jump in." +
                "As you get further to the circle you see that it is a well with arrows pointing down toward the. You are now out of options and you take a deep breath and starts descending.");
        Room theHouse = new Room("The House", "You walk over to one of the houses, which to your surprise isn't locked" +
                "you enter the house and you discover that the house only has one big room, which looks old and abandoned" +
                "the only sign of anyone that used to live there," +
                "is an old bed and some shelves with some books and some stuff on a bedside table" +
                "Where you find a note that states 'go to the lake and you will find what you seek'" + "You then exit the house and you can see a lake to the west from you" +
                "and the way that you came from.");


        Item jacket = new Item("jacket", "It is always good to bring a jacket!");
        Item flashLight = new Item("flashlight", " Without a flashlight, you can not go fare.");
        Item key = new Item("key", " The key is absolutely necessary ");
        Item coin = new Item("coin", " Pure luck to find a coin");
        Item note = new Item("note'Go to the lake and you'll find what you seek'", " If the note is there, maybe you should listen");
        Item divingGear = new Item("diving gear", " Well you need to lean one day. Might as well be now.");



        cabin.setEast(forest);
        cabin.setSouth(hill);
        cabin.addItem(jacket);
        cabin.addItem(flashLight);


        forest.setEast(gateToVillage);
        forest.setWest(cabin);


        gateToVillage.setWest(forest);
        gateToVillage.setSouth(theVillage);
        gateToVillage.addItem(key);

        hill.setNorth(cabin);
        hill.setSouth(payphone);
        hill.addItem(coin);

        tainStation.setSouth(theLake);

        theVillage.setNorth(gateToVillage);
        theVillage.setSouth(theHouse);


        payphone.setNorth(hill);
        payphone.setEast(theLake);


        theLake.setNorth(tainStation);
        theLake.setWest(payphone);
        theLake.setEast(theHouse);
        theLake.addItem(divingGear);


        theHouse.setNorth(theVillage);
        theHouse.setWest(theLake);
        theHouse.addItem(note);

        startRoom = cabin;

    }

    public Room getStartRoom() {
        return startRoom;
    }


}
