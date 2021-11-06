package encryptdecrypt;

public class MyEncryptor {

    private EncryptionMethod method;
    public MyEncryptor(EncryptionMethod method) {
        this.method = method;
    }

    public String invoke(String type, String message) {
        switch (type) {
            case "enc":
                return method.encrypt(message);
            case "dec":
                return method.decrypt(message);
            default:
                return "";
        }
    }


}
