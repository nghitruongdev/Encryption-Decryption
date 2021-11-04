package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int key = sc.nextInt();

        char[] sArr = s.toCharArray(); //convert to array
        for (int i = 0; i < sArr.length; i++) {
            int num = sArr[i];
            //if character is not an Alphabet
            if (num < 97 || num > 122) {
                continue;
            }

            //encryption by shifting letter
            int newNum = num + key;
            sArr[i] = newNum > 122 ? (char) (newNum - 122 + 96) : (char) newNum;
        }

        //output result
        System.out.println(String.valueOf(sArr));
    }
}
