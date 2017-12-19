substring(1)是那种有至少两个character的string才能用的，
要不然没意义??

String a = "x";
String x = a.substring(1)不会出问题吗？比如indexOutOfRange这种

public static int countX(String str) {
    if (str.length() == 0) {
        return 0;
    } else if (str.charAt(0) == 'x') {
        return 1 + countX(str.substring(1));
    } else {
        return countX(str.substring(1));
    }
}
