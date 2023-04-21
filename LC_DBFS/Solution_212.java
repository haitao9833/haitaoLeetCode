package leetcode.LC_DBFS;

import java.util.ArrayList;
import java.util.List;
import leetcode.LC_50.Trie;

public class Solution_212 {

    /**
     * 共享信息
     */
    int row;
    int col;
    char[][] board;
    Trie trie;
    boolean[][] vis;
    List<String> res;
    StringBuilder path;
    private final int[] dir_x = new int[]{0, 1, 0, -1};
    private final int[] dir_y = new int[]{1, 0, -1, 0};

    /**
     * dfs(i , j , father) == 在 Tire 树中从代表 board[i][j] 字符的节点开始查找到 isEnd == true 的路径，father 为其父节点
     */
    public List<String> findWords(char[][] board, String[] words) {
        // preliminary
        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        this.trie = new Trie();
        this.vis = new boolean[row][col];
        this.res = new ArrayList<>();
        this.path = new StringBuilder();

        // 将 words[] 插入字典树
        // 字典树从 ROOT 到 isEnd = true
        trie.buildTrie(words);

        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                dfs(i , j , trie.ROOT);
            }
        }
        return res;
    }
    private void dfs(int x , int y , Trie.TrieNode father) {
        // 每找到一个单词就删除之，可能导致 father == null ，详见下述
        if (father == null) {
            return;
        }
        // Trie 中没有代表 board[x][y] 字符的节点，即 words[] 中没有 board[x][y] 字符
        Trie.TrieNode curNode = father.next[board[x][y] - 'a'];
        if (curNode == null) {
            return;
        }

        // 添加该字符，看后续能不能走到 isEnd == true
        path.append(board[x][y]);
        vis[x][y] = true;

        // 找到了 words[] 中的一个 word ，加入 res 并删除之，为什么删除：
        // 考虑从一个 board[i][j] == 'A' 出发找单词 "ABC" ，且上下左右都可以找到单词 "ABC"
        // 不删除则会在 4 个方向都找到 isEnd = true 且都加入 res ，则结果集 res 重复，且有 3 个递归是多余的
        // 所以在递归第 1 个方向找到后就删除 "ABC" 则在其他 3 个方向不会重复加入 "ABC"
        // 但加入 res 并删除后不急着返回，因为可能后续还能匹配 "ABCD" 、"ABCDE" 等等
        // 若 "ABC" 所在的路径无其他单词了，则删除了 "ABC" 后，可能导致 'A' 、'B' 、'C' 字符节点为 null
        // 则从 'A' 字符节点再向其他 3 个方向递归搜索时会导致递归边界一：father == null
        if (curNode.isEnd) {
            String word = path.toString();
            res.add(word);
            trie.deleteWord(word);
        }

        // 递归上下左右找 isEnd == true 的路径
        for (int i = 0 ; i < 4 ; i++) {
            int aroundX = x + dir_x[i];
            int aroundY = y + dir_y[i];
            if (inArea(aroundX , aroundY) && !vis[aroundX][aroundY]) {
                dfs(aroundX , aroundY , curNode);
            }
        }

        vis[x][y] = false;
        path.deleteCharAt(path.length() - 1);
    }
    private boolean inArea(int x , int y) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }
}
