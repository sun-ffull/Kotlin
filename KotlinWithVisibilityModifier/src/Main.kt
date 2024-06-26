//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}

/*public : 기본값으로 어디서든 접근 가능
* protected : 파일(최상단)에는 사용 불가능. 클래스나 메소드 안에서만 사용할 수 있다는 의미 같음.
* internal : 같은 모듈에서만 접근 가능
* private : 같은 파일 내에서만 접근 가능
* -->따라서 자바에서 코틀린 코드를 사용할 때는 internal과 protected를 주의해서 사용해야함.
* internal은 자바에서 public으로 변환되고, protected는 자바에서 그대로 사용하지만, 의미가 달라서
* 같은 패키지에 있어도 접근 가능하게됨. 코틀린에서 작성할 때는 그러한 의도가 아니었음에도.*/

/*protected의 경우 자기 자신과 하위 클래스에서만 사용할 수 있으므로, open을 꼭 붙여줘야함.
* 생성자 앞에 접근제어 지시어를 사용할 경우 constructor를 같이 써준다.*/
open class Cat protected constructor(

) {

}

class Car(
    internal val name: String,      //name, getter를 internal로 설정
    private var owner: String,      //owner, getter, setter를 private로 설정
    _price: Int
) {
    var price = _price
        private set                 //setter만 private로 설정
}