package com.example.demo.securty;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class KeyGeneratorUtils {
    public static KeyPair generateECKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256);
        return keyPairGenerator.generateKeyPair();
    }
}
