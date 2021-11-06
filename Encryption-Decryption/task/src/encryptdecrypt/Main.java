package encryptdecrypt;


import java.io.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String mode = "";
        StringBuilder data = new StringBuilder();
        int key = 0;

        String in = "";
        String out = "";

        String alg = "shift";
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-alg":
                    alg = args[i + 1];
                    break;
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = Optional.ofNullable(args[i + 1]).map(StringBuilder::new).orElse(null);
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
            }
        }
        assert data != null;
        if ((data.length() == 0 && !in.isEmpty())) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(in)))) {
                while (reader.ready()) {
                    data.append(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PrintStream writer = System.out;
        if (!out.isEmpty()) {
            try {
                writer = new PrintStream(new FileOutputStream(out));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        MyEncryptor encryptor = new MyEncryptor(MyFactory.getMethod(alg, key));
        //output result
        writer.println(encryptor.invoke(mode, data.toString()));
        writer.close();
    }
}
