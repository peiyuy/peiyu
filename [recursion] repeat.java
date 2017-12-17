我也不知道怎么样更efficient
是不是如果n 为偶数的话， 就...

public static String repeat(String s, int n) {
    if (n < 0) {
        throw new IllegalArgumentException();
    } else if (n == 0) {
        return "";
    } else {
        return s + repeat(s, n - 1);
    }
}
