package com.tso7121.telemedicine.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class AuthHandler {

    private AuthHandler() {}

    public static String hashPassword(String password) {
        // Generate a salt with 10 rounds of hashing
        String hashedPassword = BCrypt.withDefaults().hashToString(10, password.toCharArray());

        return hashedPassword;
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        // Check that the password matches the hashed password
        boolean matches = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;

        return matches;
    }
}
