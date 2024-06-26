//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)
}

class Person private constructor(
    var name: String,
    var age: Int
) {
    /*companion object : 동행객체 라는뜻. 코틀린에는 static이 없어서 이를 대신해 씀.
    * 아래 블럭에 선언된 프로퍼티나 함수는 자바의 static 변수 함수인것처럼 사용됨.
    * static : 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라 정적으로 인스턴스끼리의 값을 공유 */
    companion object st{
        /*const : 상수라는의미. 없으면 런타임에 있으면 컴파일타임에 값이 넣어짐. 진짜 상수에만 사용*/
        private const val MIN_AGE = 1

        @JvmStatic      //해당 어노테이션은 자바에서 이 코틀린의 코드를 사용할때, 자바에서 사용하는 방식대로 쓰기위해 사용
        fun newBaby(name: String): Person{
            return Person(name, MIN_AGE)
        }
    }

    /*companion object MyObject{
        동행'객체'이므로 이름을 붙일 수 있고, 인터페이스 구현도 가능.
    }*/
}

/*코틀린에서의 싱글톤 생성하는 방법*/
object Singleton{
    var a:Int = 0
}