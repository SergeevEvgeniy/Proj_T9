package T9_Proj;

public class Cut {

    private final char[] b = new char[]{',', '.', '-', ':', '!', '?'};

    public String Cut_Last(String str) {
        int ch = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == str.charAt(str.length() - 1)) {
                ch++;
            }
        }

        if (ch > 0) {
            return str.substring(0, str.length() - 1);
        } else {
            return str;
        }
    }

    public Object[] Cut_Digit(String str) {
        String word = "";
        Object[] res = new Object[2];
        int i = 0;
        while (i < b.length) {
            if (str.charAt(i) == ' ') {
                res[0] = word;
                word = "";
            } else {
                word += str.charAt(i);
            }
            i++;
        }
        res[1] = word;
        return res;

    }
}
