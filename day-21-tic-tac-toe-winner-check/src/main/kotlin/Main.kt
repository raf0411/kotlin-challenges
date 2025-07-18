package org.example

fun checkWinner(board: List<List<Char>>): Char? {
    var winner: Char? = null

    if (checkRows(board, 'X') != null) {
        winner = 'X'
    } else if (checkRows(board, 'O') != null) {
        winner = 'O'
    } else if (checkColumns(board, 'X') != null) {
        winner = 'X'
    } else if (checkColumns(board, 'O') != null) {
        winner = 'O'
    } else if (checkDiagonals(board, 'X') != null) {
        winner = 'X'
    } else if (checkDiagonals(board, 'O') != null) {
        winner = 'O'
    }

    return winner
}

// SUGGESTED CODE
fun checkWinnerAI(board: List<List<Char>>): Char? {
    // Check if 'X' has won in any way
    if (checkRows(board, 'X') != null ||
        checkColumns(board, 'X') != null ||
        checkDiagonals(board, 'X') != null) {
        return 'X'
    }

    // Then, check if 'O' has won in any way
    if (checkRows(board, 'O') != null ||
        checkColumns(board, 'O') != null ||
        checkDiagonals(board, 'O') != null) {
        return 'O'
    }

    // If neither has won, there is no winner
    return null
}

fun checkRows(board: List<List<Char>>, char: Char): Char? {
    board.forEach { rows ->
        if ( rows.all { it == char } ) {
            return char
        }
    }

    return null
}

fun checkColumns(board: List<List<Char>>, char: Char): Char? {

    val chars = ArrayList<Char>()

    for (i in 0..<board[0].size) {
        for (j in 0..<board.size) {
            if (chars.size == board[0].size && chars.all { it == char }) return char
            else if (chars.size == board[0].size) chars.clear()

            chars.add(board[j][i])
        }
    }

    return null
}

// SUGGESTED CODE
fun checkColumnsAI(board: List<List<Char>>, player: Char): Char? {
    for (colIndex in 0..2) {
        if (board[0][colIndex] == player &&
            board[1][colIndex] == player &&
            board[2][colIndex] == player) {
            return player
        }
    }
    return null
}

fun checkDiagonals(board: List<List<Char>>, char: Char): Char? {
    val leftSideChars = arrayListOf(board[0][0], board[1][1], board[2][2])
    val rightSizeChars = arrayListOf(board[0][2], board[1][1], board[2][0])

    if (leftSideChars.all { it == char } || rightSizeChars.all { it == char }) return char
    return null
}

fun main() {
    val board1 = listOf(
        listOf('X', 'O', 'O'),
        listOf(' ', 'X', ' '),
        listOf(' ', 'O', 'X') // X wins on a diagonal
    )

    val board2 = listOf(
        listOf('X', 'O', 'X'),
        listOf(' ', 'O', ' '),
        listOf(' ', 'O', 'X') // O wins on a column
    )

    val board3 = listOf(
        listOf('X', 'O', 'X'),
        listOf('X', 'O', 'O'),
        listOf('O', 'X', 'X') // No winner, it's a draw
    )

    val board4 = listOf(
        listOf(' ', ' ', ' '),
        listOf(' ', ' ', ' '),
        listOf(' ', ' ', ' ') // Empty board
    )

    println("Winner of board 1: ${checkWinner(board1)}")
    println("Winner of board 2: ${checkWinner(board2)}")
    println("Winner of board 3: ${checkWinner(board3)}")
    println("Winner of board 4: ${checkWinner(board4)}")
}

/*
    Winner of board 1: X
    Winner of board 2: O
    Winner of board 3: null
    Winner of board 4: null
*/