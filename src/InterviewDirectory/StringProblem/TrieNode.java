package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/11.
 */
public class TrieNode {
    //字典树的结构
    public int path ;
    public int end;
    public TrieNode[]map;
    TrieNode(int path ,int end)
    {
        this.path=path;
        this.end = end;
        this.map = new TrieNode[26];

    }
}