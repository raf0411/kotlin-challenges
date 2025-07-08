package org.example

data class Bounds (
    val width: Int,
    val height: Int
)

data class Position (
    var x: Int,
    var y: Int
)

class Player (x: Int, y: Int) {
    val position = Position(x, y)

    // My Dumb Code
    fun processMoves(moves: String, bounds: Bounds) {
        val movesList = moves.toList()

        movesList.forEach { move ->
            when (move) {
                'N' -> { if (position.y > 0) position.y -= 1 } // Move Down
                'S' -> { if (position.y < bounds.height - 1) position.y += 1 } // Move Up
                'E' -> { if (position.x < bounds.width - 1) position.x += 1 } // Move Right
                'W' -> { if (position.x > 0) position.x -= 1 } // Move Left
                else -> { println("Invalid Move : $move") }
            }
        }
    }

    // Suggested Code
//    fun processMoves(moves: String, bounds: Bounds) {
//        for (move in moves) {
//            var proposedX = position.x
//            var proposedY = position.y
//
//            when (move) {
//                'N' -> proposedY -= 1
//                'S' -> proposedY += 1
//                'E' -> proposedX += 1
//                'W' -> proposedX -= 1
//            }
//
//            // A single check to see if the proposed move is valid
//            if (proposedX >= 0 && proposedX < bounds.width && proposedY >= 0 && proposedY < bounds.height) {
//                position.x = proposedX
//                position.y = proposedY
//            }
//        }
//    }
}

fun main() {
    val gridBounds = Bounds(width = 5, height = 5)
    val player = Player(x = 0, y = 0)

    val moves = "NNEESW"
    player.processMoves(moves, gridBounds)

    println("Player's final position: ${player.position}")
}

/*
    OUTPUT :

    Player's final position: Position(x=1, y=1)
*/