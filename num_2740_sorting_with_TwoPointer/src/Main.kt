import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var N:Int = br.readLine().toInt()
    var arr = ArrayList<Int>()
    val st = StringTokenizer(br.readLine())

    while(st.hasMoreTokens()){
        arr.add(st.nextToken().toInt())
    }
    arr.sort()

    var savedIndex = SavedIndex()
    findIndex(savedIndex, 0, arr.size-1, arr)

    bw.write(arr[savedIndex.head].toString() + " " + arr[savedIndex.tail])
    bw.flush()
    bw.close()
    br.close()
}

class SavedIndex{
    var head:Int = 0
    var tail:Int = 0
    var V:Int = 0
}

fun findIndex(savedIndex: SavedIndex, head:Int, tail:Int, arr:ArrayList<Int>){
    savedIndex.head = head
    savedIndex.tail = tail
    savedIndex.V = arr[savedIndex.head] + arr[savedIndex.tail]
    var tmp_V : Int = arr[savedIndex.head] + arr[savedIndex.tail]
    var tmp_head : Int = head
    var tmp_tail : Int = tail

    while (tmp_head+1 < tmp_tail){
        if (tmp_V > 0){
            tmp_tail -= 1
            var ttmp_V = arr[tmp_head] + arr[tmp_tail]
            if (Math.abs(tmp_V) > Math.abs(ttmp_V)){
                tmp_V = ttmp_V
                if (tmp_head+1 == tmp_tail){
                    savedIndex.head = tmp_head
                    savedIndex.tail = tmp_tail
                    savedIndex.V = tmp_V
                }
            }
            else if (Math.abs(tmp_V) < Math.abs(ttmp_V)){
                tmp_tail += 1
                if (Math.abs(savedIndex.V) > Math.abs(tmp_V)){
                    savedIndex.head = tmp_head
                    savedIndex.tail = tmp_tail
                    savedIndex.V = tmp_V
                }
                tmp_head += 1
                tmp_tail -= 1
                tmp_V = arr[tmp_head] + arr[tmp_tail]
            }
        }
        else if (tmp_V < 0){
            tmp_head += 1
            var ttmp_V = arr[tmp_head] + arr[tmp_tail]
            if (Math.abs(tmp_V) > Math.abs(ttmp_V)){
                tmp_V = ttmp_V
                if (tmp_head+1 == tmp_tail){
                    savedIndex.head = tmp_head
                    savedIndex.tail = tmp_tail
                    savedIndex.V = tmp_V
                }
            }
            else if (Math.abs(tmp_V) < Math.abs(ttmp_V)){
                tmp_head -= 1
                if (Math.abs(savedIndex.V) > Math.abs(tmp_V)){
                    savedIndex.head = tmp_head
                    savedIndex.tail = tmp_tail
                    savedIndex.V = tmp_V
                }
                tmp_head += 1
                tmp_tail -= 1
                tmp_V = arr[tmp_head] + arr[tmp_tail]
            }
        }
        else {
            savedIndex.head = tmp_head
            savedIndex.tail = tmp_tail
            savedIndex.V = tmp_V
            break
        }
    }
}