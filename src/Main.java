import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Item key = new Item("Key", "A key to open a door.");
        Item sword = new Item("Sword", "A blade for slashing enemies.");
        Item shield = new Item("Shield", "A strong medium shield.");
        Item magic_wand = new Item("Magic Wand", "A magic wand that uses mana for spells.");
        Item potion = new Item("Potion", "A magical potion that restores health.");

        Room room1 = new Room("Room 1", "A small room with a key.", new ArrayList<>(List.of(key)));
        Room room2 = new Room("Room 2", "A dark room with a sword.", new ArrayList<>(List.of(sword)));
        Room room3 = new Room("Room 3", "A large hall with a shield.", new ArrayList<>(List.of(shield)));
        Room room4 = new Room("Room 4", "A plain room with a magic wand.", new ArrayList<>(List.of(magic_wand)));
        Room room5 = new Room("Room 5", "A gloomy room with a potion.", new ArrayList<>(List.of(potion)));
        Room room6 = new Room("Room 6", "A strange room with a door that can be unlocked by the key.", new ArrayList<>());

        room1.setForwardRoom(room2);
        room1.setRightRoom(room3);
        room2.setBackRoom(room1);
        room2.setLeftRoom(room4);
        room3.setLeftRoom(room5);
        room3.setBackRoom(room6);
        room4.setForwardRoom(room2);
        room5.setRightRoom(room6);
        room6.setLeftRoom(room3);


        Player player = new Player();
        player.setCurrentRoom(room1);

        MUDController controller = new MUDController(player);

        controller.runGameLoop();
    }
}
