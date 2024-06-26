//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/*클래스 안에 클래스를 선언할 땐 static class로 선언하도록 권장됨.
* static 클래스로 선언하지 않으면, 외부 클래스에 대한 참조를 할 수 있고, 이는 여러 문제를 야기할 수 있음.
* 코틀린에서는 이러한 권장 사항을 충실히 따르고 있음.*/
fun main() {

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom,
) {
    /*코틀린에서는 클래스 안에 클래스 선언 시 자동을 static 클래스로 선언됨.
    * static 클래스로 선언하기 싫으면 inner키워드를 사용함.*/
    class LivingRoom(
        private val area: Double,
    )

    /*권장되지 않는 클래스 안의 클래스
    * 바깥 클래스를 참조하고 싶다면 inner카워드를 사용.*/
    inner class LivingRoom2(
        private val area: Double,
    ) {
        val address
            /*바깥클래스 참조하려면 this@바깥클래스 사용*/
            get() = this@House.address
    }
}