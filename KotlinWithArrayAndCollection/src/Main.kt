//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var array = arrayOf(100, 200)
    array = array.plus(300)

    for (i in array){
        println(i)
    }

    /*인덱스 넘버를 가져옴*/
    for (i in array.indices){
        println("${i} ${array[i]}")
    }

    /*인덱스와 값을 같이 가져옴*/
    for ((idx, value ) in array.withIndex()){
        println("$idx $value")
    }

    /*리스트 관련
    * 자바와는 달리 코틀린에서는 컬렉션의 불변리스트가 기본이다.
    * 즉, 새로운 요소 삽입, 기존 요소 삭제 및 수정과 같은 변경이 불가능하다.
    * 따라서 필요하다면 컬렉션을 가변(mutable)컬렉션으로 선언해 주어야한다.
    * 우선은 불변리스트를 만들고, 꼭 필요한 경우 가변리스트로 바꾸는 것을 추천한다고 함.
    * 컬렉션 -- list, set, map*/
    val numbers = listOf(100, 200)
    val numbers2 = mutableListOf(100, 200)          //ArrayList가 기본 구현체임.
    /*빈 리스트 같은 경우 타입을 설정해 주어야함.*/
    val emptyList = emptyList<Int>()

    numbers2.add(300)       //number.add(300)은 불가능.

    /*하나 가져오기*/
    println(numbers.get(0))
    println(numbers[0])

    /*향상된 for 문*/
    for (number in numbers){
        println(number)
    }

    for ((idx, value) in numbers.withIndex()){
        println("${idx} ${value}")
    }

    /*set관련*/
    val numbers3 = setOf(100, 200)
    val numbers4 = emptySet<Int>()
    val numbers5 = mutableSetOf(100, 200)       //기본 구현체는 LinkedHashSet임.

    for (number in numbers3){
        println(number)
    }

    for ((index, number) in numbers3.withIndex()){
        println("$index $number")
    }

    /*map 관련*/
    val oldMap = mutableMapOf<String, Int>()
    /*맵에 값을 저장하는 2가지 방법*/
    oldMap["a"] = 1
    oldMap.put("b", 2)

    mapOf(1 to "a", 2 to "b")       //맵 선언하는 다른방법 Int key, String value

    for (key in oldMap.keys){
        println(key)
        println(oldMap.get(key))
        //println(oldMap[key])
    }

    for ((key, value) in oldMap.entries){
        println(key)
        println(value)
    }
}