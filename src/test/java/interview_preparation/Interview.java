package interview_preparation;

import com.google.common.primitives.Ints;
import org.testng.annotations.Test;

import java.util.*;

public class Interview {
    // Longest Substring Without Repeating Characters
    /*
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
     */

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public int[] evenOdd(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                list.add(num);
            }
        }
        for (int num : nums) {
            if (num % 2 != 0) {
                list.add(num);
            }
        }

        int[] newArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            newArray[i] = list.get(i);
        }

        return newArray;
    }

    /* Test Input 1 :
       rifat = should return 0
       Test Input 2 :
       rirat = should return 0
       Test Input 3 :
       rrifat = should return 2
       Test Input 4 :
       rrrifat = should return 3
       Test Input 5 :
       rrrrrr = should return -1
     */
    public static int returnFirstNonMatchingIndex(String s) {
        int nonMatchingIndex = 0;
        Character firstChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            Character nextChar = s.charAt(i);
            if (firstChar != nextChar) {
                return nonMatchingIndex;
            }
            nonMatchingIndex = i + 1;
        }
        if (nonMatchingIndex == s.length()) {
            return -1;
        }

        return nonMatchingIndex;
    }

    @Test
    public void test() {
        System.out.println(returnFirstNonMatchingIndex("rifat"));
        System.out.println(returnFirstNonMatchingIndex("rirat"));
        System.out.println(returnFirstNonMatchingIndex("rrifat"));
        System.out.println(returnFirstNonMatchingIndex("rrrifat"));
        System.out.println(returnFirstNonMatchingIndex("rrrrrr"));
    }

}
