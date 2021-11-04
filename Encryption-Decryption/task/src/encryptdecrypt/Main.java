package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String s = "we found a treasure!";

        char[] sArr = s.toCharArray(); //convert to array
        for (int i = 0; i < sArr.length; i++) {
            int num = sArr[i];
            //if character is not an Alphabet
            if (num < 97 || num > 122) {
                continue;
            }

            //encryption (a→z, b→y, c→x, ... x→c, y →b, z→a)
            sArr[i] = (char) (97 + (122 - num));
        }

        //output result
        System.out.println(String.valueOf(sArr));
    }
}
