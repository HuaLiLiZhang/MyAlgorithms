package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/4.
 */
public class isRotation {
    public boolean isrotation(String  a, String b)
    {
        if(a==null||b==null||a.length()!=b.length())
            return false;
        String b2 = b + b;
        return getIndexof(b2 , a);
    }
    public boolean getIndexof(String b, String a)
    {
        char[] ch1 = b.toCharArray();
        char[]ch2 = a.toCharArray();
        int j =0;
        for(int i=0;i<ch1.length;i++)
        {
            if(j<ch2.length)
            {
                if(ch1[i]==ch2[j])
                {
                    j++;
                }else {
                    j=0;
                }
            }else {
                return true;
            }

        }
        return false;
    }
}