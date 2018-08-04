package InterviewDirectory.thoughtworks;

/**
 * Created by huali on 2018/8/1.
 */
public class StringPassduplicate {
    public static void main(String[] args)
    {
        String s = "beabec";
        int pos = 2;
        int cn = 0;
        int [] arr = new int[s.length()];
        char [] ch = s.toCharArray();
        arr[0]=-1;
        arr[1] = 0;
        while (pos<ch.length)
        {
            if(ch[pos-1]==ch[cn])
            {
                arr[pos++] = ++cn;
            }
            else if(cn>0)
                cn = arr[cn];
            else
                arr[pos++]=0;

        }
        for(int i = 0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}