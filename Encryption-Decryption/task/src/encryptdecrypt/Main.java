package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String op = sc.nextLine();
        String s = sc.nextLine();
        int key = sc.nextInt();

        char[] sArr = s.toCharArray(); //convert to array
        if ("enc".equalsIgnoreCase(op)) {
            for (int i = 0; i < sArr.length; i++) {
                int num = sArr[i];
                //encryption by shifting letter
                sArr[i] = (char) (num + key);
            }

        } else if ("dec".equalsIgnoreCase(op)) {
            for (int i = 0; i < sArr.length; i++) {
                int num = sArr[i];
                //decryption by shifting letter
                sArr[i] = (char) (num - key);
            }
        }

        //output result
        System.out.println(String.valueOf(sArr));
    }
}
