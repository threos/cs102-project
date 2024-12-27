package co.xreos.lms.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Crypto {
    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    public static String hash(String password, String salt) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), decoder.decode(salt), 65536, 128);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            return encoder.encodeToString(factory.generateSecret(spec).getEncoded());
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateSalt() {
        byte[] salt = new byte[16];
        new java.security.SecureRandom().nextBytes(salt);
        return encoder.encodeToString(salt);
    }
}
