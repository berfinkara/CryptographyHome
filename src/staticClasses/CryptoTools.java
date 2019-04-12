package staticClasses;

import java.util.*;

public class CryptoTools {


    /**
     *
     * @param text to measure frequency
     * @return frequency of text
     */
    public static int optimumFrequencyTest(String text){
        text = text.toUpperCase();

        int value = 0; //if value is high, then there is a high possibilty it is searched text
        value += getLetterFrequencyValue(findFrequencyOfText(text));    //add letter frequency
        value += diagramsFrequencyTest(text);           //add diagram frequency
        value += triagramFrequencyTest(text);
        return value;
    }

    /**
     * optimumFrequency test gets tridiagram, diagram and letter frequencies and sum all of them
     * @param text
     * @return
     */

    private static int triagramFrequencyTest(String text){
        int value = 0;
        String[] triagrams = new String[]{"THE","ING","AND","HER","ERE","ENT","THA","NTH","WAS","ETH","FOR","DTH"};
        char[] textCharArray = text.toCharArray();
        for(String triagram:triagrams){
            for(int i=0;i<text.length()-2;i++){
                if(triagram.charAt(0) == textCharArray[i] && triagram.charAt(1) == textCharArray[i+1] && triagram.charAt(2) == textCharArray[i+2]){
                    value++;
                }
            }
        }
        return value;
    }

    private static int diagramsFrequencyTest(String text){
        int value = 0;
        String[] diagrams = new String[]{"TH","HE","IN","ER","AN","RE","ED","ON","ES","ST","EN","AT","TO","NT",
                "HA","ND","OU","EA","NG","AS","OR","TI","IS","ET","IT","AR","TE","SE","HI","OF"};
        char[] textCharArray = text.toCharArray();
        for(String diagram:diagrams){
            for(int i=0;i<text.length()-1;i++){
                if(diagram.charAt(0) == textCharArray[i] && diagram.charAt(1) == textCharArray[i+1]){
                    value++;
                }
            }
        }
        return value;
    }

    private static int getLetterFrequencyValue(HashMap<Character,Float> frequencies){
        int value = 0;
        HashMap<Character,Float> realFrequencies = getRealFrequencies();
        Set set = frequencies.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if(realFrequencies.get(entry.getKey()) > (Float)entry.getValue() * 0.6f && realFrequencies.get(entry.getKey()) < (Float)entry.getValue() * 1.5f){
                value++;
            }
        }
        return value;
    }

    /**
     * These are the hashmaps help us to get frequencies.
     * @return
     */

    private static HashMap<Character,Float> getRealFrequencies(){
        HashMap<Character,Float> frequencies = new HashMap<>();
        frequencies.put('E',0.127F);frequencies.put('T',0.091F);frequencies.put('A',0.082F);frequencies.put('O',0.075F);
        frequencies.put('I',0.070F);frequencies.put('N',0.067F);frequencies.put('S',0.063F);frequencies.put('H',0.061F);
        frequencies.put('R',0.060F);frequencies.put('D',0.043F);frequencies.put('L',0.040F);frequencies.put('C',0.028F);
        frequencies.put('U',0.028F);frequencies.put('M',0.024F);frequencies.put('W',0.023F);frequencies.put('F',0.022F);
        frequencies.put('G',0.020F);frequencies.put('Y',0.020F);frequencies.put('P',0.019F);frequencies.put('B',0.015F);
        frequencies.put('V',0.010F);frequencies.put('K',0.008F);frequencies.put('J',0.002F);frequencies.put('X',0.001F);
        frequencies.put('Q',0.001F);frequencies.put('Z',0.001F);
        return frequencies;
    }

    public static HashMap<Character,Float> findFrequencyOfText(String text){
        text = text.toUpperCase();
        HashMap<Character,Float> frequencies = new HashMap<>();

        for(char c:text.toCharArray()){
            frequencies.put(c,(frequencies.get(c) == null ? 1.0f : frequencies.get(c))+1);
        }
        Set set = frequencies.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            frequencies.put((Character) entry.getKey(),Float.valueOf((Float) entry.getValue())/Float.valueOf(text.length()));
        }
        return sortByValues(frequencies);
    }

    public static char returnBestFrequencyCharacter(String text){
        HashMap<Character,Float> frequencies = findFrequencyOfText(text);
        Set set = frequencies.entrySet();
        Map.Entry entry = (Map.Entry) set.iterator().next();
        return (char) entry.getKey();
    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    /**
     *
     * @param a to ax+b
     * @param m  number of character in alphabet
     * @return inverse of a with modular m
     */
    public static int inverseOfA(int a, int m){
        for(int i=0;i<m;i++){
            if(a * i % m == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param number1
     * @param number2
     * @return are the number relativelyPrime
     */
    public static boolean relativelyPrimeTest(int number1, int number2){
        int biggerNumber = ( number1 > number2) ? number1 : number2;
        for(int i=2; i < biggerNumber;i++){
            if((number1 % i) == 0 && (number2 % i) == 0){
                return false;
            }
        }
        return true;
    }

}
