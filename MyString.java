public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String allUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newLowerCase = "";
        for (int i = 0; i < str.length(); i++){
            if (allUpper.indexOf(str.charAt(i)) != -1){
                newLowerCase = newLowerCase + (char) (str.charAt(i) + 32);
            } else {
                newLowerCase = newLowerCase + str.charAt(i);
            }
        }
        return newLowerCase;
    }


    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0){
            return true;
        }

        if (str2.length() > str1.length()){
            return false;
        }

        int str1Index = str1.indexOf(str2.charAt(0));
        if (str1Index == -1){
            return false;
        } 

        if ((str1.length() - str1Index) < str2.length()){
            return false;
        }

        for (int i = 0; i < str2.length(); i++){
            if (str2.charAt(i) != str1.charAt(str1Index + i)){
                return false;
            }
        }
        return true;
    }
}
