package desafio.github.criptografia.components;

import jakarta.persistence.AttributeConverter;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class UserCrypto implements AttributeConverter<String, String> {

    @Autowired
    private Environment env;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        String secretKey = env.getProperty("secret.key");
        if(attribute == null) {
            return null;
        }
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] digest = md.digest((secretKey + attribute).getBytes());
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        String secretKey = env.getProperty("secret.key");
        if (dbData == null) {
            return null;
        }
        try {
            byte[] decoded = Base64.getDecoder().decode(dbData);
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] digest = md.digest((secretKey + new String(decoded)).getBytes());
            return new String(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
