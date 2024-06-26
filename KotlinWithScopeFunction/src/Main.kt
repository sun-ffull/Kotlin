//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/*scope function은 일시적인 영역을 만들어 코드를 더 간결하게 하거나, method chain에 활용됨.
* 종류로는 let, run  ,, also, apply ,, with가 있음. with 빼고 다 확장함수.*/
fun main() {

}

fun printPerson(person: Person?){
    /*let : scope function의 한 종류. 함수를 받아서 그 함수를 실행시킴.*/
    person?.let {
        println(it.name)
        println(it.age)
    }
    if (person != null){
        println(person.name)
        println(person.age)
    }
}

class Person(
    val name: String,
    val age: Int,
)