package algorithm

/**
 * Author : Ray
 * Created At : 2019-05-06 10:30 PM
 * Email : ryu18356@gmail.com
 * Description : 整数翻转 123 -> 321，未考虑int溢出
 */
class ReverseInteger {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("number = -123423")
            println("reversed number = " + reverseInt(-123423))
        }

        private fun reverseInt(input: Int): Int {
            var div = input
            var result = 0;
            while (div != 0) {
                val mod = div % 10
                result = mod + result * 10
                div /= 10
            }
            return result
        }

    }
}
   