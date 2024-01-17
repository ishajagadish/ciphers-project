// Isha Jagadish
// 01/17/2024
// CSE 123 
// C0: Ciphers
// TA: Audrey Lin
// This class allows the user to encrypt a word using the Concealment cipher, where the original
// message is mixed with some number of random junk characters (specified by user). Extends the
// Cipher class.

import java.util.Random;

public class Concealment extends Cipher {
    private int filler;

    // Constructs a new Concealment object with the given filler value.
    // If the filler value is less than or equal to 0, throws an IllegalArgumentException.
    public Concealment(int filler) {
        if(filler <= 0) {
            throw new IllegalArgumentException();
        }
        this.filler = filler;
    }

    // Applies the Concealment Cipher to the input, returning the result.
    // Takes in a String representing the word to be encrypted and returns a String
    // representing the encrypted word.
    public String encrypt(String input) {
        char[] arr = new char[input.length()*(filler+1)];
        for(int i = 0; i<input.length(); i++) {
            for(int j = 0; j<filler; j++) {
                Random r = new Random();
                arr[(i*(filler+1)+j)] = 
                (char) (r.nextInt(Cipher.MAX_CHAR-Cipher.MIN_CHAR) + Cipher.MIN_CHAR);
            }
            arr[(i+1)*(filler+1)-1] = input.charAt(i); 
        }
        String encrypted = String.valueOf(arr);
        return encrypted;
    }

    // Reverses the Concealment Cipher on the input, returning the result.
    // Takes in a String representing the encrypted word and returns a String
    // representing the decrypted word.
    public String decrypt(String input) {
        String encrypted = "";
        for(int i = filler; i<input.length(); i+=(filler+1)) {
            encrypted += input.charAt(i);
        }
        return encrypted;
    }

}