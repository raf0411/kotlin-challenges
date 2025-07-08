Day 17: Grid Navigator 🧭



As you requested, this challenge is focused on practicing logic and state management.



The Goal



You are creating a simple movement system for a character in a 2D game. The character starts at a specific coordinate on a grid and must process a sequence of movement commands (North, South, East, West). Your task is to track the character's final position while ensuring they can never move outside the grid's boundaries.



Expected Outcome



&nbsp;   A way to represent the character's x and y coordinates. A data class is a good choice for this.



&nbsp;   A method or class that takes a string of movement commands (e.g., "NNEESW") and updates the character's position.



&nbsp;   Your movement logic must correctly ignore any command that would move the character off the grid. For example, if the character is at the top edge (y=0), any 'N' (North) command should be ignored.



Hint



Think carefully about the state you need to manage: the player's current x and y coordinates. You'll need to check the proposed new position against the grid boundaries before you update the player's actual position. A when expression is a great way to handle the logic for the different command characters.



OUTPUT



Player's final position: Position(x=1, y=2)

