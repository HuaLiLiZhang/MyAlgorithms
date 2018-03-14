package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/14.
 */
public class listPartition1 {
    public node listpartition(node head ,int pivot)
    {
        if(head==null)
            return head;
        node cur = head;
        int i=0;
        while (cur!=null)
        {
            i++;
            cur=cur.next;
        }
        node[] nodeArr = new node[i];
        i=0;
        cur = head;
        for(i=0;i!=nodeArr.length;i++)
        {
            nodeArr[i] = cur;
            cur=cur.next;
        }
        arrPartition(nodeArr,pivot);
        for(i=1;i!=nodeArr.length;++i)
        {
            nodeArr[i-1].next=nodeArr[i];
        }
        nodeArr[i-1].next=null;
        return nodeArr[0];
    }

    public void arrPartition(node[]nodeArr,int pivot)
    {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index!=big)
        {
            if(nodeArr[index].val<pivot)
                swap(nodeArr,++small,index++);
            else if(nodeArr[index].val==pivot)
                index++;
            else
                swap(nodeArr,--big,index);
        }
    }
    public void swap(node[]nodeArr,int a ,int b)
    {
        node temp = nodeArr[a];
        nodeArr[a]=nodeArr[b];
        nodeArr[b]=temp;
    }
}