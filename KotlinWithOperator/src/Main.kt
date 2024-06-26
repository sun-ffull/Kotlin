//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val money1 = JavaMoney(2_00L)
    val money2 = money1
    val money3 = JavaMoney(1_00L)

    /*자바와는 달리 compareTo를 명시적으로 사용하지 않아도 오버라이드 된 해당 메소드를 자동으로 호출해줌.*/
    if (money1 > money3){
        println("money1이 money2보다 금액이 큽니다.")
    }

    /*자바와 달리 코틀린에서는 ===으로 동일성을, ==으로 동등성을 검사한다.
    * 동일성 : 주소일치 여부
    * 동등성 : 값의 일치 여부
    * 자바에서는 ==으로 동일성을, equals로 동등성을 검사함. 물론, 코틀린에서 ==을 사용하면 간접적으로
    * equals를 호출해주는 것이긴하다.*/
    println(money1 === money2)
    println(money1 == money3)

    /*코틀린도 자바와 동일하게 Lazy연산을 수행함.
    * Lazy연산이란? --> 특정 조건문에서 앞의 것만으로도 확정되면, 뒤의 것은 보지 않는다.
    * 아래의 경우 fun1()을 했는데 true이므로, 뒤에 있는 fun2()는 실행하지 않음.*/
    if (fun1() || fun2()){
        println("본문")
    }
}

fun fun1(): Boolean{
    println("fun1")
    return true
}

fun fun2(): Boolean{
    println("fun2")
    return false
}

//코틀린에서는 기본 연산자 오버로딩도 가능하다고 한다.. 뭔진 잘 모르겠다...
//객체 + 객체를 구현하려면, 객체.plus(객체)를 해야했는데, 코틀린에서는 오버로딩을 통해
//객체 + 객체로 가능하게 한다고함...