package InterviewDirectory.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by huali on 2018/7/6.
 */
public class findladderLengthmin {
    public int ladderLength(String start, String end, HashSet<String> dict) {

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        queue.add(null);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int level = 1;
        while (!queue.isEmpty())
        {
            String str = queue.poll();
            if(str!=null)
            {
                for(int i =0;i<str.length();i++)
                {
                    char [] chars = str.toCharArray();
                    for(char c = 'a';c<='z';c++)
                    {
                        chars[i] = c;
                        String word = new String(chars);
                        if(word.equals(end))
                            return level+1;
                        if(dict.contains(word)&&!visited.contains(word))
                        {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            }else {
                level++;

                if(!queue.isEmpty())
                {
                    queue.add(null);
                }
            }
        }
        return 0;
    }
}