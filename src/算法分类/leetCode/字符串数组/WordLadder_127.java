package 算法分类.leetCode.字符串数组;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jackson on 2017/7/29.
 */
public class WordLadder_127 {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(start==null || end==null || start.length()==0 || end.length()==0 || start.length()!=end.length())
            return 0;
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int level= 1;
        int lastNum = 1;
        int curNum = 0;
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty())
        {
            String cur = queue.poll();
            lastNum--;
            for(int i=0;i<cur.length();i++)
            {
                char[] charCur = cur.toCharArray();
                for(char c='a';c<='z';c++)
                {
                    charCur[i] = c;
                    String temp = new String(charCur);
                    if(temp.equals(end))
                        return level+1;
                    if(dict.contains(temp) && !visited.contains(temp))
                    {
                        curNum++;
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            if(lastNum==0)
            {
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }


        public int ladderLength2(String beginWord, String endWord, HashSet<String> dict) {
            Queue<String> queue = new LinkedList<>();
            // step用来记录跳数
            int step = 2;
            queue.offer(beginWord);
            while(!queue.isEmpty()){
                int size = queue.size();
                // 控制size来确保一次while循环只计算同一层的节点，有点像二叉树level order遍历
                for(int j = 0; j < size; j++){
                    String currWord = queue.poll();
                    // 循环这个词从第一位字母到最后一位字母
                    for(int i = 0; i < endWord.length(); i++){
                        // 循环这一位被替换成25个其他字母的情况
                        for(char letter = 'a'; letter <= 'z'; letter++){
                            StringBuilder newWord = new StringBuilder(currWord);
                            newWord.setCharAt(i, letter);
                            if(endWord.equals(newWord.toString())){
                                return step;
                            } else if(dict.contains(newWord.toString())){
                                dict.remove(newWord.toString());
                                queue.offer(newWord.toString());
                            }
                        }
                    }
                }
                step++;
            }
            return 0;
        }

    public static void main(String[] args) {
        System.out.println();
    }
}
