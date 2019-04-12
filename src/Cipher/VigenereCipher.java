package Cipher;

import staticClasses.CryptoTools;
import staticClasses.USAlphabet;

import java.util.ArrayList;

public class VigenereCipher {
    private String message;
    private String key;

    private String decryptedText;
    private int bestGuess;

    public VigenereCipher(String message, String key) {
        this.message = message.toUpperCase();
        this.key = key.toUpperCase();
    }

    /**
     * Create empty to use cracker
     */
    public VigenereCipher(){}

    public String encryptMessage(){
        String encryptedMessage = "";
        int index = 0;
        for(char c:message.toCharArray()){
            if(index == key.length()){
                index = 0;
            }
            c = USAlphabet.getCharacter((USAlphabet.getCharacterNumber(c) + USAlphabet.getCharacterNumber(key.charAt(index)))%USAlphabet.numberOfCharacter);
            encryptedMessage += c;
            index++;
        }
        return encryptedMessage;
    }

    public String decryptMessage(String cipherText, String key){
        cipherText = cipherText.toUpperCase(); key = key.toUpperCase();
        String decryptedMessage = "";
        int index = 0;
        for(char c:cipherText.toCharArray()){
            if(index == key.length()){
                index = 0;
            }
            int d = USAlphabet.getCharacterNumber(c) - USAlphabet.getCharacterNumber(key.charAt(index));
            d = (d = d % USAlphabet.numberOfCharacter) < 0 ? d + USAlphabet.numberOfCharacter : d;
            decryptedMessage += USAlphabet.getCharacter(d);
            index++;
        }
        return decryptedMessage;
    }

    public void vigenereCipherCracker(String text){
        text = text.toUpperCase();
        //Send two times because of the be sure
        int lengthOfKey = findLenghtOfKey(text);
        String[] results = this.crackerProcess(text, lengthOfKey);
        results = this.crackerProcess(results[0],lengthOfKey);
        results[2] = findKey(text.substring(0,lengthOfKey), results[0].substring(0,lengthOfKey),lengthOfKey);    //we do not need to send all text
        this.decryptedText = results[0];
        this.key = results[2];
    }

    private String findKey(String cipherText,String decryptedText, int lengthOfKey){
        String key= "";
        for(int i=0;i<lengthOfKey;i++){
            int d = (USAlphabet.getCharacterNumber(cipherText.charAt(i)) - USAlphabet.getCharacterNumber(decryptedText.charAt(i)));
            d = (d % USAlphabet.numberOfCharacter) < 0 ? d +  USAlphabet.numberOfCharacter : d;
            key += USAlphabet.getCharacter(d);
        }
        return key;
    }

    private String[] crackerProcess(String text, int lengthOfKey){
        int bestGuess =0;
        String tempDecryptedText = "";
        String decryptedText = text;
        char[] key = new char[lengthOfKey];
        int d =0;
        for(int blockControl=0;blockControl<lengthOfKey;blockControl++){
            for(int j=0;j<USAlphabet.numberOfCharacter;j++){
                char[] textCharArray = decryptedText.toCharArray();
                for(int i=blockControl;i<text.length();i+=lengthOfKey){
                    d = USAlphabet.getCharacterNumber(textCharArray[i]) - j;
                    d = (d = d % USAlphabet.numberOfCharacter) < 0 ? d + USAlphabet.numberOfCharacter : d;
                    textCharArray[i] = USAlphabet.getCharacter(d);
                }
                for(char c : textCharArray){
                    tempDecryptedText += c;
                }
                int guessControl = CryptoTools.optimumFrequencyTest(tempDecryptedText);
                if(guessControl > bestGuess){
                    bestGuess = guessControl;
                    decryptedText = tempDecryptedText;
                    this.bestGuess = bestGuess;
                }
                tempDecryptedText = "";
            }
        }
        String[] result = new String[]{decryptedText,String.valueOf(bestGuess)," "};
        return result;
    }

    /**
     *
     * https://www.youtube.com/watch?v=LaWp_Kq0cKs
     *
     * I tried this algorithm
     * for i to textLength
     *
     * if each text char + i == textChar then index value++
     *
     * @param text
     * @return
     */
    private int findLenghtOfKey(String text) {
        int value = 0;
        int[] values = new int[text.length()];
        for (int i = 1; i < text.length(); i++) {
            for (int j = 0; i + j < text.length(); j++) {
                if(text.charAt(j) == text.charAt(i+j) ){
                     value++;
                }
            }
            values[i] = value;
            value = 0;
        }
        //find key length
        int keyLengthValue = 0;
        int keyLengthPosition = 0;
        for(int i=0;i<15;i++){
            if(values[i] > keyLengthValue){
                keyLengthPosition = i;
                keyLengthValue = values[i];
            }
        }
        return keyLengthPosition;
    }

    public String getKey() {
        return key;
    }

    public String getDecryptedText() {
        return decryptedText;
    }

    public int getBestGuess() {
        return bestGuess;
    }
}


































