package service;

import java.util.*;

public class hashTable {
    protected int hashtablesize;
    
    protected int hashValue(String stringToHash) {
        int string2int = 0;
        for (int i = 0; i < stringToHash.length(); i++) {
            string2int = (31 * string2int + stringToHash.charAt(i))%hashtablesize;
        }
        return string2int;
    }

    protected int hashValue(int valueToHash) {
        var hashValue = (Math.pow(3,valueToHash)%hashtablesize);
        return (int)hashValue;
    }

}