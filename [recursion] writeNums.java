throw syntax: throw <exception>;
eg. throw new IllegalArgumentException()

order is important, you first have the 1 being printed out
then you have the , sth, so the call should be at first

public static void writeNums(int n):
    if (n < 1) {
        throw new IllegalArgumentException();
    } else if (n == 1) {
        print("1");
    } else {
        writeNums(n - 1);
        print(", " + n);
    }
