package src.data_structure.recursion;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-09-26 15:29
 *  description : 递归打印单词的所有排列组合
 *  比如 abc 打印 abc acb bac bca cab cba
 */
public class AllWords {

    public static void main(String[] args) {
        new AllWordsPrinter("fakegame").printAllWords();
    }

    private static class AllWordsPrinter {

        private String mInput;
        private char[] mArrChar = new char[100];
        private int mSize;

        public AllWordsPrinter(String input) {
            mInput = input;
            mSize = mInput.length();
            for (int i = 0; i < mSize; i++) {
                mArrChar[i] = mInput.charAt(i);
            }
        }

        public void printAllWords() {
            doAnagram(mSize);
        }

        public void doAnagram(int newSize) {
            if (newSize == 1)
                return;
            for (int i = 0; i < newSize; i++) {
                doAnagram(newSize - 1);
                if (newSize == 2) {
                    display();
                }
                rotate(newSize);
            }
        }

        public void display() {
            for (int i = 0; i < mArrChar.length; i++) {
                System.out.print(mArrChar[i]);
            }
            System.out.println();
        }

        /**
         * 左移第position个的所有元素，把第position个的元素添加到最后一个
         *
         * @param newSize
         */
        private void rotate(int newSize) {
            int position = mSize - newSize;
            char temp = mArrChar[position];
            int i = 0;
            for (i = position + 1; i < mSize; i++) {
                mArrChar[i - 1] = mArrChar[i]; //左移
            }
            mArrChar[i - 1] = temp; // 添加到最后一个
        }

    }

}
