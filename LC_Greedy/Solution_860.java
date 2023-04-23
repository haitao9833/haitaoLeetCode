package leetcode.LC_Greedy;

public class Solution_860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] == 10 || bills[0] == 20) return false;
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            }
            else {
                if (ten > 0 && five > 0) { // 贪心，面对 20 元时，先消耗 10 元的
                    ten--;
                    five--;
                }
                else if (five >= 3){ // 没有 10 元的，再消耗 3 张 5 元的
                    five -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}
