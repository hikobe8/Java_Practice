package data_structure.stack;

public class BracketChecker {

    private String mInput;

    public BracketChecker(String input) {
        mInput = input;
    }

    public void check() {
        BracketStackX stackX = new BracketStackX(20);
        for (int i = 0; i < mInput.length(); i ++) {
            char c = mInput.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stackX.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stackX.isEmpty()) {
                        char pop = stackX.pop();
                        if (pop != '{' && c == '}'
                                || pop != '[' && c == ']'
                                || pop != '(' && c == ')') {
                            System.out.println("Error match '" + c + "' at index " + i);
                        }
                    } else {
                        System.out.println("Error match '" + c + "' at index " + i);
                    }
                    break;
            }
        }
        if (!stackX.isEmpty()) {
            System.out.println("error match right bracket!");
        }
    }

}
