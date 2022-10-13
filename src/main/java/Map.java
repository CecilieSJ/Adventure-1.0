//import javax.xml.namespace.QName;

public class Map {

    private Room startRoom;

    public Map() {
        setRooms();
    }

    //Rooms
    private Room cabin = new Room("Cabin", "Something startled you in your sleep and you woke up with shock. You find yourself in a cabin fare fare away from everything. " +
            "Even with only a messy bed and an old chair it feels like the walls are coming down on you.  The smell gives you an itch nose. How you got there is a big mystery you have got to solve." +
            "You reaching out for the cold doorknob that sends chills down your spine and you slowly open the door. ");
    private Room forest = new Room("Forest", "It has become dark. The thin air feels like a knife cutting through your skin." +
            "You have been walking around for hours but it is like the darkness has swallowed you. ");
    private Room gateToVillage = new Room("Gate to village", "You keep moving forward though the dark forest " +
            "and after what feels like forever you finally arrive to a clearing. " +
            "Where their is a gate but if you look closer to it, you can see that the gate has a lock on it, which requires a key");
    private Room hill = new Room("Hill", "Behind the cabin you find a hidden bike. You decide to ride the bike down the rockey road meanwhile the rust from the bike falls as you go.. " +
            " Your hands tightens the gib around the handles as the bike struggles to find its gib trough the wet leaves and stones. Your heading in full speed down towards a big gate where multiple house are hiding from the rough landscape." +
            "There must be someone down there that can help you...... or can they?");
    private Room tainStation = new Room("Trainstation", " As you desire for air get bigger, you suddenly see light spreading throughout the tunnel." +
            "You ascends to the surface. As your head is peeking up, you find yourself in a big fountain. Peoples eyes gets huge and some even smaller as their puzzle builds." +
            "While you find your legs, people has already forgotten all about you and is moving on in the middle of rush hour on New Your Penn Station");
    private Room theVillage = new Room("The village", "You open the gate, walks in. But the moment you do so," +
            "the gate closes shut behind you and you are now unable to go back to your cabin from that way" +
            "As the key only works one way and you would have to find another way to pass the gate." +
            " You look away from the gate and you can see what seems to be an abandoned village, however you have a feel that it might not be the case");
    private Room payphone = new Room("Payphone", "As you drive though the wight open gate, you suddenly stop. You can feel a huge lump forming in your stomach,that was not there before." +
            "All the small house har pitch black and can only be seen because of to streetlamps lightning the darkness of the night. In a narrow window a angry face meets yours. You are not welcome so you are on your own." +
            "Further ahead, beneath the streetlamp is a payphone. You run over to the payphone, only to find out, that the unknown voice in the other end says: Go to the lake and you will find what you seek.  ");
    private Room theLake = new Room("Lake", "You fight your way though the darkness until you arrives to a tiny lake, formed as a snake. Something is off. A around circle is forming in the middle of the lake and you take a leap of faith and jump in." +
            "As you get further to the circle you see that it is a well with arrows pointing down toward the. You are now out of options and you take a deep breath and starts descending.");
    private Room theHouse = new Room("The House", "You walk over to one of the houses, which to your surprise isn't locked" +
            "you enter the house and you discover that the house only has one big room, which looks old and abandoned" +
            "the only sign of anyone that used to live there," +
            "is an old bed and some shelves with some books and some stuff on a bedside table" +
            "Where you find a note that states 'go to the lake and you will find what you seek'" + "You then exit the house and you can see a lake to the west from you" +
            "and the way that you came from.");


    //Items
    private Item jacket = new Item("jacket", "It is always good to bring a jacket!");
    private Item flashLight = new Item("flashlight", " Without a flashlight, you can not go fare!");
    private Item key = new Item("key", " The key is absolutely necessary ");
    private Item coin = new Item("coin", " Pure luck to find a coin");
    private Item note = new Item("note'Go to the lake and you'll find what you seek'", " If the note is there, maybe you should listen");
    private Item divingGear = new Item("diving gear", " Well you need to learn one day. Might as well be now.");


    //Enemies
    private Enemy goat = new Enemy("goat ", "Watch out for the horns", 10, 20);
    private Enemy troll = new Enemy("troll", "A fairly sized club made of wood. An ugly troll blocks you from what you seek which is your escape from this place", 200, 15);
    private Enemy soldier = new Enemy("soldier ", " kill him before he kills you", 50, 70);


    public void setRooms() {

        goat.setRoom(cabin);
        cabin.addEnemy(goat);
        cabin.setEast(forest);
        cabin.setSouth(hill);
        cabin.addItem(jacket);
        cabin.addItem(flashLight);
        cabin.addItem(new Food("apple", "This apple looks like it have just been picked, as it is in perfect condition", 10));
        cabin.addItem(new MeleeWeapon("bottle", "a broken bottle that is not very useful in a fight, as it looks like it might shatter the next time its used", "Melee weapon", 1));


        cabin.addItem(new RangedWeapon("bow", "a fairly new bow that doesnt look like it has been used in combat", "Ranged Weapon", 1, 100));


        forest.setEast(gateToVillage);
        forest.setWest(cabin);


        gateToVillage.setWest(forest);
        gateToVillage.setSouth(theVillage);
        gateToVillage.addItem(key);
        gateToVillage.addItem(new Food("bread", "This bread lays near the gate, you dont know why it is there, but you take it", 15));

        hill.setNorth(cabin);
        hill.setSouth(payphone);
        hill.addItem(coin);

        tainStation.setSouth(theLake);

        theVillage.setNorth(gateToVillage);
        theVillage.setSouth(theHouse);


        payphone.setNorth(hill);
        payphone.setEast(theLake);


        troll.setRoom(theLake);
        theLake.addEnemy(troll);
        theLake.setNorth(tainStation);
        theLake.setWest(payphone);
        theLake.setEast(theHouse);
        theLake.addItem(divingGear);
        theLake.addItem(new Food("nuts", "a little bag of healthy snacks for an adventure and the locals in the nearby village", 11));
        theLake.addItem(new Food("orange", "This orange is unusually big, but it just makes it looks more tasty", 30));
        theLake.addItem(new Food("crab", "This crab seems to be almost dead but when you look at it, you get an unexplainable urge to consume it, even though you know you should not", -100));
        theLake.addItem(new Food("seaweed", "A small bundle of seaweed that has a salty smell to it and probably salty taste as well", -12));
        theLake.addItem(new MeleeWeapon("sword", "a long sword that looks heavy but once you try to hold it, it isnt heavy at all", "Melee Weapon", 150));
        theLake.addItem(new MeleeWeapon("staff", "a normal wooden staff", "Melee Weapon", 25));


        soldier.setRoom(theHouse);
        theHouse.addEnemy(soldier);
        theHouse.setNorth(theVillage);
        theHouse.setWest(theLake);
        theHouse.addItem(note);
        theHouse.addItem(new Food("fish", "This fish is rotten and smelly, you shouldnt eat it", -95));
        theHouse.addItem(new Food("chicken ", "its just a normal grilled chicken wing. It has just been abandoned for a little while. 10 second rule", -25));


        startRoom = cabin;
    }


    public Room getStartRoom() {
        return startRoom;
    }


}
