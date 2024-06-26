//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}

fun getGradeWithSwitch(score: Int): String{
    /*코틀린에서는 switch-case문이 사라지고, when이 생겼다.
    * when은 if-else와 마찬가지로 Expression이다.
    * switch 대신에 when을 쓰고, case 대신에 분기문(ex)9 -> "A")를 쓰고, default대신에 else를 쓴다.*/
    return when (score/10){
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }

    /*또한 특정값으로만 분기를 치는것 뿐 아니라, 다양한 조건을 가지고 분기를 칠 수 있다.*/
    return when(score){
        in 90..100 -> "A"
        in 80..89 ->"B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWIthA(obj: Any?): Boolean{
    /*다음과 같은 조건을 가지고 분기를 칠 수 있다.
    * obj는 null일 수 있지만, is String으로 한번 검증했으니(스마트 검증), ?.이 아닌 그냥 .를 사용할 수 있다.*/
    return when(obj){
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int){
    /*다음과 같이 분기를 칠 수 있음.*/
    when(number){
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int){
    /*다음과 같이 when에 값이 없을 수 있다.
    * when에 값이 있다면 해당 값과 조건을 비교하며 확인하는 것이고,
    * 값이 없다면 그냥 조건을 확인하는 것이다.*/
    when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}

//when은 Enum class 혹은 Sealed Class와 함께 사용할 경우, 더욱더 진가를 발휘한다...라고함.