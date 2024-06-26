interface Flyable {

    /*코틀린에서는 backing field 없는 프로퍼티를 인터페이스에 선언가능
    * 구현부에서 getter를 오버라이드 해줄것이라고 생각하는 것.
    * 코틀린에서 프로퍼티란? -> 값을 나타내는 필드와 getter, setter를 모두 포함하는 것을 말함.*/
    val flyability: Int

    /*자바에서의 default 메소드
    * 코틀린에서는 default라는 키워드 없이 구현 가능*/
    fun act(){
        println("파닥파닥")
    }

    /*자바에서의 추상 메소드*/
    fun fly(){
        println("날수있어!")
    }
}