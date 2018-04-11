package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/11.
 */
public class TrieNode {
    //字典树的结构
    public int path ;
    //表示：有多少个单词公用这个结点
    public int end;
    //end：表示：有多少个单词以这个单词结尾
    public TrieNode[]map;
    //map是一个哈希表的结构，key代表结点的一条字符路径，
    //value：代表字符路径指向的结点。
    TrieNode()
    {
        this.path=0;
        this.end = 0;
        this.map = new TrieNode[26];

    }
}