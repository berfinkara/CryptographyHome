package staticClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class USAlphabet {
    public static char[] USAlphabet = new char[]{'A','B','C','D','E','F','G','H',
                                            'I','J','K','L','M','N','O','P','Q',
                                            'R','S','T','U','V','W','X','Y','Z'
                                                };

    public static int numberOfCharacter = USAlphabet.length;

    public static int getCharacterNumber(char x){
        for(int i=0;i<USAlphabet.length;i++){
            if(USAlphabet[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static char getCharacter(int x){
        return USAlphabet[x];
    }
}
