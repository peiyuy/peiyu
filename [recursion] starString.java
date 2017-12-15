throw syntax: throw <exception>; 
eg: throw new IllegalArgumentException;
string concatonation

flow chart:
2^4 = 2 * 2^3
2^1 = 2 * 2^0  return starString(n - 1) + starString(n - 1)

0 = 1   return "*"
<0 = IAE

public static String starString(int n):
   if (n < 0) {
      throw new IllegalArgumentException;
   } else if (n == 0) {
      return "*";
   } else {
      return starString(n - 1) + starString(n - 1);
   }
   
