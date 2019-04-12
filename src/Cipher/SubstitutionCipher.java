package Cipher;

import staticClasses.CryptoTools;
import staticClasses.USAlphabet;

public class SubstitutionCipher {
    private String message;
    private char[] newAlphabet;

    private String decryptedText;
    private char[] keyAlphabet;
    private int bestGuess;

    public SubstitutionCipher(String message, char[] newAlphabet) {
        this.message = message;
        this.newAlphabet = newAlphabet;
    }

    public SubstitutionCipher(){}

    public void substittutionCipherCracker(String text){
        text = crackProcess(crackProcess(text.toUpperCase()));
        System.out.println("bug test" + text);
    }

    private String crackProcess(String text){
        char[] keyAlphabet = USAlphabet.USAlphabet;
        char[] tempAlphabet = USAlphabet.USAlphabet;
        for(int i=0;i<keyAlphabet.length;i++){
            for(int j=0;j<keyAlphabet.length;j++){
                if(keyAlphabet[i] == keyAlphabet[j]){
                    continue;
                }
                char tempCharacter = keyAlphabet[i];
                keyAlphabet[i] = keyAlphabet[j];
                keyAlphabet[j] = tempCharacter;
                char[] tempDecryptedMessage = text.toCharArray();
                //swap the characters
                for(int k=0;k<text.length();k++){
                    if(tempDecryptedMessage[k] == keyAlphabet[i]){
                        tempDecryptedMessage[k] = keyAlphabet[j];
                    }else if(tempDecryptedMessage[k] == keyAlphabet[j]){
                        tempDecryptedMessage[k] = keyAlphabet[i];
                    }
                }
                int tempGuess = CryptoTools.optimumFrequencyTest(new String(tempDecryptedMessage));
                if(tempGuess > CryptoTools.optimumFrequencyTest(text)){
                    text = new String(tempDecryptedMessage);
                    System.out.println(text);
                    this.bestGuess = tempGuess;
                    this.keyAlphabet = keyAlphabet;
                }
            }
        }
        return text;
    }

    public char[] getNewAlphabet() {
        return newAlphabet;
    }

    public String getDecryptedText() {
        return decryptedText;
    }

    public char[] getKeyAlphabet() {
        return keyAlphabet;
    }

    public int getBestGuess() {
        return bestGuess;
    }
}
