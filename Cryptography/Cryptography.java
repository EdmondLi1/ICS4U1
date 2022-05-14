import java.util.Random;

public class Cryptography {

    /**
     * Formats the text in groups of five characters, removes all punctuations, and makes
     * all characters uppercase within the text. If the block isn't a multiple of five,
     * generate random characters to make it a multiple of five.
     *
     * @param text the text that will be formatted
     * @return the formatted text, no punctuation, all caps, spaced 5 blocks
     */
    public static String formatText(String text) {
        int currChar, charCounter = 0;
        String cleaned = "";

        Random random = new Random();

        // Iterate through the text per character
        for (int index = 0; index < text.length(); index++) {
            currChar = text.charAt(index);

            // If there are 5 characters, put a space and reset char counter
            if (charCounter % 5 == 0 && charCounter != 0) {
                cleaned += " ";
                charCounter = 0;
            }

            // If the current character is a lowercase, make it uppercase and append
            if (currChar >= 'a' && currChar <= 'z') {
                cleaned += (char) (currChar - 32);
                charCounter++;
            }

            // If the current character is uppercase, append
            else if (currChar >= 'A' && currChar <= 'Z') {
                cleaned += (char) currChar;
                charCounter++;
            }
        }

        // If the remaining char counter isn't 5
        // Randomly generated using a random letter (0 - 25) + 65 ('A') (make it to ascii convention) and append
        for (int i = 0; i < (5 - charCounter) % 5; i++) {
            cleaned += (char) (random.nextInt(26) + 'A');
        }
        return cleaned;
    }

    /**
     * Encrypts the plaintext with the given key by summing up the two values.
     * Writes the encrypted plaintext in the file name given.
     *
     * @param fileName file to write to
     * @param padKey the pad key used to encrypt the plaintext
     * @param plaintext the message to be encrypted
     */
    public static void encrypt(String fileName, String padKey, String plaintext) {
        String encrypted = "";
        int currentChar, keyChar, charSum;

        // For the length of the message, look at each character
        for (int index = 0; index < plaintext.length(); index++) {
            currentChar = plaintext.charAt(index);
            keyChar = padKey.charAt(index);

            // add the plaintext with key and subtract 64 (to make it between 65 and 90)
            charSum = currentChar + keyChar - 64;

            if (currentChar == ' '){
                encrypted += (char) currentChar;
            }
            // if the sum of the characters exceed 'Z', loop back to the beginning, 'A' and append
            else if (charSum > 'Z') {
                encrypted += (char) (charSum - 26);
            }
            // if within the alphabet, append
            else {
                encrypted += (char) charSum;
            }
        }
        FileHandling.writeFile(fileName, encrypted);
    }

    /**
     * Decrypts the ciphertext with the given key by subtracting the two values.
     * Writes the decrypted ciphertext in the file name given.
     *
     * @param fileName file to write to
     * @param key the key used to encrypt the ciphertext
     * @param ciphertext the encrypted message, to be decrypted
     */
    public static void decrypt(String fileName, String key, String ciphertext) {
        String decrypted = "";
        int currentChar, keyChar, charDiff;
        for (int index = 0; index < ciphertext.length(); index++) {
            currentChar = ciphertext.charAt(index);
            keyChar = key.charAt(index);

            // subtract encrypted from key and add 64 (to make it between 65 and 90)
            charDiff = currentChar - keyChar + 64;

            if (currentChar == ' ') {
                decrypted += (char) currentChar;
            }
            // if the difference of the characters exceed 'A', loop back to the end of the alphabet, 'Z' and append
            else if (charDiff < 'A') {
                decrypted += (char) (charDiff + 26);
            }
            // if within the alphabet, append
            else {
                decrypted += (char) charDiff;
            }
        }
        FileHandling.writeFile(fileName, decrypted);
    }
}
