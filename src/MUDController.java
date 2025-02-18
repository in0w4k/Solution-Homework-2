import java.util.Scanner;

public class MUDController {
    private final Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner sc = new Scanner(System.in);
        showHelp();
        while (running) {
            System.out.print("> ");
            String input = sc.next();
            handleInput(input);
        }
        sc.close();
    }

    public void handleInput(String input) {
        String command = input.toLowerCase();
        switch (command) {
            case "look": lookAround(); break;
            case "move": move(); break;
            case "pickup": pickUp(); break;
            case "inventory": checkInvetory(); break;
            case "help": showHelp(); break;
            case "exit":
                running = false;
                System.out.println("Exiting game...");
                break;
            default: System.out.println("Unknown command: " + command);
        }
    }

    private void lookAround() {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom != null) {
            System.out.println("Looking around...");
            currentRoom.describeRoom();
        } else {
            System.out.println("You are not in any room.");
        }
    }

    private void move() {
        Room currentRoom = player.getCurrentRoom();
        Room nextRoom;
        Scanner sc = new Scanner(System.in);
        System.out.println("Direction: \n1. Forward \n2. Back \n3. Left \n4. Right");
        System.out.print("Choose a direction: ");
        int direction = sc.nextInt();
        switch (direction){
            case 1: nextRoom = currentRoom.getForwardRoom(); break;
            case 2: nextRoom = currentRoom.getBackRoom(); break;
            case 3: nextRoom = currentRoom.getLeftRoom(); break;
            case 4: nextRoom = currentRoom.getRightRoom(); break;
            default: System.out.println("Unknown direction: " + direction); return;
        }

        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.printf("You move to %s\n", nextRoom.getRoomName());
            nextRoom.describeRoom();
        } else {
            System.out.println("There's no room in that direction.");
        }
    }

    private void pickUp() {
        Room currentRoom = player.getCurrentRoom();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item: ");
        String itemInRoom = sc.next();
        Item item = currentRoom.getItem(itemInRoom.toLowerCase());

        if (item != null) {
            player.addItem(item);
            currentRoom.getItems().remove(item);
            System.out.println("You picked up " + item.getItemName());
        } else {
            System.out.println("Item not found.");
        }
    }

    private void checkInvetory() {
        player.showInventory();
    }

    private void showHelp() {
        System.out.println("Commands:");
        System.out.println("  look             - Look around the room.");
        System.out.println("  move             - Move in a direction (forward, back, left, right).");
        System.out.println("  pickup           - Pick up an item from the room.");
        System.out.println("  inventory        - Check your inventory.");
        System.out.println("  help             - Show this help message.");
        System.out.println("  exit             - Exit the game.");
    }
}
