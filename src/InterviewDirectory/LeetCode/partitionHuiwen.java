package InterviewDirectory.LeetCode;

import java.util.ArrayList;

/**
 * Created by huali on 2018/7/6.
 */
public class partitionHuiwen {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        if(s.equals("")||s.length()<=0)
            return arr;
        ArrayList<String> temp = new ArrayList<>();
        getArray(s, arr,temp);
        return arr;

    }

    private void getArray(String s, ArrayList<ArrayList<String>> arr,
                          ArrayList<String> temp ) {
        if(s.length()<=0)
        {
            ArrayList<String> tmp = new ArrayList<>(temp);
            arr.add(tmp);
            return ;
        }
        for(int i=0;i<s.length();i++)
        {

            if(ishuiwen(s.substring(0,i+1)))
            {
                temp.add(s.substring(0,i+1));
                getArray(s.substring(i+1,s.length()),arr,temp);
                temp.remove(temp.size()-1);

            }
            //temp.remove(temp.size()-1);
            //temp = new ArrayList<>();
        }
    }
    private boolean ishuiwen(String s) {
        boolean flag = true;
        for(int i=0,j=s.length()-1;i<j;i++,j--)
        {
            if(s.charAt(i)!=s.charAt(j)) {
                flag = false;
                break;
            }
        }
        return flag;
    }


    public static void main(String []args)
    {
        String s = "cdd";
        partitionHuiwen pa = new partitionHuiwen();
        ArrayList<ArrayList<String>> arr = pa.partition(s);
        System.out.println(arr);
    }
}