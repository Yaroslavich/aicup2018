import model.Ball
import model.Game
import model.Robot
import model.Rules
import java.util.*

/**
 * Данные о предыдущих тиках для анализа
 *
 * Created by user on 12/19/18.
 */
object GameHistory {
    val historyLength = 100
    val ballHistory = ArrayDeque<Ball>(historyLength)

    fun analyze(me: Robot, rules: Rules, game: Game) {
        ballHistory.addLast(game.ball)
    }

    fun analyzeMore(me: Robot, rules: Rules, game: Game) {

    }
}