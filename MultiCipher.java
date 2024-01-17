// Isha Jagadish
// 01/17/2024
// CSE 123 
// C0: Ciphers
// TA: Audrey Lin
// This class allows the user to encrypt a word using multiple Ciphers. The output of each
// previous cipher is used as the input to the next. Extends the Cipher class.

import java.util.List;
import java.util.*;

public class MultiCipher extends Cipher {
    private List<Cipher> ciphers;

    // Creates a new MultiCipher object with the given ciphers.
    // If the given ciphers list is null, throws an IllegalArgumentException.
    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException(); 
        }
        this.ciphers = new ArrayList<>();
        this.ciphers.addAll(ciphers);
    }

    // Applies all the ciphers to the input, returning the final result.
    // Takes in a String representing the word to be encrypted and returns a String
    // representing the encrypted word.
    public String encrypt(String input) {  
        String temp = input;
        for(int i = 0; i < ciphers.size(); i++) {
            Cipher c = ciphers.get(i);
            temp = c.encrypt(temp);
        }
        return temp;
    }

    // Reverses all the ciphers on the input, returning the final result.
    // Takes in a String representing the encrypted and returns a String
    // representing the decrypted word.
    public String decrypt(String input) {
        String temp = input;
        for(int i = ciphers.size()-1; i >= 0; i--) {
            Cipher c = ciphers.get(i);
            temp = c.decrypt(temp);
        }
        return temp;
    }  
}