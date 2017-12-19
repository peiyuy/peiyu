public static boolean isElfish(String str) {
       Set<String> set = new HashSet<String>();
       set.add("e");
       set.add("l");
       set.add("f");
       return isElfish(str, set);
   }
private static boolean isElfish(String str, Set<String> set) {
    if (set.size() == 0) {
        return true;
    } else if (str.length() == 0) {
        return false;
    } else {
        set.remove(str.substring(0, 1));
        return isElfish(str.substring(1), set);
    }
 }

A word is considered elﬁsh if it contains the letters: e, l, and f in it, in any order. 
For example, we would say that the following words are elﬁsh: whiteleaf, tasteful, unfriendly, and waﬄes, 
because they each contain those letters. 

