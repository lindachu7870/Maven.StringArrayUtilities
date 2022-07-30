package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */
    public static String getFirstElement(String[] array) {
        return array[0];
    }
//        if (array.length > 0) {
//            return array[0];
//        }
//        return null;
//    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }
//        if (array.length > 0) {
//            return array[1];
//        }
//        return null;
//    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */
    public static boolean contains(String[] array, String value) {
        for(String s : array) {
            if(s.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */
    public static String[] reverse(String[] array) {
        String[] strArr = new String[array.length];
        int strArrIdx = 0;
        for(int i = array.length - 1; i >= 0; i--) {
            strArr[strArrIdx] = array[i];
            strArrIdx++;
        }
        return strArr;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */
    public static boolean isPalindromic(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length-1-i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */
    public static boolean isPangramic(String[] array) {
        HashSet<Character> set = new HashSet<>();
        for (String s : array) {
            String lowerCaseStr = s.toLowerCase();
            for (int i = 0; i < lowerCaseStr.length(); i++) {
                // Get current letter
                char currentLetter = lowerCaseStr.charAt(i);
                // Make sure current letter is only alphabet
                if (currentLetter >= 97 && currentLetter <= 122) set.add(currentLetter);
                if (set.size() == 26) return true;
            }
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */
    public static String[] removeValue(String[] array, String valueToRemove) {
        if (array == null) {
            return null;
        } else if (array.length <= 0) {
            return array;
        } else {
            String[] newStr = new String[array.length - 1];
            int count = 0;
            for (String i : array) {
                if (!i.equals(valueToRemove)) {
                    newStr[count++] = i;
                }
            }
            return newStr;
        }
    }
//        String[] str = new String[array.length];
//        int count = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i].equals(valueToRemove)) {
//                count++;
//                array[i] = null;
//            }
//        }
//        for (int i = 0; i < array.length - 1; i++) {
//            array[i] = array[i + 1];
//        }
//        return null;
//    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String[] result;
        int count = 0;
        int newIdx = 0;
        String curr = "";

        for(int i = 0; i < array.length; i++) {
            if(!array[i].equals(curr)) {
                curr = array[i];
            } else count++;
        }

        result = new String[array.length - count];

        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(curr)) {
                result[newIdx] = array[i];
                curr = array[i];
                newIdx++;
            }
        }

        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */
    public static String[] packConsecutiveDuplicates(String[] array) {
        String[] result;
        int count = 0;
        int newIdx = 0;
        String tmp = "";
        String curr = "";

        for(int i = 0; i < array.length; i++) {
            if(!array[i].equals(curr)) {
                curr = array[i];
            } else count++;
        }

        result = new String[array.length - count];
        String testValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(testValue)) {
                result[newIdx] = tmp;
                tmp = array[i];
                testValue = array[i];
                newIdx++;
            } else if (array[i].equals(testValue)) {
                tmp += array[i];
            } else
                result[newIdx] = array [i];
        }
        result[newIdx] = tmp;


        return result;
    }



}
