/**
 * Нужен только потому что нельзя изменять Strategy
 *
 * Created by user on 12/19/18.
 */
interface SelectableStrategy: Strategy {
    fun stepsMade(): Int
    fun stepsToGoal(): Int
    fun quality(): Int
}