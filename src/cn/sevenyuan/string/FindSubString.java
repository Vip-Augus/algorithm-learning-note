package cn.sevenyuan.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 * @author JingQ at 2020/3/23
 */
public class FindSubString {

    public List<Integer> findSubstring(String s, String[] words) {
        // 使用双map指针进行解题
        List<Integer> result = new ArrayList<>();
        int wordsSize = words.length;
        if (wordsSize == 0) {
            return result;
        }
        int wordLen = words[0].length();
        // 存放words中，相应word出现的次数
        HashMap<String, Integer> allWordMap = new HashMap<>();
        for (String word : words) {
            allWordMap.put(word, allWordMap.getOrDefault(word, 0) + 1);
        }
        // 遍历字符串s
        for (int i = 0; i < s.length() - wordsSize * wordLen + 1; i++) {
            HashMap<String, Integer> hasMap = new HashMap<>();
            int num = 0;
            while (num < wordsSize) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWordMap.containsKey(word)) {
                    hasMap.put(word, hasMap.getOrDefault(word, 0) + 1);
                    // 还有可能超过words中原来的限制
                    if (hasMap.get(word) > allWordMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wordsSize) {
                result.add(i);
            }
        }

        return result;
    }
}
