package leetcode.LC_50;

/**
 * 208.实现 Trie 树 —— 字典树 、前缀树 、单词查找树
 * 应用场景：一次建树，重复查找
 */

public class Trie {

    /**
     * 节点 == 字符：
     *      但不实际存储字符
     *      由其在父节点中的 next[] 下标决定其逻辑代表的字符
     *      下标 [0 ~ 25] == [a - z]
     *      isEnd 表示当前节点逻辑代表的字符是否为一个单词的末尾
     */
    public static class TrieNode {
        public boolean isEnd;
        public TrieNode[] next;
        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
            // 仅由小写英文字母组成 == 每个节点有 0 ~ 25 叉
        }
    }

    /**
     * ROOT == 不代表任何字符，可以理解为每个单词的前缀空字符
     */
    public final TrieNode ROOT;

    public Trie() {
        ROOT = new TrieNode();
    }

    /**
     * 插入单词
     */
    public void insert(String word) {
        TrieNode curNode = ROOT;
        for (char c : word.toCharArray()) {
            if (curNode.next[c - 'a'] == null) {
                curNode.next[c - 'a'] = new TrieNode();
            }
            curNode = curNode.next[c - 'a'];
        }
        curNode.isEnd = true;
    }

    /**
     * 查找单词
     */
    public boolean search(String word) {
        TrieNode curNode = ROOT;
        for (char c : word.toCharArray()) {
            curNode = curNode.next[c - 'a'];
            if (curNode == null) {
                return false;
            }
        }
        return curNode.isEnd;
    }

    /**
     * 查找前缀
     */
    public boolean startsWith(String prefix) {
        TrieNode curNode = ROOT;
        for (char c : prefix.toCharArray()) {
            curNode = curNode.next[c - 'a'];
            if (curNode == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将 String[] 全部插入
     */
    public void buildTrie(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    /**
     * curNode 表示的字符（由其父节点的 next[] 决定）后是否还能接有其他字符（由其 next[] 决定）
     */
    public boolean hasChildren(TrieNode curNode) {
        for (TrieNode child : curNode.next) {
            if (child != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除单词 == 只能删除该单词本身，该单词所在路径的其他单词不能删除
     * delete(idx , word , father) == 删除表示 word[idx] 字符的节点，father 为其父节点
     *                                返回 true 表示已经物理删除，返回 false 表示逻辑删除或未删除
     *                                需要递归到最后一个字符 word[n-1] 再一路向向上决定是否删除
     */
    public void deleteWord(String word) {
        delete(0 , word , ROOT);
    }
    public boolean delete(int idx , String word , TrieNode father) {
        // 通过父节点 father 的 next[] 获取表示 word[idx] 字符的节点
        // 若表示 word[idx] 的节点不存在，则要删除的 word 不存在，返回 false
        TrieNode curNode = father.next[word.charAt(idx) - 'a'];
        if (curNode == null) {
            return false;
        }

        // 递归到最后一个字符了，才开始一路向上决定是否删除
        if (idx == word.length() - 1) {
            if (hasChildren(curNode)) {
                // 删除 dog 的时候，不能把 dogs 等删除了
                // 只能标记 g 为逻辑删除，不再表示一个单词的末尾
                curNode.isEnd = false;
                return false;
            } else {
                // 物理删除最后一个字符，father 再也不指向这个字符
                // 注意，物理删除必须要用 father.next[] = null ，不能用 cur == null
                father.next[word.charAt(idx) - 'a'] = null;
                return true;
            }
        } else {
            // 非最后一个字符
            // 当且仅当后的的字符都物理删除了
            // 且自己无孩子字符，即删除 dog 的时候，后续 og 已经删除了，但不能把 dig 的 d 删除了
            // 且自己非单词末尾，删除 dogs 的时候，后续 s 已经删除了，不能把 dog 的 g 删除了
            // 才能物理删除自己
            if (delete(idx + 1 , word , curNode) && !hasChildren(curNode) && !curNode.isEnd) {
                father.next[word.charAt(idx) - 'a'] = null;
                return true;
            }
            return false;
        }
    }
}
