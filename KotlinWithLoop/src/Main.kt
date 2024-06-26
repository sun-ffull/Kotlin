//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val numbers = listOf(1L, 2L, 3L)
    /*자바의 향상된 for문(for each)와 유사함. iterable이 구현된 타입이라면 모두 가능.
    * iterable이 구현된 타입. ex) ArrayList, List 등등..*/
    for (number in numbers){
        println(number)
    }

    /*..은 등차수열을 만들어주는 함수.
    * step N은 공차가 N인 등차수열을 만든다는 의미.
    * downTo는 공차가 음수인 등차수열을 만든다는 의미.
    * downTo와 step도 함수임. (중위 호출 함수)
    * 변수.함수이름(argument)대신 변수 함수이름 argument를 사용함.
    * 그렇다면.. (..)은 rangeTo라는 함수인데.. 이것도 중위호출 함수이지 않을까?*/
    for (i in 1..3){
        println(i)
    }
    for (i in 3 downTo 1 step 2){
        println(i)
    }
    for (i in 1..5 step 2){
        println(i)
    }

    /*자바의 while문과 완전히 똑같음. do-while문도 마찬가지임.*/
    var i = 1
    while(i <= 3){
        println(i)
    }
}