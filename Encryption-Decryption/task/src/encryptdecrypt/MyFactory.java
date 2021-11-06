package encryptdecrypt;

public class MyFactory {
    public static EncryptionMethod getMethod(String type, int key) {
        switch (EncryptionMethod.EncryptionType.valueOf(type.toUpperCase())) {
            case UNICODE:
                return new EncryptionMethod.UnicodeEncryption(key);
            case SHIFT:
                return new EncryptionMethod.ShiftingEncryption(key);
            default:
                return null;
        }
    }
}
