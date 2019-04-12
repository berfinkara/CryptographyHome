package Cipher;

import staticClasses.CryptoTools;
import staticClasses.USAlphabet;

public class AffineCipher {
    private String message = null;
    private int keyA;
    private int keyB;

    private String decryptedMessage;

    private int bestGuess;

    private final int NUMBER_OF_CHARACTER = USAlphabet.numberOfCharacter;

    public AffineCipher(){}

    public AffineCipher(String message, int a, int b) {
        this.message = message.toUpperCase();
        this.keyA = a;
        this.keyB = b;
    }

    public String encryptMessage(){
        String encryptedMessage = "";
        char[] characters = message.toCharArray();
        for(char c: characters){
            int e = USAlphabet.getCharacterNumber(c);
            e = ((keyA * e) + keyB) % NUMBER_OF_CHARACTER;
            encryptedMessage += USAlphabet.getCharacter(e);
        }
        return encryptedMessage;
    }

    public String decryptMessage(String encryptedMessage,int a, int b){
        String decryptedMessage = "";
        char[] characters = encryptedMessage.toCharArray();
        for(char c:characters){
            int d = USAlphabet.getCharacterNumber(c);
            d = ((d-b)*inverseOfA(a));
            d = (d = d%NUMBER_OF_CHARACTER) < 0 ? d + NUMBER_OF_CHARACTER : d ;
            decryptedMessage += USAlphabet.getCharacter(d);
        }
        return decryptedMessage;
    }

    private int inverseOfA(int a){
        for(int i=0;i<NUMBER_OF_CHARACTER;i++){
            if(a * i % NUMBER_OF_CHARACTER == 1){
                return i;
            }
        }
        return -1;
    }

    public void affineCipherCracker(String text){
        text = text.toUpperCase();
        int bestGuess = 0;
        String tempDecryptedText = "";
        for(int i=0;i<USAlphabet.numberOfCharacter;i++){
            for(int j=0;j<USAlphabet.numberOfCharacter;j++){
                if(CryptoTools.relativelyPrimeTest(i,USAlphabet.numberOfCharacter)){   //if a and m is relatively prime, then decrypt
                    tempDecryptedText = decryptMessage(text,i,j);
                    if(CryptoTools.optimumFrequencyTest(tempDecryptedText) > bestGuess){
                        bestGuess = CryptoTools.optimumFrequencyTest(tempDecryptedText);
                        this.decryptedMessage = tempDecryptedText;
                        this.keyA = i;
                        this.keyB = j;
                        this.bestGuess = bestGuess;
                    }
                }
            }
        }
    }

    public int getKeyA() {
        return keyA;
    }

    public int getKeyB() {
        return keyB;
    }

    public int getBestGuess() {
        return bestGuess;
    }

    public String getDecryptedMessage() {
        return decryptedMessage;
    }
}

















