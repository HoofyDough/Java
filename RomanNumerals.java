import java.util.*;

class RomanNumerals {

    public int romanToInt(String s) {
        int romanInteger = 0;
        char prevChar = 'M';

        for(Character c : s.toCharArray()) {
            int curVal = RomanNumeral.getValueFromRoman(c);
            int prevVal = RomanNumeral.getValueFromRoman(prevChar);
            if(prevVal < curVal)
                romanInteger += curVal - (2*prevVal);
            else
                romanInteger += curVal;
            prevChar = c;
        }

        return romanInteger;
    }

    public String intToRoman(int num) {
        String roman = "";
        boolean divideByFive = false;
        int marker = 1000;

        while(num > 0) {
            int newVal = num - marker;
            if(newVal >= 0) {
                int leadingDigit = num;
                int multiplier = 1;
                int temp = num;

                while(temp/10 > 0) {
                    multiplier *= 10;
                    temp /= 10;
                    leadingDigit = temp;
                }
                if(leadingDigit == 4 || leadingDigit == 9) {
                    roman += RomanNumeral.getRomanFromValue(multiplier);
                    roman += RomanNumeral.getRomanFromValue(multiplier*(leadingDigit+1));
                    newVal = num - multiplier*(leadingDigit);
                } else {
                    roman += RomanNumeral.getRomanFromValue(marker);
                }

                num = newVal;
            } else {
                marker /= (divideByFive ? 5 : 2);
                divideByFive = !divideByFive;
            }
        }

        return roman;
    }

    private enum RomanNumeral {
        I('I',1), V('V',5), X('X',10), L('L',50), C('C',100), D('D',500), M('M',1000);

        private int value;
        private char roman;
        private static Map<Character, Integer> mapRomanToValue = new HashMap<>();
        private static Map<Integer, Character> mapValueToRoman = new HashMap<>();

        static {
            for (RomanNumeral rm : RomanNumeral.values()) {
                mapRomanToValue.put(rm.roman, rm.value);
                mapValueToRoman.put(rm.value, rm.roman);
            }
        }

        RomanNumeral(char roman, int value) {
            this.roman = roman;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public char getRoman() {
            return roman;
        }

        public static int getValueFromRoman(char roman) {
            return mapRomanToValue.get(roman);
        }

        public static Character getRomanFromValue(int value) {
            return mapValueToRoman.get(value);
        }
    }
}