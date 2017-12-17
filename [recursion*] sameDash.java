1) 所以""是字符串，俗称String, ‘’是char?
2) 关于if, else if如果return type为boolean的注意
3） 我是这样写的 a.substring(1, a.length()) 因为我知道i, j j为exclusive
但是有更简便的写法 a.substring(1)
4) 分析我的code 中(afirst == '-' && bfirst != '-' && bfirst == ‘-’ && afirst != '-')的运算顺序
5）分析源代码 https://courses.cs.washington.edu/courses/cse143/17sp/exams/midterm/mid-key.txt

public static boolean sameDash(String a, String b) {
    if (a == null || b == null || a.length() != b.length()) {
        throw new IllegalArgumentException();
    } else if (a.length() == 0) {
        return true;
    } else {
        char afirst = a.charAt(0);
        char bfirst = b.charAt(0);
        if (afirst == '-' && bfirst != '-' || bfirst == '-' && afirst != '-') {
            return false;
        } else {
            return true;
        }
    }
}
