package InterviewDirectory.binaryTree_example;

/**
 * Created by huali on 2018/4/12.
 */
public class printtree {
    public class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public void printTree(Node head)
    {
        System.out.println("binaryTree: ");
        printInorder(head, 0, "H", 17);
        System.out.println();
    }

    public void printInorder(Node head, int height, String to, int len)
    {
        if(head==null)
            return ;
        printInorder(head.right, height+1,"v",len);
        String val = to+head.value+to;
        int lenM = val.length();
        int lenL = (len-lenM)/2;
        int lenR = len-lenM-lenL;
        val = getSpace(lenL)+val+getSpace(lenR);
        System.out.println(getSpace(height*len)+val);
        printInorder(head.left, height+1, "^",len);
    }

    public String getSpace(int num)
    {
        String space = "";
        StringBuffer buf= new StringBuffer("");
        for(int i = 0;i<num;i++)
        {
            buf.append(space);
        }
        return buf.toString();
    }
}