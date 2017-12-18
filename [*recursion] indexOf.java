为什么我会想成 a.length() == 0， return -1呢？

public static int indexOf(String a, String b) {
    indexOf(a, b, 0);
}

private static int indexOf(String a, String b, int i) {
    if (a.length() < b.length()) {
        return -1; 
    } else if (a.substring(0, b.length()).equals(b)) {
        return i;
    } else {
        return indexOf(a.substring(1), b, i + 1);
    }
}
