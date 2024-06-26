//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3500),
        Fruit("바나나", 3200),
        Fruit("수박", 10000),
    )

    /*변수에 함수를 할당하는 2가지 방법.
    * (Fruit) -> Boolean : Fruit 타입 매개변수를 받고 Boolean 타입을 반환하는 함수를 할당하겠다는 의미 이 부분은 작성안해도됨.
    * 아래 방법은 함수에 이름 없음. 익명함수
    * 람다만드는 방법1*/
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean{
        return fruit.name == "사과"
    }
    /*아래 방법은 일반적인 람다 함수라고 보면 될듯?
    * 람다 만드는 방법2 이 방법을 선택하는게 더 깔끔해 보임.*/
    val isApple2: (Fruit) -> Boolean = {fruit: Fruit -> fruit.name == "사과"}

    /*변수에 할당된 함수 사용. 변수가 곧 함수이므로 일반 함수사용하는 것과 똑같이 해도됨.*/
    isApple(fruits[0])
    isApple.invoke(fruits[0])

    /*아래 방식 모두 가능*/
    filterFruits(fruits, isApple)
    filterFruits(fruits, {fruit: Fruit -> fruit.name == "사과"})
    filterFruits(fruits) {fruit: Fruit -> fruit.name == "사과"}   //마지막 파라미터가 함수인 경우 중괄호 밖으로 빼기 가능
    filterFruits(fruits) {it.name == "사과"}                      //매개변수가 1개일 경우 매개변수를 it으로 대체 가능. 비추천.
    filterFruits(fruits, fun(fruit: Fruit): Boolean{
        return fruit.name == "사과"
    })

    /*람다에는 여러 줄 작성 가능하고, 가장 마지막 줄의 결과가 람다의 반환값임.*/
    filterFruits(fruits) {fruit: Fruit ->
        println("!!!")
        fruit.name == "사과"
    }

    /*Closure : 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있음.
    * 아래 코드는 자바에서는 오류가 나오는 구문. 람다내부에서 외부 변수를 참조할때 외부변수가 final로 선언되어 있어야함.
    * 코틀린에서는 final로 선언 안되어 있어도 상관없음.*/
    var targetFruitName: String = "바나나"
    targetFruitName = "수박"
    filterFruits2(fruits){it.name == targetFruitName}

    /*List를 Map으로 바꾸는 방법
    * 아래의 방법은 해당하는 과일 이름으로 이루어진 List가 map의 value로 저장됨.
    * groupBy말고 associateBy란 것도 있다함. value를 리스트가 아닌 단일 객체로 받는것 같음.*/
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit->fruit.name }
    /*다음과 같이 키:과일명 밸류:과일가격 등등 지정할 수 있음.*/
    val map2: Map<String, List<Int>> = fruits.groupBy({fruit->fruit.name}, {fruit -> fruit.price })
    /*아래와 같이 응용가능. 먼저 groupBy로 맵을 만들고, key가 사과인것만 필터링함. 결국 key가 사과인 List만 있는 맵이 만들어짐.*/
    val map3: Map<String, List<Fruit>> = fruits.groupBy {fruit -> fruit.name}
        .filter { (key,v) -> key=="사과" }
}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit>{
    val results = mutableListOf<Fruit>()
    for (fruit in fruits){
        if (filter(fruit)){
            results.add(fruit)
        }
    }

    return results
}

private fun filterFruits2(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit>{

    /*컬렉션 처리하는 기능. 매개변수에 넣은 함수를 기준으로 필터링해줌.*/
    return fruits.filter(filter)

    /*코틀린에는 다양한 컬렉션 처리 기능이 있다.
    * 예시) all/none/any/count/sortedBy/sortedByDescending/distinctBy/first/fisrtOrNull/last/lastOrNull*/
}

class Fruit(
    val name : String,
    val price: Int,
)