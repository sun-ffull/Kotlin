//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    repeat("asdf")
    /*num=4 부분을 named Argument라고함 named Argument인 부분 제외하고 나머지는 default값이 들어감.
    * named Argument 장점 : builder를 쓰지 않고, builder의 장점을 쓰게됨.
    * -> 자료형이 동일한 파라미터에 값을 헷갈리지 않고 설정해 줄 수 있음.
    * 단, 자바함수를 가져다 쓸때는 named Argument를 사용할 수 없음.*/
    repeat("asdf", num=4)

    /*배열을 가변인자의 argument로 전달해 줄때는 앞에 스프레드 연산자인*를 붙인다. */
    val array = arrayOf("A", "B", "C")
    printAll(*array)
    /*가변인자를 사용할때 무조건 배열 형식으로 넘겨줘야 하나보다..*/
    val list = arrayListOf<String>("x", "y", "z")
    printAll(*list.toTypedArray())
    printAll("a", "b", "c")

    myfun("hae", "kkk")
}

fun max(a:Int, b:Int):Int{
    return if(a>b) {
        a
    } else {
        b
    }
}
/*함수가 하나의 값일 경우 중괄호를 이용한 block대신에 =을 사용할 수 있으며,
* =을 사용하는 경우 반환타입의 생략이 가능하다(알아서 추론해주기 때문).
* block을 쓰는 경우, unit(void)가 아닌 경우 반드시 반환타입을 표시해야함.
* if-else구문에서도 간단한 경우 중괄호 생략 가능. 아래의 경우는 중괄호 내용물이 한줄이기 때문에 가능함.*/
fun max2(a:Int, b:Int) = if(a>b) a else b

/*default 파라미터를 적용함. str 값만 입력할 경우, 자동으로 num에는3 useNewLine에는 true를 넣어줌.
* 물론, 코틀린에서도 오버로딩이 가능하기 때문에 오버로딩 방식 이용해도 됨.
* 오버로딩과 같이 사용하면, 매개변수가 더 작은 것을 우선순위로 처리되는 듯 함.
* 즉, 사용한 방법이 매개변수가 4개인 repeat와 5개인 repeat 모두를 만족한다면,
* 매개변수가 4개인 repeat가 실행됨.*/
fun repeat(str:String, num:Int=3, useNewLine:Boolean=true, testNum:Int = 100){
    for (i in 1..num){
        if (useNewLine){
            println(str)
        }else{
            print(str)
        }
    }
}
fun repeat(str:String, num:Int=3, useNewLine:Boolean=true, testNum:Int = 100, testNum2:Int = 200){
    println(str)
}

/*가변인자를 매개변수로 받을 때는 vararg를 앞에 붙인다. */
fun printAll(vararg strs: String){
    for (str in strs){
        println(str)
    }
}

fun myfun(str: String, str2: String="kim"){
    println(str)
    println(str2)
}
fun myfun(str: String, str2: String, num:Int=10){
    println(str)
    println(str2)
}