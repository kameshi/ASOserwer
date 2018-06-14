package ASOserver.common;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by user on 2018-06-14.
 */
public class HashUtils {

    public static String generateHash(String password, int logRounds) throws Exception {
        return BCrypt.hashpw(password, BCrypt.gensalt(logRounds));
    }

    public static boolean verifyPassword(String password, String hashPassword) throws Exception {
        return BCrypt.checkpw(password, hashPassword);
    }
}
