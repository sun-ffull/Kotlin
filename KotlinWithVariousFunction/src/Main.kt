//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val str: String = "ABC"
    println(str.lastChar())
}

/*확장함수
* fun 확장하려는클래스.함수이름(파라미터): 리턴타입{}
* this를 이용해 실제 클래스 안의 값에 접근
* this를 수신객체라 부르고, 확장하려는클래스를 수신객체 타입이라 함.
* 아래의 경우 원래 String에 있는 멤버함수처럼 사용할 수 있음.*/
fun String.lastChar() = this[this.length-1]

/*확장 프로퍼티도 가능함*/
val String.lastChar: Char
    get() = this[this.length-1]

/*주의점. 확장함수에서는 수신객체의 private, protected를 가져올 수 없음.
* 캡슐화가 깨지는것처럼 보이기 때문. -- 밖에서 작성된 함수가 내부 private, protected에 접근*/

/*확장함수와 멤버함수의 시그니처(함수이름)이 동일하면 멤버함수가 우선적으로 호출됨.*/

/*확장함수는 현재 타입을 기준으로 호출됨.
* 변수를 선언한 타입에 맞게끔 호출됨. 객체를 기준으로 호출되는 것이 아님.
* val train: Train=Train()
* train.isExpensive()       //Train의 확장함수
*
* val srt1: Train=Srt()
* srt1.isExpensive()        //Train의 확장함수
*
* val srt2: Srt = Srt()
* srt2.isExpensive()        //Srt의 확장함수
* */
open class Train(
    val name: String = "새마을기차",
    val price: Int = 5000,
)
fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10000
}


class Srt: Train("SRT", 40000)
fun Srt.isExpensive(): Boolean{
    println("Srt의 확장함수")
    return this.price >= 10000
}

/*함수 호출을 방식을 바꿔주는 infix 함수가 존재 ex)a.함수(b) -> a 함수 b*/

/*함수를 복사-붙여넣기 하는 inline함수 존재*/

/*함수안에 함수인 지역함수 존재. 그러나 잘 사용하지는 않는다고 함.*/