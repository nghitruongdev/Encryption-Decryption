package encryptdecrypt;

public interface EncryptionMethod {
    String encrypt(String message);

    String decrypt(String message);

    enum EncryptionType {
        UNICODE, SHIFT
    }

    class UnicodeEncryption implements EncryptionMethod {
        private int key;

        public UnicodeEncryption(int key) {
            this.key = key;
        }

        @Override
        public String encrypt(String message) {
            char[] sArr = message.toCharArray(); //convert to array
            for (int i = 0; i < sArr.length; i++) {
                int num = sArr[i];
                sArr[i] = (char) (num + key);
            }
            return String.valueOf(sArr);
        }


        @Override
        public String decrypt(String message) {

            char[] sArr = message.toCharArray(); //convert to array
            for (int i = 0; i < sArr.length; i++) {
                int num = sArr[i];
                sArr[i] = (char) (num - key);
            }
            return String.valueOf(sArr);
        }
    }

    class ShiftingEncryption implements EncryptionMethod {
        private int key;

        public ShiftingEncryption(int key) {
            this.key = key;
        }

        @Override
        public String encrypt(String message) {
            char[] sArr = message.toCharArray(); //convert to array
            for (int i = 0; i < sArr.length; i++) {
                int num = sArr[i];
                int newNum = num + key;

                if (num > 64 && num < 91) {
                    sArr[i] = newNum > 90 ? (char) (64 + (newNum - 90)) : (char) newNum;
                } else if (num > 96 && num < 123) {
                    sArr[i] = newNum > 122 ? (char) (96 + (newNum - 122)) : (char) newNum;
                }
            }
            return String.valueOf(sArr);
        }

        @Override
        public String decrypt(String message) {
            char[] sArr = message.toCharArray(); //convert to array
            for (int i = 0; i < sArr.length; i++) {
                int num = sArr[i];
                int newNum = num - key;

                if (num > 64 && num < 91) {
                    sArr[i] = newNum < 65 ? (char) (91 - (65 - newNum)) : (char) newNum;
                } else if (num > 96 && num < 123) {
                    sArr[i] = newNum < 97 ? (char) (123 - (97 - newNum)) : (char) newNum;
                }
            }
            return String.valueOf(sArr);
        }
    }

}
