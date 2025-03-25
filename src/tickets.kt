
import java.io.File 
import java.io.InputStream 
import kotlin.math.pow
import kotlin.system.*

class Tickets(val N: Int)
{
    val SumsNumber: Int = N * 9 + 1
    var SumsArray = Array<Long>(SumsNumber) {i -> 0}

    fun GetSumNumber(number: Long): Int
    {
        var Sum: Int = 0
        var Number: Long = number
        var i: Int = N
            while (i > 0) {
                Sum += (Number % 10).toInt()
                Number /= 10
                i--
            }
        return Sum
    }

    fun GetFastHappyCount(): Long
    {
        val base: Double = 10.0
        var Count: Long = 0
        var MaxNumber: Long = base.pow(N).toLong()
        for (Number in 0..MaxNumber - 1)
            SumsArray[GetSumNumber(Number)]++

        for (i in 0..SumsNumber - 1)
            Count += SumsArray[i] * SumsArray[i]
    
        return Count
    }
}
 
fun main(args: Array<String>)
{

    println("Kotlin test")

    // long start = System.currentTimeMillis();
    val timeInMillis = measureTimeMillis {
        for(i in 0..9)
        {
            var inValue = 0
            var outValue: Long = 0
            var countValue: Long = 0
            val path: String = "1.Tickets/test."
            var fileNameIn: String = path + i + ".in"
            var fileNameoutValue: String = path + i + ".out"
            inValue = File(fileNameIn).bufferedReader().readLines()[0].toInt()
            outValue = File(fileNameoutValue).bufferedReader().readLines()[0].toLong()

            //println("${inValue} ${outValue}")
            var ticket = Tickets(inValue)
            countValue = ticket.GetFastHappyCount();
            var pass = ""
            when(countValue == outValue)
            {
                true -> pass = "pass"
                false -> pass = "fail"
            }
            println("kotlin fast count: ${inValue} ${countValue} ...... ${pass}");
        }
    }
    
    val timeInSec = timeInMillis / 1000

    println("Time: ${timeInSec} s")
}