package questions.classAndObject

import scala.collection.mutable

/**
  * Created by huangzhibo on 20/02/2017.
  */
class ChecksumAccumulator {
    private var sum = 0

    // 过程
    // 等价于：
    // def add(b: Byte): Unit = sum += b
    def add(b: Byte) {
        sum += b
    }

    def checksum(): Int = ~(sum & 0xFF) + 1

    // 位运算：
    //     &    按位与运算符
    //     |    按位或运算符
    //     ^    按位异或运算符
    //     ~    按位取反运算符
    //     <<   左移动运算符
    //     >>   右移动运算符
    //     >>>  无符号右移

    // 补码  反码
}

object ChecksumAccumulator {
    private val cache = mutable.Map[String, Int]()

    def calculate(s: String): Int =
        if (cache.contains(s))
            cache(s)
        else {
            val acc = new ChecksumAccumulator
            for (c <- s)
                acc.add(c.toByte)
            val cs = acc.checksum()
            cache += (s -> cs)
            cs
        }

    def printCache: Unit = {
        cache.foreach(println)
    }
}

object Test extends App {
    val str = "test"
    ChecksumAccumulator.calculate(str)
    ChecksumAccumulator.printCache
}