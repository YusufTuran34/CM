package com.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {

    public static boolean isEmpty(String s){
        return s == null || s.length() <= 0;
    }

    public static String getCharEnglish(String str) {
        int unicodeIntValue = 0;
        String unicodeString = "";
        if(str == null) return null;
        try {
            int length = str.length();

            for(int i=0; i<length;i++) {
                unicodeIntValue = str.charAt(i);
                if (unicodeIntValue == 220) {
                    unicodeString += "U";
                    continue;
                }
                if (unicodeIntValue == 252) {
                    unicodeString += "u";
                    continue;
                }
                if (unicodeIntValue == 214) {
                    unicodeString += "O";
                    continue;
                }
                if (unicodeIntValue == 246) {
                    unicodeString += "o";
                    continue;
                }
                if (unicodeIntValue == 199) {
                    unicodeString += "C";
                    continue;
                }
                if (unicodeIntValue == 231) {
                    unicodeString += "c";
                    continue;
                }

                if (unicodeIntValue == 221  || unicodeIntValue == 304) {
                    unicodeString += "I";
                    continue;
                }
                if (unicodeIntValue == 253 || unicodeIntValue == 305) {
                    unicodeString += "i";
                    continue;
                }
                if (unicodeIntValue == 254 || unicodeIntValue == 351) {
                    unicodeString += "s";
                    continue;
                }
                if (unicodeIntValue == 222 || unicodeIntValue == 350) {
                    unicodeString += "S";
                    continue;
                }
                if (unicodeIntValue == 208 || unicodeIntValue == 286) {
                    unicodeString += "G";
                    continue;
                }
                if (unicodeIntValue == 240 || unicodeIntValue == 287) {
                    unicodeString += "g";
                    continue;
                }

                unicodeString += (char) unicodeIntValue;
            }
            return unicodeString;
        } catch (Exception e) {
            System.out.println("unicodeConvert problem: " + e.getMessage());
        }
        return unicodeString;
    }
}
