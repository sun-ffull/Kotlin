//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*코틀린에서 null이 들어갈 수 있는 타입은 반드시 ?를 붙여야 한다.*/
    val str: String? = "ABC";
    println(startWithA(str));

    /*코틀린에서 자바의 코드를 사용할 때 null 참조에 유의해야한다.
    * 가장 베스트는 자바 코드에 null 관련 annotation을 참고하는 것이다. 만약 자바 코드에 그러한
    * 어노테이션이 없다면 따로 null 가능성을 체킹한다.*/
    val person = Person("Afdsf");
    startWithA4(person.name);
}

fun startWithA1(str:String?) : Boolean{
    /*매개변수 str은 null 가능성이 있다.
    * 반환 값은 null이어서는 안된다.
    * str이 null일경우 str?.startsWith("A")이 구문이 통째로 null이 되고,
    * throw IllegalArgumentException("null is entered")이 구문이 실행된다.
    * 만약 null이 아닐경우 str?.startsWith("A")이 구문이 실행되고 그 값을 반환한다.
    * ?:는 엘비스 연산자로, 앞에 있는 값이 null이면 뒤에 있는 구문을 사용한다.*/
    return str?.startsWith("A") ?: throw IllegalArgumentException("null is entered");
}

fun startWithA2(str: String?): Boolean?{
    return str?.startsWith("A")
}

fun startWithA3(str: String?): Boolean{
    /*str이 null이면 false 반환
    * null아니면 첫글자 "a"인지 확인하고 결과 반환*/
    return str?.startsWith("a") ?: false;
}

fun startWithA4(str: String): Boolean{
    /*매개변수 str이 null아님이 보장되어 있음. 따라서 safe call(?.)을 사용하지 않아도 됨.*/
    return str.startsWith("A");
}

fun startWithA(str: String?): Boolean {
    /*매개변수 str이 null일 수 있지만, 정말 null이 아님을 확신할 경우 !!.을 사용하여
    * 해당 값이 절대 null이 아님을 컴파일러에게 주장함. 만약 null이 들어올 경우 런타임에 엔피(NPE == NullPointerException)발생함.*/
    return str!!.startsWith("A");
}