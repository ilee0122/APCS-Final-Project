# BattleBoats
**Team CHANPION KYUODERS**

## How to Run
```
git clone https://github.com/ilee0122/APCS-Final-Project.git
```
```
cd APCS-Final-Project
```
```
javac MainMenu.java
```
```
javac GameLogic.java
```
```
javac LaunchGame.java
```
```
java LaunchGame
```

## How to Play
1. Grab a friend or find one if you do not currently have one. :(
2. Customize the game by setting the number of each ship and their lengths and the size of the board.  Or just use the default settings.
3. Press Start Game!
4. Place your ships where you want by dragging them from the side onto the grid.  Right click the ship to rotate it.  If you are too lazy, have the computer place the ships for you by pressing Randomize Grid.
5. Click the place on the Grid where you think your opponent's ships are.
6. Hand the computer to the other player so they can make their move.
7. No peeking! Don't look at the location of your opponent's ships or else...
8. Play until all of one player's ships are destroyed.
9. Brag to the loser! >:)

## Customization
![Battle Boat Main Menu](https://github.com/ilee0122/APCS-Final-Project/blob/master/BattleBoatMainMenu.jpeg)
- Grid Width: Change the size of the grid.
- Length of ______: Change the size of that type of ship.
- Number of ______: Change the amount of that type of ship.


## Development Log
### Before the Demo
- Created Main Menu screen with buttons.
- Made the main menu buttons functional.
- Created screen with two grids: one to attack and one displaying your own ships.
- Players can drag the ships onto the grids to place them.
- Ships can be rotated when placed.
- Ships can be randomly placed onto the grid.
- If a ship piece is hit, then it displays the correct image.
- A damaged ship will also show on the small grid.
- If an enitre ship is destroyed, then the ship disappears.
- Created a screen in between turns to make it harder to cheat.
- Put directions on the in between turns screen.
- When someone wins, the correct screen displays.
- Created grid customization button on main menu screen. 
- Created error messages so all the ships can fit on the grid when customizing. 

### After the Demo
- Fixed button sizes on the main menu screen.
- When ships are destroyed, they turn red instead of disappearing.

### Removed Features
- Powerups: Decided to stay true to the original BattleShip.
- Remember Layouts: Having the same layout would make the game boring.
- Scrambling ships after each turn: Makes the game too confusing.

### Fixed Bugs
- An incorrect box would be selected when the player clicks the grid.
- The ships did not rotate when the player right clicks.
- Ships would overlap when the randomize button is pressed.
- Ships can be overlapped when the players drag a ship on top of another.
- Players can fire at a box already previously fired at or with an already destroyed ship. 

## Acknowledgments 
Thank you Mr. K and the Internet for making this all possible!

## Team CHANPION KYUODERS
- Nicholas Chan, pd 10
- Il Lyu Lee, pd 10
 
