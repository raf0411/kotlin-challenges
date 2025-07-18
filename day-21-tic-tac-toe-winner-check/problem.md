Day 21: Tic-Tac-Toe Winner Check ⭕❌

    This is a classic logic puzzle that requires you to break the problem down into smaller pieces.

The Goal

    You are given the state of a 3x3 Tic-Tac-Toe board, represented as a list of lists of characters. Your task is to write a function that checks this board to see if a player ('X' or 'O') has won the game.
    
    Breaking Down the Problem

A player wins if they have three of their marks in a line. You need to check all 8 possible winning lines:

    The 3 horizontal rows.

    The 3 vertical columns.

    The 2 diagonals.

Hint

The core of this problem is systematically checking these 8 lines. It's a great idea to write separate helper functions to keep your code organized (e.g., checkRows(), checkColumns(), checkDiagonals()). Your main function can then call these helpers. The function should return the winning player's symbol ('X' or 'O') or null if there is no winner yet.

Output

    Winner of board 1: X
    Winner of board 2: O
    Winner of board 3: null
    Winner of board 4: null