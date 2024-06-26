//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val person = Person("김해찬", 24)
    println(person.name)
    person.age = 10
    println(person.age)

    val person2 = JavaPerson("김해찬", 24)
    println(person2.name)
    person2.age = 10
    println(person2.age)

    /*호출 순서는 init의 바디->첫번째 부생성자의 바디->두번째 부생성자의 바디*/
    val person3 = Person()

    val isadult: Boolean = person3.isAdult
    println(isadult)

    println(person3.upppercaseName)
}

/*생성자 지시어 constructor는 생략이 가능하다.
* 코틀린에서는 getter와 setter를 자동으로 만들어주기 때문에 작성할 필요 없음.
* 클래스의 필드 선언과 생성자를 동시에 선언할 수 있다.*/
class Person (val name : String,
              var age: Int
) {
    /*init블록은 생성자가 호출되는 시점에 호출됨.*/
    init{
        if (age<=0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블록")
    }
    /*추가 생성자(부생성자)를 작성하고 싶다면, constructor를 이용한다. 생성자이므로, 반환형은 당연히 this이용
    * 부생성자는 body를 가질 수 잇음.
    * 그런데 보통 부생성자는 사용안하고 default parameter나 정적 팩토리 메서드를 사용함.
    * 정적팩토리 메서드 -> 생성자가 아닌, 클래스 내부 함수로 객체 반환하는 것.*/
    constructor(name: String): this(name, 1){
        println("첫번째 부생성자")
    }
    constructor(): this("asdf"){
        println("두번째 부생성자")
    }

    //fun isAdult() : Boolean {
    //    return this.age >= 20
    //}
    //fun isAdult2() = this.age>=20
    /*위의 2가지 방법은 평범하게 함수를 이용한 방법임.
    * 아래 2가지 방법은 custom getter를 활용한 방법임.
    * 위의 방법이든 아래 방법이든 자바 코드로 변환해보면 똑같이 함수를 이용한 방법으로 나타남.*/
    val isAdult
        get() = this.age >= 20
    val isAdult2: Boolean
        get(){
            return this.age >= 20
        }

    val upppercaseName
        get() = this.name.uppercase()
}

/*클래스에 필드와 생성자, getter, setter 메소드만 있다면 아래와 같이 작성 가능*/
class sample(val name:String, var age:Int)