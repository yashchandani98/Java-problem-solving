
/* 
Michelle has created a word game for her students. The word game begins with Michelle writing a string and a number, K, on the board. The students have to ﬁnd the substrings of size K with K distinct characters.

Write an algorithm to help the students ﬁnd the correct answer. If the given string does not have K distinct characters then output an empty list.
Input
The input to the function/method consists of two arguments -
inputStr, representing the string written by the teacher;
num , an integer representing the number, K, written by the teacher on the board.

Output
Return distinct substrings of input string of size K with K distinct characters.

Constraints
0 ≤  num  ≤ 26

Note

The input string consists of only lowercase letters of the English alphabet. Substrings are not necessarily distinct.

Examples
Input:
inputStr = awaglknagawunagwkwagl
num = 4

Output:
{wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag}

Explanation:
Substrings in order are: wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag, wagl
"wagl" is repeated twice, but is included in the output once.
*/
import java.util.*;

public class SubStringProblem {
    public static void main(String args[]) {
        String str5 = "awaglknagawunagwkwagl";
        char str[] = str5.toCharArray();
        int k = 4;
        HashSet<String> str2 = new HashSet();
        String str4;
        int count = 0;
        for (int j = 0; j < str.length; j++) {
            StringBuilder str3 = new StringBuilder();
            count = 0;
            for (int i = j; i < str.length; i++) {
                if (count <= k) {
                    str4 = str3.toString();
                    if (str4.indexOf(str[i]) == -1) {
                        str3.append(str[i]);
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == k) {
                    count = 0;
                    str4 = str3.toString();
                    str2.add(str3.toString());
                    break;
                }
            }
        }
        // System.out.println(str2);
        for (String s : str2) {
            System.out.println(s);
        }
    }
}