是那种 % 10， /10类型的题目

public static int count7(int n) {
    if (n == 0) {
        return 0;
    } else if (n % 10 == 7) {
        return 1 + count7(n / 10);
    } else {
        return count7(n / 10);
    }
}
