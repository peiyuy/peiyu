注意这里不再是print, 而是返回一个整数

public static int multiplyEvens(int n) {
    if (n <= 0) {
        throw new IllegalArgumentException();
    } else if (n == 1) {
        return 2;
    } else {
        return 2 * n * multiplyEvens(n - 1);
    }
}
