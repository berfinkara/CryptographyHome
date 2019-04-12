package Cipher;

import staticClasses.CryptoTools;
import staticClasses.USAlphabet;

/**
 * Created by koryOzyurt on 9/30/2017.
 */
public class ShiftCipher {
    private String message = null;
    private int key;

    private int bestGuess;
    private String decryptedMessage;

    public ShiftCipher(String message, int key) {
        this.message = message.toUpperCase();
        this.key = key;
    }

    public ShiftCipher(){}

    /**
     * encryp by this.key
     * @return
     */
    public String encryptMessage(){
        String encryptedMessage ="";
        for(char c:message.toCharArray()){
            int e = USAlphabet.getCharacterNumber(c);
            e = (e + key) % USAlphabet.numberOfCharacter;
            encryptedMessage += USAlphabet.getCharacter(e);
        }
        return encryptedMessage;
    }

    /**
     *
     * @param encryptedMessage
     * @param k
     * @return
     */
    public String decryptMessage(String encryptedMessage, int k){
        String decryptedMessage = "";
        char[] characters = encryptedMessage.toCharArray();
        for(char c: characters){
            int d = USAlphabet.getCharacterNumber(c);
            d = d-k;
            d = (d = d % USAlphabet.numberOfCharacter) < 0 ? d + USAlphabet.numberOfCharacter : d;
            decryptedMessage += USAlphabet.getCharacter(d);

        }
        return decryptedMessage;
    }

    /**
     *
     * @param text
     * try to all of the possible key then return most meaningful text at this.decryptedMessage
     */
    public void cracker(String text){
        String tempDecryptedMessage = "";
        for(int k =0; k <USAlphabet.numberOfCharacter;k++){
            tempDecryptedMessage = this.decryptMessage(text, k);
            int tempFrequency = CryptoTools.optimumFrequencyTest(tempDecryptedMessage);
            if(tempFrequency > this.bestGuess){
                this.decryptedMessage = tempDecryptedMessage;
                this.bestGuess = tempFrequency;
                this.key = k;
            }
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getKey() {
        return key;
    }

    public String getDecryptedMessage() {
        return decryptedMessage;
    }

    public int getBestGuess() {
        return bestGuess;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
