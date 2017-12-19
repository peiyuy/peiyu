changePi和我以前做的一道题很像，
我这次最大的经验是 我之前想把str.length() == 0作为
一类base类，后来又加了一个str.length() == 1的base类
发现他俩可以合并为一类。这告诉我base类不要太过死板，
要依照题目分析

public String changePi(String str) {
  if (str.length() < 2) {
    return str;
  } else if (str.substring(0, 2).equals("pi")) {
    return "3.14" + changePi(str.substring(2));
  } else {
    return str.substring(0, 1) + changePi(str.substring(1));
  }
}
