// Isha Jagadish
// 01/17/2024
// CSE 123 
// C0: Ciphers
// TA: Audrey Lin
// This class allows the user to encrypt a word using the Substitution cipher, where each character
// in the given input word is matched with the corresponding character in the shifter string.
// Extends the Cipher class.

public class Substitution extends Cipher {

    private String shifter;
    
    // Constructs a new Substiution object with an empty shifter string
    public Substitution() {
        shifter = "";
    }

    // Constructs a new Substitution object with the given shifter string.
    // Throws an IllegalArgumentException if the length of shifter string is not equal to the
    // length of the encodable range, if shifter contains duplicate chars, or any individual
    // character falls outside the encodable range.
    public Substitution(String shifter) {
        if(shifter.length() != Cipher.TOTAL_CHARS) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i<shifter.length(); i++) {
            if((int) shifter.charAt(i) < Cipher.MIN_CHAR || 
            (int) shifter.charAt(i) > Cipher.MAX_CHAR) {
                throw new IllegalArgumentException();
            }
            for(int j = i+1; j<shifter.length();j++) {
                if(shifter.charAt(i) == shifter.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.shifter = shifter;
    }

    // Updates the shifter to the given shifter for the current Substiution object
    // Throws an IllegalArgumentException if the length of shifter string is not equal to the
    // length of the encodable range, if shifter contains duplicate chars, or any individual
    // character falls outside the encodable range.
    public void setShifter(String shifter) {
        if(shifter.length() != Cipher.TOTAL_CHARS) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i<shifter.length(); i++) {
            if((int) shifter.charAt(i) < Cipher.MIN_CHAR || 
            (int) shifter.charAt(i) > Cipher.MAX_CHAR) {
                throw new IllegalArgumentException();
            }
            for(int j = i+1; j<shifter.length();j++) {
                if(shifter.charAt(i) == shifter.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.shifter = shifter;
    }

    // Applies the Substitution Cipher to the input, returning the result.
    // Throws an IllegalStateException if the shifter is null or empty.
    // Takes in a String representing the word to be encrypted and returns a String
    // representing the encrypted word.
    public String encrypt(String input) {  
        if(this.shifter == null || this.shifter == "") {
            throw new IllegalStateException();
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

    // Reverses the Substitution Cipher on the input, returning the result.
    // Throws an IllegalStateException if the shifter is null or empty.
    // Takes in a String representing the encrypted word and returns a String
    // representing the decrypted word.
    public String decrypt(String input) {
        if(this.shifter == null || this.shifter == "") {
            throw new IllegalStateException();
        }
        char[] arr = new char[input.length()];
        for(int i = 0; i<input.length(); i++) {
            char c = input.charAt(i);
            int index = shifter.indexOf(c);
            int charInt = (int) (index+Cipher.MIN_CHAR);
            arr[i] = (char) charInt;
        }
        String decrypted = String.valueOf(arr);
        return decrypted; 
    }
}