import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> inventory;

    public Player() {
        this.inventory = new ArrayList<>();
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty");
        }
        else {
            System.out.println("========== Inventory ==========");
            for (Item item : inventory) {
                System.out.printf("Item: %s | Description: %s\n", item.getItemName(), item.getItemDescription());
            }
            System.out.println("===============================");
        }
    }
}
