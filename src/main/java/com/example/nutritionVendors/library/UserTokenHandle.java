package com.example.nutritionVendors.library;

import java.nio.charset.Charset;
import java.util.Random;

public class UserTokenHandle {

    public String generateUserToken(Integer id) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder builder = new StringBuilder(50);

        for (int i = 0; i < 50; i++) {
            builder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        return builder.toString() + id;
    }
}
