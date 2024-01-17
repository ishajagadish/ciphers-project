// Isha Jagadish
// 01/17/2024
// CSE 123 
// C0: Ciphers
// TA: Audrey Lin
// This class allows the user to encrypt a word using the CaesarShift cipher, where all the 
// encodable characters are shifted to the right by some provided shift amount. Then each character
// in the input word is encrypted like in the Substitution cipher. Extends the Cipher class.

public class CaesarShift extends Cipher {

    private int shift;

    // Constructs a new CaesarShift object with the given shift amount.
    // Throws an IllegalArgumentException if the shift amount is less than or equal to 0.
    public CaesarShift(int shift) {
        if(shift <= 0) {
            throw new IllegalArgumentException();
        }
        this.shift = shift;
    }

    // Applies the CaesarShift Cipher to the input, returning the result.
    // Takes in a String representing the word to be encrypted and returns a String
    // representing the encrypted word.
    public String encrypt(String input) {
        char[] arr = new char[input.length()];
        for(int i = 0; i<input.length(); i++) {
            char c = input.charAt(i);
            shift %= Cipher.TOTAL_CHARS;
            char o = (char)(Cipher.MIN_CHAR + (c + shift - Cipher.MIN_CHAR) % Cipher.TOTAL_CHARS);
            arr[i] = o;
        }
        String encrypted = String.valueOf(arr);
        return encrypted;
    }

    // Reverses the CaesarShift Cipher on the input, returning the result.
    // Takes in a String representing the encrypted word and returns a String
    // representing the decrypted word.
    public String decrypt(String input) {
        char[] arr = new char[input.length()];
        for(int i = 0; i<input.length(); i++) {
            char c = input.charAt(i);
            shift %= Cipher.TOTAL_CHARS;
            char o = (char)(Cipher.MIN_CHAR + 
            (c - shift - Cipher.MIN_CHAR + Cipher.TOTAL_CHARS) % Cipher.TOTAL_CHARS);
            arr[i] = o;
        }
        String encrypted = String.valueOf(arr);
        return encrypted;
    }

}