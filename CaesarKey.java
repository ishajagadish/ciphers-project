// Isha Jagadish
// 01/17/2024
// CSE 123 
// C0: Ciphers
// TA: Audrey Lin
// This class allows the user to encrypt a word using the CaesarKey cipher, where a key is placed
// at the front of the encodable range. Then each character in the input word is encrypted like in
// the Substitution cipher. Extends the Cipher class.

import java.util.*;

public class CaesarKey extends Cipher {
    private String key;

    // Constructs a new CaesarShift object with the given key.
    // Throws an IllegalArgumentException if the key is empty, it contains a character outside the
    // range of valid characters, or it contains any duplicate characters.
    public CaesarKey(String key) {
        if(key == "") {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i<key.length(); i++) {
            if((int) key.charAt(i) < Cipher.MIN_CHAR || (int) key.charAt(i) > Cipher.MAX_CHAR) {
                throw new IllegalArgumentException();
            }

            for(int j = i+1; j<key.length();j++) {
                if(key.charAt(i) == key.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.key=key;
    }

    // Applies the CaesarKey Cipher to the input, returning the result.
    // Takes in a String representing the word to be encrypted and returns a String
    // representing the encrypted word.
    public String encrypt(String input) {
        List<Character> encodableRange = new ArrayList<>();
        for(int i = 0; i < Cipher.TOTAL_CHARS; i++) {
            encodableRange.add((char) (i+Cipher.MIN_CHAR));
        }
        for(int j = 0; j<key.length(); j++) {
            char c = key.charAt(j);
            int index = encodableRange.indexOf(c);
            encodableRange.remove(index);
            encodableRange.add(j, c);
        }
        String shifter = "";
        for(char c : encodableRange){
            shifter = shifter + c; 
        }
        char[] arr = new char[input.length()];
        for(int i = 0; i<input.length(); i++) {
            char c = input.charAt(i);
            int charToInt = (int) c;
            int index = charToInt - Cipher.MIN_CHAR;
            arr[i] = shifter.charAt(index);
        }
        String encrypted = String.valueOf(arr);
        return encrypted;
    }

    // Reverses the CaesarKey Cipher on the input, returning the result.
    // Takes in a String representing the encrypted word and returns a String
    // representing the decrypted word.
    public String decrypt(String input) {
        List<Character> encodableRange = new ArrayList<>();
        for(int i = 0; i < Cipher.TOTAL_CHARS; i++) {
            encodableRange.add((char) (i+Cipher.MIN_CHAR));
        }
        for(int j = 0; j<key.length(); j++) {
            char c = key.charAt(j);
            int index = encodableRange.indexOf(c);
            encodableRange.remove(index);
            encodableRange.add(j, c);
        }
        String shifter = "";
        for(char c : encodableRange){
            shifter = shifter + c; 
        }
        char[] arr = new char[input.length()];
        for(int k = 0; k < input.length(); k++) {
            char c = input.charAt(k);
            int index = shifter.indexOf(c);
            arr[k] = (char) (Cipher.MIN_CHAR + index);
        }
        String encrypted = String.valueOf(arr);
        return encrypted;
    }
}