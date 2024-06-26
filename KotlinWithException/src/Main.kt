import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.Buffer

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*자바에 있는 클래스 이용해서 확인해 본것*/
    //val printer = JavaFilePrinter()
    //printer.readFile()

    val printer = FilePrinter()
    printer.readFile()
}

fun parseIntOrThrow(str: String): Int{
    try{
        /*코틀린에서는 기본 type끼리는 toType()을 통해 변환*/
        return str.toInt()
    } catch(e : NumberFormatException){
        throw IllegalArgumentException("주어진${str}은 숫자가 아닙니다.")
    }
}

fun parseIntOrThrow2(str: String): Int?{
    /*if-else와 동일하게 try-catch도 하나의 Expression으로 간주됨.*/
    return try{
        str.toInt()
    } catch(e: NumberFormatException){
        null
    } finally {         //finally는 try - catch와 관계없이 항상 실행되는 구문을 담는다. - 자바와 동일
        println("!")
    }
}

class FilePrinter{
    /*자바와는 달리, 버퍼리더를 사용할 때 throws IOException을 안해줘도 됨.
    * CheckedException, UnCheckedException관련해서 코틀린은 다 UnCheckedException이라
    * 그런 것이라는데, 이 개념은 처음 듣는거라 잘 모르겠음.*/
    fun readFile(){
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    fun readFile(path: String){
        /*자바의 코드로 번역하면
        * try(BufferedReader reader = new BufferedReader(new FileReader(path))){
        *   System.out.println(reader.readLine());
        * }(try문이 끝나면 reader를 자동으로 닫아줌.) 와 동일하다.
        * 코틀린에서는 이러한 try with resources 방식이 사라졌다.*/
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}