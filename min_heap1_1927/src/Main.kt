//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()

    var arr = ArrayList<Int>()
    var result = ArrayList<Int>()
    var test = Array(3) { IntArray(2) }

    for (i in 1 .. N){
        var tmp = br.readLine().toInt()
        if (tmp != 0){
            push(arr, tmp)
        }
        else {
            if (arr.size == 0){
                result.add(0)
            }
            else {
                result.add(pop(arr))
            }
        }
    }

    for (i in 0 .. result.size-1){
        bw.write(result[i].toString() + "\n")
    }
    bw.flush()
    bw.close()
    br.close()
}

fun push(arr: ArrayList<Int>, n : Int){

    arr.add(n)

    var index = arr.size - 1
    var parent_index : Int
    var tmp : Int
    var tmp_p : Int

    while (index != 0){
        parent_index = index/2
        if (arr[parent_index] > arr[index]){
            tmp = arr[index]
            tmp_p = arr[parent_index]
            arr.remove(index)
            arr.add(index, tmp_p)
            arr.remove(parent_index)
            arr.add(parent_index, tmp)
        }
        else {
            break;
        }
        index /= 2
    }
}

fun pop(arr: ArrayList<Int>) : Int{
    val result : Int = arr[0]
    var tmp_p : Int
    var tmp : Int

    arr.removeFirst()
    arr.add(arr[arr.size-1])
    arr.removeLast()

    var index_p = 0
    var index : Int

    if (arr[index_p] > arr[1]){
        tmp_p = arr[index_p]
        tmp = arr[1]
        arr.remove(index_p)
        arr.add(index_p, tmp)
        arr.remove(1)
        arr.add(1, tmp_p)
        index_p = 1
        index = index_p * 2
    }
    else if (arr[index_p] > arr[2]){
        tmp_p = arr[index_p]
        tmp = arr[2]
        arr.remove(index_p)
        arr.add(index_p, tmp)
        arr.remove(2)
        arr.add(2, tmp_p)
        index_p = 2
        index = index_p * 2
    }
    else{
        return result
    }

    while (index <= arr.size-1){
        if (arr[index_p] > arr[index]){
            tmp_p = arr[index_p]
            tmp = arr[index]
            arr.remove(index_p)
            arr.add(index_p, tmp)
            arr.remove(index)
            arr.add(index, tmp_p)
            index_p = index
            index = index_p * 2
        }
        else if (index + 1 <= arr.size-1){
            if (arr[index_p] > arr[index + 1]){
                tmp_p = arr[index_p]
                tmp = arr[index+1]
                arr.remove(index_p)
                arr.add(index_p, tmp)
                arr.remove(index+1)
                arr.add(index+1, tmp_p)
                index_p = index+1
                index = index_p * 2
            }
            else {
                break
            }
        }
        else {
            break
        }
    }

    return result
}