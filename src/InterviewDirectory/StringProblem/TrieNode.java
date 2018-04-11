package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/11.
 */
public class TrieNode {
    //字典树的结构
    public int path ;
    public int end;
    public TrieNode[]map;
    TrieNode()
    {
        this.path=0;
        this.end = 0;
        this.map = new TrieNode[26];

    }
}