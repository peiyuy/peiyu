这道题很tricky
1)print(" " + （n/2+1）)
如果不加括号就会错的
2）我对 {}还是容易和python的：弄混
3）有两个recursive case就该有两个base case
4）奇数偶数

public static void writeSequence(int n) {
    if (n < 1) {
        throw new IllegalArgumentException();
    } else if (n == 1) {
        print("1");
    } else if (n == 2) {
        print("1 1")
    } else if (n % 2 == 1) {
        print(n / 2 + 1 + " ");
        再复习一下java的当有运算和字符串的顺序
        writeSequence(n - 2);
        print(" " + (n / 2 + 1)); 
    } else {
        print(n / 2 + " ");
        writeSequence(n - 2);
        print（" " + n / 2);
    }
    
}
    
