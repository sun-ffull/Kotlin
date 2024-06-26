//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    /*자바에서는 new 타입이름()을 이용해서 익명 클래스를 구현했지만,
    * 코틀린에서는 object: 타입이름을 이용함.*/
    moveSomething(object:Movable{
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }
    })
}

private fun moveSomething(movable: Movable){
    movable.move()
    movable.fly()
}