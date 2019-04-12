import Cipher.AffineCipher;
import Cipher.ShiftCipher;
import Cipher.VigenereCipher;

/**
 * Created by koryOzyurt on 10/8/2017.
 */
public class Cracker {
    private String cipherText;
    private String decryptedText;
    private String key;
    private String type;

    /**
     * try all of the cipher types and return the text which has that higher frequency
     * @param text
     */
    public Cracker(String text) {
        this.cipherText = text;
        ShiftCipher shiftCipher = new ShiftCipher();
        AffineCipher affineCipher = new AffineCipher();
        VigenereCipher vigenereCipher = new VigenereCipher();

        shiftCipher.cracker(cipherText);
        affineCipher.affineCipherCracker(cipherText);
        vigenereCipher.vigenereCipherCracker(cipherText);

        if(shiftCipher.getBestGuess() > affineCipher.getBestGuess() && shiftCipher.getBestGuess() > vigenereCipher.getBestGuess()){
            this.decryptedText = shiftCipher.getDecryptedMessage();
            this.key = String.valueOf(shiftCipher.getKey());
            this.type = "ShiftCipher";
        }else if(affineCipher.getBestGuess() > shiftCipher.getBestGuess() && affineCipher.getBestGuess() > vigenereCipher.getBestGuess()){
            this.decryptedText = affineCipher.getDecryptedMessage();
            this.key = "key a is: " + affineCipher.getKeyA() + " key b is: " + affineCipher.getKeyB();
            this.type = "AffineCipher";
        }else{
            //else Vigenere
            this.decryptedText = vigenereCipher.getDecryptedText();
            this.key = vigenereCipher.getKey();
            this.type = "VigenereCipher";
        }

    }

    public String getDecryptedText() {
        return decryptedText;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }
}
