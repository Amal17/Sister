package Modul11;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author root
 */
public class Crypto {
    private static Cipher cipher = null;
    
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, NoSuchPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        keyGenerator.init(168);
        SecretKey secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("DESede");
        
        String plainText = "Kriptografi menggunakan Java Cryptography Extension";
        System.out.println("Plain text Before Encryption\t: "+plainText);
        
        byte[] plainTextByte = plainText.getBytes("UTF8");
        byte[] encryptedByte = encrypt(plainTextByte, secretKey);
        
        String encryptedText = new String (encryptedByte, "UTF8");
        System.out.println("Encrypted Text After Encryption\t: "+encryptedText);
        
        byte[] decryptedBytes = decrypt(encryptedByte, secretKey);
        String decryptedText = new String(decryptedBytes, "UTF8");
        System.out.println("Decrypted Text After Decryption\t: "+decryptedText);
    }
    
    static byte[] encrypt (byte[] plainTextByte, SecretKey secretKey) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        return encryptedByte;
    }
    
    static byte[] decrypt (byte[] encryptedBytes, SecretKey secredKey) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        cipher.init(Cipher.DECRYPT_MODE, secredKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return decryptedBytes;
    }
}
