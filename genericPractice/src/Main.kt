//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val arr0 = Array<cls0>(3) {cls0()}
    val arr1 = Array<cls1>(3) {cls1()}
    val arr2 = Array<cls2>(3){ cls2()}
    val list = List<Int>(3){1}

    testArrFun0(arr2)
    testArrFun1(arr0)
}

open class cls0(){
    fun cls0fun(){

    }
}

open class cls1() : cls0() {
    fun cls1fun(){

    }
}

class cls2() : cls1(){
    fun cls2fun(){

    }
}

fun testArrFun0(arr1 : Array<out cls1>){      //읽기 전용
    //arr1[0] = fun1()
    arr1[0].cls1fun()
    arr1[0].cls0fun()
    val tmp : cls0 = arr1[0]
}
fun testArrFun1(arr1: Array<in cls1>){        //쓰기 전용.. 입력된 매개변수는 cls1의 상위 객체 가능.
    //상위 객체를 받을 수도 있는 in cls1을 사용했기 때문에 cls1클래스의 cls1fun()역시 사용할 수 없음.
    //arr1[0].cls1fun()
    arr1[0] = cls2()
}

fun testListFun0(list: MutableList<out cls1>){
    val tmp : cls0 = list.get(0)
}
fun testListFun1(list: MutableList<in cls1>){

}

fun <T: AutoCloseable> useAndClose(input: T) {
    input.close()  // OK
}