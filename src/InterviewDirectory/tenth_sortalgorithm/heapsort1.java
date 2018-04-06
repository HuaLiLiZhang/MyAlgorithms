package InterviewDirectory.tenth_sortalgorithm;

/**
 * Created by huali on 2018/4/6.
 */
public class heapsort1 {
    public void heapsort(char[]chas)
    {
        for(int i =0;i<chas.length-1;i++)
        {
            heapInsert(chas,i);
        }

        for(int i =chas.length-1;i>0;--i)
        {
            swap(chas, 0,i);
            heapify(chas, 0,i);
        }
    }

    public void heapify(char[]chars ,int i ,int size)
    {
        int left = i*2+1;
        int right = i*2+2;
        int largest = i;
        while (left<size)
        {
            if(chars[left]>chars[i])
                largest = left;
            if(right<size&&chars[right]>chars[largest])
                largest = right;
            if(largest!=i)
                swap(chars,largest,i);
            else break;

            i= largest;
            left = i*2+1;
            right = i*2+2;
        }
    }

    public void heapInsert(char[]chars, int i)
    {
        int parent = 0;
        while (i!=0)
        {
            parent = (i-1)/2;
            if(chars[parent]<chars[i])
            {
                swap(chars, parent,i);
                i = parent;  //持续访问父节点
            }else
            {
                break;
            }
        }
    }
    public void swap(char[]chars ,int a ,int b)
    {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}