import java.util.*

val scanner = Scanner(System.`in`)

// ladder and snake input data
fun inputData(mp: HashMap<Int, Int>, len: Int) {
    repeat(len) {
        val start: Int = scanner.nextInt()
        val end: Int = scanner.nextInt()

        //check valid start and end position of ladder or snake
        if (start >= 1 && end <= 100) {
            mp[start] = end
        }
    }
}

//function to calculate final position after all dice rolls
fun getFinalPosition(
    initialPosition: Int,
    diceRolls: List<Int>,
    ladders: HashMap<Int, Int>,
    snakes: HashMap<Int, Int>,
): Int {
    var currentPosition = initialPosition
    for (roll: Int in diceRolls) {

        val nextPosition: Int = currentPosition + roll

        if (nextPosition == 100) {
            currentPosition = nextPosition
            break
        } else if (nextPosition < 100) {
            currentPosition = nextPosition
        }

        if (ladders.containsKey(currentPosition)) {
            currentPosition = ladders[currentPosition]!!
        } else if (snakes.containsKey(currentPosition)) {
            currentPosition = snakes[currentPosition]!!
        }
    }

    return currentPosition
}

fun main() {

    val ladders: HashMap<Int, Int> = HashMap() //ladder positions
    val snakes: HashMap<Int, Int> = HashMap() //snake positions

    val noOfLadders: Int = scanner.nextInt()
    inputData(ladders, noOfLadders)

    val noOfSnakes: Int = scanner.nextInt()
    inputData(snakes, noOfSnakes)

    scanner.nextLine() //nextInt() does not read newline character, nextLine() read rest of that line till \n

    val diceRolls: List<Int> = scanner.nextLine().split(" ").map { it.toInt() }

    val finalPosition: Int = getFinalPosition(0, diceRolls, ladders, snakes)

    println("Final Position of player after all dice rolls is: $finalPosition")
}