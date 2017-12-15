recursive case奇偶都是一种对待

public static void writeChars(int n) {
    if (n < 1) {
       throw new IllegalArgumentException();
    } else if (n == 1) {
       print("*");
    } else if (n == 2) {
       print("**")
    } else {
       print("<");
       writeChars(n - 2);
       print(">");
    }
}
