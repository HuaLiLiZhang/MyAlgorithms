package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/4.
 */
public class strtoint {

    public boolean isUnique2(char[]chs)
    {
        if(chs==null||chs.length==0)
            return false;
        headpsort(chs);
        for(int i = 1;i<chs.length;++i)
        {
            if(chs[i]==chs[i-1])
                return  false;
        }
        return true;
    }

    public void headpsort(char[]chars)
    {
        for(int i = 0;i<chars.length;i++)
        {
            heapInsert(chars, i);
        }
        for(int i = chars.length-1;i>0;--i)
        {
            swap(chars, 0, i);
            heapify(chars, 0, i);
        }
    }

    public void heapify(char[]chars, int i ,int len)
    {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        while (left<len)
        {
            if(chars[left]>chars[i])
                largest = left;
            if(right<len&&chars[right]>chars[largest])
                largest = right;
            if(largest!=i)
                swap(chars, largest, i);
            else
                break;
            i = largest;
            left = 2*i+1;
            right = 2*i+2;

        }
    }

    public void  heapInsert(char[]chars ,int i)
    {
        int parent = 0;
        while (i!=0)
        {
            parent = (i-1)/2;
            if(chars[parent]<chars[i])
            {
                swap(chars, parent, i);
                i = parent;
            }else
                break;

        }
    }
    public void swap(char[]chars ,int a ,int b)
    {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}