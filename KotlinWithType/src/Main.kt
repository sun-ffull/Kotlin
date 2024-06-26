//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val num: Int? = 3;
    val num2: Long = num?.toLong() ?: 0;

    val person = Person("김해찬",24);
    printAgeIfPerson(null);

    /*"""를 사용하면 자동으로 trimIndent()가 생성된다.
    * 코틀린에서는 자바와 달리 문자열 인터폴레이트 할 때 String.format()을 이용하는 것이 아닌,
    * ""안에 ${변수명}을 이용해서 인터폴레이트 한다. */
    val str = """
        AFdsf grgw
        fsd
        ${person.name} ${person.age}
    """.trimIndent()
    println(str);

    /*코틀린에서는 자바와 달리 문자열에서 특정 문자를 탐색할 때 str.charAt()을 사용하지 않고,
    * 배열에서 특정 인덱스를 찾듯이 str[index]를 사용한다.*/
    val str2 = "absc"
    println(str2[2])
}

/*자바의 object 클래스와 코틀린의 Any는 동일. 다만 Any는 null을 담지 못하므로, null까지 담으려면 Any?로 선언해야함.
* Any에 equals, hashCode, toString 메소드 존재함.*/
fun printAgeIfPerson(obj: Any?) {
    /*as? 사용하면 obj 가 null이면 null, Person 타입이 아니면 null, Person 타입이면 Person으로 변환됨.
    * 그냥 as 사용하면 다른건 같지만, Person 타입이 아닌경우 null이 아닌 에러가 발생함.
    * 아무튼, as는 타입 캐스팅에 사용됨. (기본 타입의 경우 toType이용)*/
    val person2: Person? = obj as? Person
    println(person2?.age)

    /*is는 자바의 instanceof와 동일 의미. value !is type은 value가 type이 아닌경우라는 의미.
    * 아무튼, is는 타입 확인에 사용됨.*/
    if (obj is Person){
        val person = obj as Person
        println(person.age)
    }
    else if (obj !is Person){

    }
}