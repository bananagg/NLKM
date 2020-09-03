package com.wake.nlkm.utils;

import org.assertj.core.util.Preconditions;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @Author Ganty
 * @Date 2020/8/21
 * @Des
 */
public class TextSimilarity {

    public static int editDistance(String str1, String str2) {
        Preconditions.checkNotNull(str1);
        Preconditions.checkNotNull(str2);

        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 == 0) {
            return len2;
        }else if (len2 == 0) {
            return len1;
        }else if (str1.charAt(len1-1) == str2.charAt(len2-1)) {
            return editDistance(str1.substring(0, len1-1), str2.substring(0, len2-1));
        }else {
            return 1 + min(editDistance(str1.substring(0, len1), str2.substring(0, len2-1)),
                    min(editDistance(str1.substring(0, len1-1), str2.substring(0, len2)),
                            editDistance(str1.substring(0, len1-1), str2.substring(0, len2-1))));
        }

    }

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public static double editDistanceSimilarity(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        int step = editDistance(str1, str2);
        double score = 1.0 - ((double) step) / max(len1, len2);
        return score;
    }

    public static void main(String[] args) {
        String s1 = "静夜思";
        String s2 = "李白的静夜思";
        double score = editDistanceSimilarity(s1, s2);
        System.out.println(score);
    }
}
