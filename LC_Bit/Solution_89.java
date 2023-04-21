package leetcode.LC_Bit;

import java.util.ArrayList;
import java.util.List;

public class Solution_89 {

    /**
     * 直接看 k 神的 PPT 图解吧
     */
    public List<Integer> grayCode(int n) {
        // G(0) = {0}
        List<Integer> res = new ArrayList<>();
        res.add(0);

        // G(1) ~ G(n)
        for (int i = 1 ; i <= n ; i++) {
            // 逆序镜像倍增
            for (int j = res.size() - 1 ; j >= 0 ; j--) {
                res.add(res.get(j) | (1 << (i - 1)));
            }
        }
        return res;
    }
}
