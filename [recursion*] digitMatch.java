不是a == 0 || b == 0
而是 a只有一位 or b只有一位
而判断是不是只有一位 a / 10 == 0

public static int digitMatch(int a, int b) {
    alast = a % 10;
    blast = b % 10;
    if (a < 0 || b < 0) {
        throw new IllegalArgumentException();
    } else if (a / 10 == 0 || b / 10 == 0) {
        if (alast == blast) {
            return 1;
        } else {
            return 0;
        }
    } else {
        if (alast == blast) {
            return 1 + digitMatch(a / 10, b / 10);
        } else {
            return digitMatch(a / 10, b / 10);
        }
    }
}
