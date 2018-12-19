import model.Action
import model.Game
import model.Robot
import model.Rules

/**
 * Первый удар. Просто бежим к мячу и лупим в сторону чужих ворот
 *
 * Created by user on 12/19/18.
 */
class FirstKickStrategy: SelectableStrategy {
    override fun stepsMade(): Int {
        return 0
    }

    override fun stepsToGoal(): Int {
        return 0
    }

    override fun quality(): Int {
        return 0
    }

    override fun act(me: Robot, rules: Rules, game: Game, action: Action) {

    }
}