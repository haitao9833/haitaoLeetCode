package leetcode.LC_DBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_638 {

    /**
     * 共享信息
     */
    List<Integer> price;
    List<List<Integer>> special;
    Map<List<Integer> , Integer> memo = new HashMap<>();

    /**
     * dfs(needs) == 计算满足但不超过 needs 的最低花费<p>
     * memo.get(needs) == 记忆满足 needs 所需的最少花费<p>
     * 每层确定一个：minCost = min(全部单价购买 , 购买大礼包 + 新 needs 所需的最低花费)<p>
     * 每层都需遍历所有的大礼包，因为大礼包<strong>可以重复购买</strong>
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.special = special;
        return dfs(needs);
    }
    private int dfs(List<Integer> curNeeds) {
        // 已经计算过了，记忆化，直接返回
        // ArrayList 的 equals() 比较的是长度和存储的元素
        if (memo.containsKey(curNeeds)) {
            return memo.get(curNeeds);
        }

        // 至贵是全部先用单价 price[] 购买
        int minCost = 0;
        for (int i = 0 ; i < curNeeds.size() ; i++) {
            minCost += curNeeds.get(i) * price.get(i);
        }

        // 每层遍历 special[] 中的每一个大礼包，即表明大礼包可以重复无限购买
        for (List<Integer> sp : special) {
            List<Integer> nextNeeds = new ArrayList<>(curNeeds);
            int index = 0;
            for ( ; index < nextNeeds.size() ; index++) {
                int nextNeed = nextNeeds.get(index) - sp.get(index);
                if (nextNeed < 0) {
                    break;
                }
                nextNeeds.set(index , nextNeed);
            }
            // 当前大礼包 sp 可以购买，不超过 needs[]
            if (index == nextNeeds.size()) {
                minCost = Math.min(minCost , sp.get(sp.size() - 1) + dfs(nextNeeds));
            }
        }

        // 遍历完所有的大礼包即可确定一个 memo
        memo.put(curNeeds , minCost);
        return minCost;
    }
}
