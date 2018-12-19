import model.*

class MyStrategy : Strategy {

    override fun act(me: Robot, rules: Rules, game: Game, action: Action) {
        StopWatch.reset()

        if (game.current_tick == 0) {
            onStart(me, rules, game, action)
        }

        GameHistory.analyze(me, rules, game)
        StrategySelector.selectAndAct(me, rules, game, action)

        // если осталось время займемся анализом
        GameHistory.analyzeMore(me, rules, game)
    }

    private fun onStart(me: Robot, rules: Rules, game: Game, action: Action) {

    }
}
