package leetcode.LC_DBFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_127 {

    /**
     * 共享信息
     * wordListSet   便于判断某个单词是否在 wordList 里面
     * allVisited    所有（双向）已经访问过的 word ，即 inQ
     *               只有 beginQueue 和 endQueue 的交集公共单词重复入队才有意义
     *               其他单词重复入队，反而加长了 distance 而且也没必要，例如：
     *               ab1 --> ab2 --> ab1  --> ab2 --> Ab2 明明可以更短 ab1 --> ab2 --> Ab2
     * beginQueue    从 beginWord 开始的队列
     * endQueue      从 endWord 开始的队列
     */
    Set<String> wordListSet;
    Set<String> allVisited;
    Set<String> beginQueue;
    Set<String> endQueue;

    /**
     * changeLetter(word , nextQueue) == 将与单词 word 即相差一个单词的 _word 入队 nextQueue
     *                                   如果该 _word 入队过 endQueue 了
     *                                   即 beginQueue 和 endQueue 扩散到了交集公共单词，返回 true
     */
    public int ladderLength(String beginWord , String endWord , List<String> wordList) {
        // preliminary ，待访问节点（beginWord 、endWord）入队
        this.wordListSet = new HashSet<>(wordList);
        if (wordListSet.size() == 0 || !wordListSet.contains(endWord)) {
            return 0;
        }
        this.allVisited = new HashSet<>();
        this.beginQueue = new HashSet<>(){{add(beginWord);}};
        this.endQueue = new HashSet<>(){{add(endWord);}};

        // beginWord --> ... --> endWord 的距离初始化为 2 表示 beginWord 和 endWord 两个单词
        int distance = 2;

        // 当前仅当两个 queue 还有下一层时
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            // 巧妙优化：每次从较小的队列开始扩散下一层，尽可能让两个方向的搜索范围更加平均
            // 总把较小的队列赋给 beginVisited
            if (beginQueue.size() > endQueue.size()) {
                Set<String> temp = beginQueue;
                beginQueue = endQueue;
                endQueue = temp;
            }

            // 更新入队较小的队列 beginQueue 的下一层 nextQueue
            // 即将与 beginQueue 中每个单词仅相差一个字符的单词入队 nextQueue
            Set<String> nextQueue = new HashSet<>();
            for (String word : beginQueue) {
                if (changeLetter(word , nextQueue)) {
                    return distance;
                }
            }
            // 没有返回 true ，即 nextQueue 和 endQueue 还没有遇到交集公共元素
            // 则将 nextQueue 赋给 beginQueue ，且 distance++ 记录加一，即层距离加一
            beginQueue = nextQueue;
            distance++;
        }
        return 0;
    }
    private boolean changeLetter(String word , Set<String> nextQueue) {
        // preliminary
        int n = word.length();
        char[] chW = word.toCharArray();

        // 尝试修改 word[] 的每一个字符
        for (int i = 0 ; i < n ; i++) {

            // 记录修改前的原字符，要回溯的
            char originChar = chW[i];

            // 当前字符 word[i] 需要尝试修改为 [a-z]
            for (char c = 'a' ; c <= 'z' ; c++) {
                if (originChar != c) {
                    // 修改之
                    chW[i] = c;
                    String _word = String.valueOf(chW);

                    // 如果 wordList 中有该单词
                    if (wordListSet.contains(_word)) {
                        // 如果 endQueue 中有该单词，直接返回 true
                        if (endQueue.contains(_word)) {
                            return true;
                        } else if (!allVisited.contains(_word)) {
                            // 之前没遍历到过该单词，加入 nextQueue
                            nextQueue.add(_word);
                            allVisited.add(_word);
                        }
                    }
                }
            }

            // 回溯恢复，修改下一个字符
            chW[i] = originChar;
        }
        return false;
    }
}
