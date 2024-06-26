//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val cat = Cat("cat")
    cat.move()

    Derived(300)
}

abstract class Animal(
    protected val species: String,
    /*추상프로퍼티가 아니라면 상속을 위해서는 꼭 open을 붙여줘야 한다.*/
    protected open val legCount: Int
) {
    abstract  fun move()
}

/*코틀린에서는 extends 대신에 :를 사용하여 상속함.
* 상속할때 상위 클래스의 생성자를 바로 호출해야됨.*/
class Cat(
    species: String
) : Animal(species, 4){    //상위클래스 생성자 바로 호출하는 부분.
    override fun move() {           //자바와 달리 어노테이션이 아닌, 지시자 override를 사용해서 오버라이드 해줌.
        println("고양이가 걸어감.")
    }
}


/*코틀린에서 인터페이스 구현할 때는 implement 대신 :를 사용.
* 따라서 그냥 , 사용
* 자바와 마찬가지로 인터페이스 객체는 못만듬*/
class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {
    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다.")
    }

    /*프로퍼티 오버라이드*/
    override val legCount: Int
        get() = super.legCount + this.wingCount

    /*중복되는 인터페이스를 특정할때 super<타입>.함수 사용함.*/
    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

    /*default 메소드를 인터페이스에 구현해놓았기 때문에 super.함수명 쓰는 듯함.
    * 그것이 아니라면, 일반적인 경우와 마찬가지로 해당 클래스에 직접 메소드를 구현해야함.*/
    override fun fly() {
        super.fly()
    }

    /*인터페이스에 선언된 backing field 없는 프로퍼티의 오버라이드.
    * 결국 getter 오버라이드를 의미하는 것 같다.. setter는 backing field가 필요할테니..*/
    override val flyability: Int
        get() = TODO("Not yet implemented")
}

/*Derived 객체 생성시 상위 클래스의 생성자가 먼저 실행.
* 하위 클래스의 프로퍼티가 아직 초기화 되기 전의 상태이므로, 상위 클래스에서
* 하위 클래스의 프로퍼티를 호출하는 아래의 코드를 사용시, 원하는 결과 안나올 수 있음.
* 정확히는 하위 클래스에서 오버라이드 하는 프로퍼티를 상위클래스에서 호출하면 안됨.
* 솔직히 잘 모르겠음. 이부분 다시 공부해야 할 듯함.*/
open class Base(
    /*상위 클래스에서 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open을 피해야함.*/
    open val number: Int = 100
) {
    init{
        println("Base Class")
        println(number)
    }
}
class Derived(
    override val number:Int
) : Base(number) {
    init{
        println("Derived Class")
    }
}