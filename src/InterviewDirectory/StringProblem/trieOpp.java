package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/11.
 */
public class trieOpp {
    private TrieNode root;
    public trieOpp()
    {
        root = new TrieNode();
    }

    public boolean search(String word)
    {
        if(word==null||word.equals(""))
            return false;
        char[] words = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for(int i = 0;i<words.length;i++)
        {
            index = words[i]-'a';
            if(node.map[index]==null)
                return false;
            node = node.map[index];
        }
        return node.end!=0;
    }

    public void insert(String word)
    {
        if(word==null||word.equals(""))
            return ;
        char[] words = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for(int i = 0;i<words.length;i++)
        {
            index = words[i]-'a';
            if(node.map[index]==null)
            {
                node.map[index] = new TrieNode();//先插入结点
            }
            node = node.map[index];
            //依此结点开始继续往下创建新节点，因为原来里面没有这个新的结点
            //并将path++
            node.path++;
        }
        //最终以此结尾的end结点++
        node.end++;
    }
    public void delete(String word)
    {
        if(search(word))
        {
            char[] words = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                index = words[i] - 'a';
                if (node.map[index].path-- == 1) {
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }
    }

    public int prefixNUmber(String pre)
    {
        if(pre==null||pre.equals(""))
            return 0;
        char[] words = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for(int i =0;i<words.length;i++)
        {
            index = words[i] - 'a';
            if(node.map[index]==null)
                return 0;
            node = node.map[index];
        }
        return node.path;
    }
}