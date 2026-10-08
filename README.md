# Games I'm Working On (Java)

This repository contains my Java game development projects. Currently, it includes **Delicious In Dungeon** (in the `DungeonRun` folder).

---

## 🎮 DungeonRun (Delicious In Dungeon)

A 2D Java-based game built using standard Java libraries (Swing/AWT). It's a custom, human-made game inspired by classic GBA games.

### 🛠️ How to run the game

#### Method 1: Using Eclipse IDE (Recommended)
1. Open **Eclipse**.
2. Go to `File` > `Import` > `General` > `Projects from Folder or Archive`.
3. Select the `DungeonRun` folder inside this repository and click `Finish`.
4. In the Project Explorer, expand `DungeonRun` > `src` > `main`.
5. Right-click on `Main.java` and select `Run As` > `Java Application`.

#### Method 2: From the Command Line (Terminal)
If you have the Java Development Kit (JDK) installed, you can compile and run the game directly from the terminal.

1. Open your terminal and navigate to the `DungeonRun` folder:
   ```bash
   cd DungeonRun
   ```
2. Compile the Java files and save them to the `bin` directory:
   ```bash
   javac -d bin src/**/*.java
   ```
3. Copy the resources folder (`res`) into the `bin` directory so the game can access images and sounds:
   ```bash
   cp -r res bin/
   ```
4. Run the game:
   ```bash
   java -cp bin main.Main
   ```

---

## 📂 Repository Structure

- `DungeonRun/`: Contains the main game project.
  - `src/`: Java source code (entities, main engine, objects, tiles).
  - `res/`: Game assets (maps, objects, player sprites, sound, tiles).
- `github_update.sh`: A helper script for quickly pushing updates to GitHub.
