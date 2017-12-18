这里因为大小写问题不能用char方法，一定要用String方法
即，如果想用equals(), equalsIgnoreCase(), 一定用substring(i, j)的方法来
得到afirst, blast

1）判断有四种情况
2）用length()，做最初的筛查（hint:在什么情况下，都不用再继续查了，第一眼就判定false?)
3) 有了2的基础下，什么情况下会提供true?
4）什么情况下，不需要再继续检查下去了， 可以判定false?
equalsIgnoreCase()
5) 用substring缩小范围

public static boolean isReverse(String a, String b) {
    if (a.length() != b.length()) {
        return false;
    } else if (a.length() == 0) {
        return true;
    } else if (!a.substring(0, 1).equalsIgnoreCase(b.substring(b.length() - 1))) {
        return false;
    } else {
        return isReverse(a.substring(1), b.substring(0, b.length() - 1);
    }
}
