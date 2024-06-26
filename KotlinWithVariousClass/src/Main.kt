//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val p1 = PersonDto("김해찬",24)
    val p2 = PersonDto("김해찬", 24)
    println(p1 == p2)       //동등성
    println(p1 === p2)      //동일성
}

private fun handleCountry(country: Country){
    /*enum class를 활용하여 분기처리를 해주면 마지막에 else를 할 필요가 없다.
    * 어차피 enum클래스에 무엇이 들어있는지 컴퓨터는 알고 있기 때문*/
    when(country){
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}

private fun handleCar(car : HyundaiCar){
    /*when에 sealed class 인스턴스가 들어가면 마찬가지로 마지막에 else 할 필요없음.*/
    when (car) {
        is Avante -> TODO()
        is Sonata -> TODO()
        is Grandeur -> TODO()
    }
}

/*DTO : Data Transfer Object
* class 앞에 data를 붙이면 data class가됨. 자바와 달리 equals, hashcode, toString을 자동으로 만들어줌*/
data class PersonDto(
    val name:String,
    val age: Int,
)

/*enum class
* 클래스 상속 불가
* 하위 클래스는 모두 싱글톤으로 단일 객체이다.*/
enum class Country(
    val code: String
){
    KOREA("KO"),
    AMERICA("US"),
    ;
}

/*Sealed class, Sealed interface : 상속 가능하도록 추상 클래스를 만들고자 하는데,
* 외부에서는 이 클래스를 상속 받지 않았으면 할 때 사용.
* enum class와 달리 클래스 상속 받을 수 있고, 하위클래스 멀티 객체 가능.
* 사실 sealed가 붙었다는 것 빼곤 abstract와 다를게 없어보임.
* 하지만 컴파일 타임때 하위 클래스의 타입을 모두 기억함. 런타임에 클래스 타입 추가 불가능.*/
sealed class HyundaiCar(
    val name: String,
    val price: Long
)
class Avante: HyundaiCar("아반떼", 100L)
class Sonata: HyundaiCar("소나타", 200L)
class Grandeur: HyundaiCar("그랜저", 300L)
