//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}

fun validateScoreIsNotNegative(score: Int){
    if (score !in 0..100){
        throw IllegalArgumentException("score는 0부터 100입니다.")
    }else if (score in 0..100){
        println("score는 ${score}입니다.")
    }
}

fun getPassOrFail(score: Int) : String{
    /*코틀린에서 if-else문은 Expression이다. 즉, 하나의 값으로 취급한다.
    * 자바에선 if-else문은 statement이다.
    * 자바에선 삼항 연산자인 boolean ? v1 : v2가 Expression이다.
    * 코틀린에서는 따라서 삼항연산자가 존재하지 않는다. if-else가 삼항연산자 역할을 대신해서 불필요하기 때문*/
    return if (score >= 50){
        "P"
    }else {
        "F"
    }

    if (score >= 50){
        return "P"
    }
    else {
        return "F"
    }
}

fun getGrade(score : Int) :String{
    /*if-elseif-else도 else-if와 마찬가지로 Expression이다.*/
    return if (score >= 90){
        "A"
    }else if (score >= 80){
        "B"
    }else if (score >= 70){
        "C"
    }else if (score >= 60){
        "D"
    }else {
        "F"
    }
}