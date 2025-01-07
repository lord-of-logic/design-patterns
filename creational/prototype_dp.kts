class Chess {
    var boxes: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("-", "-", "-", "-", "-", "-", "-", "-"),
        mutableListOf("-", "-", "-", "-", "-", "-", "-", "-"),
        mutableListOf("-", "-", "-", "-", "-", "-", "-", "-"),
        mutableListOf("-", "-", "-", "-", "-", "-", "-", "-"),
        mutableListOf("-", "-", "-", "-", "-", "-", "-", "-"),
        mutableListOf("-", "-", "-", "-", "-", "-", "-", "-"),
        mutableListOf("-", "-", "-", "-", "-", "-", "-", "-"),
        mutableListOf("-", "-", "-", "-", "-", "-", "-", "-")
    )

    fun clone(): Chess {
        val chess = Chess()
        chess.boxes = this.boxes
        return chess
    }

    fun printChess() {
        for (i in 0..7)
            for (j in 0..7)
                println(boxes[i][j])
    }
}

fun main() {
    val chess = Chess()
    val chessCopy = chess.clone()
    chessCopy.boxes[0][0] = "Elephant"
    chess.printChess()
    chessCopy.printChess()
}
