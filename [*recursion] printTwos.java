这道题也是一道非常好的题目

public static void printTwos(int n) {
    if (n < 1) {
        throw new IllegalArgumentException();
    } else if (n % 2 == 1) {
        print(n);
    } else if (n % 4 == 0) {
        print("2 * ")
        printTwos(n / 4);
        print(" * 2");
    } else {
        print("2 * ");
        printTwos(n / 2);
    }
}
