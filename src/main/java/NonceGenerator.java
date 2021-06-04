import java.util.Base64;
import java.util.UUID;

public class NonceGenerator {

    public static String generateNonce() {
        final UUID uniqueKey = UUID.randomUUID();
        String uniqueId = String.valueOf((int)(System.currentTimeMillis() & 0xFFFFFFFL)) + uniqueKey.toString().substring(1, 20);
        uniqueId = uniqueId.replaceAll("-", "");
        return uniqueId;
    }

    public static void main(String[] args) {
//        System.out.println(generateNonce());
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        String str = encoder.encodeToString("1234".getBytes());
//        str = "MTc5MA==";
        System.out.println(str);
        String decodedStr = new String(decoder.decode(str));
        System.out.println(decodedStr);
    }
}
