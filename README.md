# MUD Game (Text-Based Adventure)

## Description
MUD (Multi-User Dungeon) is a text-based adventure game where players explore rooms, interact with objects, and navigate the game world using text commands.

## Features
- Explore rooms and view their descriptions.
- Move in different directions (forward, back, left, right).
- Pick up items and manage inventory.
- View available commands with the help command.
- Exit the game at any time.

## Installation & Running
1. Clone the repository or download the project files.
2. Open the project in any Java-compatible IDE (IntelliJ IDEA, VS Code, etc.).
3. Compile and run `Main.java`.

## Commands
The following commands are available in the game:

```
  look             - Look around the room.
  move             - Move in a direction (forward, back, left, right).
  pickup           - Pick up an item from the room.
  inventory        - Check your inventory.
  help             - Show this help message.
  exit             - Exit the game.
```

## Example Gameplay
```
> look
Looking around...
Room: Room 1
Type of room: A small room with a key.
========== Items ==========
Item: Key
===========================

> pickup
Enter item: key
You picked up Key

> inventory
========== Inventory ==========
Item: Key | Description: A key to open a door.
===============================

> move
Direction: 
1. Forward 
2. Back 
3. Left 
4. Right

Choose a direction: 1
You move to Room 2
Room: Room 2
Type of room: A dark room with a sword.
========== Items ==========
Item: Sword
===========================

> look
Looking around...
Room: Room 2
Type of room: A dark room with a sword.
========== Items ==========
Item: Sword
===========================

> exit
Exiting game...

```

