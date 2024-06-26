//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val a = 10
    val b = 20

    mytest { a, b -> println(a+b) }
}

fun interface myinter{
    fun myMethod(a: Int, b: Int)
}
fun mytest(inter: myinter){
    inter.myMethod(10 , 20)
}