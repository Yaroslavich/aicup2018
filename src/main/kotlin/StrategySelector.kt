import model.Action
import model.Game
import model.Robot
import model.Rules

/**
 * Выбор лучшей на данный момент стратегии
 *
 * Created by user on 12/19/18.
 */
object StrategySelector {
    private var chosenStrategies: MutableMap<Int, SelectableStrategy> = mutableMapOf()

    private val allStrategies = listOf(
            FirstKickStrategy()
    )

    fun selectAndAct(me: Robot, rules: Rules, game: Game, action: Action) {
        val currentStrategy = chosenStrategies[me.id] ?: FirstKickStrategy()

        if (isGoodEnough(currentStrategy)) {
            currentStrategy.act(me, rules, game, action)
            return
        }

        var bestStrategy = currentStrategy
        var bestQuality = currentStrategy.quality()
        for (strategy in allStrategies) {
            if (StopWatch.remaining() < 0.1) {
                bestStrategy.act(me, rules, game, action)
                return
            }

            val strategyQuality = strategy.quality()
            if (strategyQuality <= bestQuality) continue
            if (!isGoodEnough(strategy)) continue

            bestStrategy = strategy
            bestQuality = strategyQuality
        }

        bestStrategy.act(me, rules, game, action)
    }

    private fun isGoodEnough(currentStrategy: SelectableStrategy): Boolean {
        // тут могут быть дополнительные отсечения
        return (currentStrategy.quality() > 0.5)
    }
}