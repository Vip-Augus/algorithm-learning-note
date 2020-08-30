package cn.sevenyuan.tree;

/**
 * 字典树
 *
 * @author JingQ at 2020/8/25
 */
public class TrieTree {

    private static TrieNode root = new TrieNode('/');

    public static void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(text[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public static boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                // 如果匹配不上，表示不存在 pattern
                return false;
            }
            p = p.children[index];
        }
        // 判断是否完全匹配
        return p.isEndingChar;
    }


    public static class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
