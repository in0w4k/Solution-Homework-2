import java.util.List;

public class Room {
    private final String roomName;
    private final String roomType;
    private final List<Item> items;
    private Room forwardRoom;
    private Room backRoom;
    private Room rightRoom;
    private Room leftRoom;

    public Room(String roomName, String roomType, List<Item> items) {
        this.roomName = roomName;
        this.roomType = roomType;
        this.items = items;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public List<Item> getItems() {
        return items;
    }


    public Room getForwardRoom() {
        return forwardRoom;
    }
    public void setForwardRoom(Room forwardRoom) {
        this.forwardRoom = forwardRoom;
    }

    public Room getBackRoom() {
        return backRoom;
    }
    public void setBackRoom(Room backRoom) {
        this.backRoom = backRoom;
    }

    public Room getRightRoom() {
        return rightRoom;
    }
    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
    }

    public Room getLeftRoom() {
        return leftRoom;
    }
    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
    }

    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void describeRoom() {
        System.out.println("Room: " + roomName);
        System.out.println("Type of room: " + roomType);
        if (items.isEmpty()) {
            System.out.println("No items in room");
        } else {
            System.out.println("========== Items ==========");
            for (Item item : items) {
                System.out.printf("Item: %s\n", item.getItemName());
            }
            System.out.println("===========================");
        }
    }
}
