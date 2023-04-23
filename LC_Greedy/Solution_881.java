package leetcode.LC_Greedy;

import java.util.Arrays;

/**
 * 贪心策略：尽量一个瘦子搭配一个胖子
 */
public class Solution_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int res = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            res++;
        }
        return res;
    }
}
