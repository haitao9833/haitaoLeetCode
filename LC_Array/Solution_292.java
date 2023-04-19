package leetcode.LC_Array;

public class Solution_292 {

    /**
     * 先手拿 [1 , 3] 块石头
     * <p> 后手拿 [3 , 1] 块石头，即后手能保证每轮下来共只拿 4 块石头
     * <p> 若 n % 4 == 0 则先手必输
     * <p> 若 n % 4 != 0 则先手第一次拿掉 n % 4 块石头后，先手必赢
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
