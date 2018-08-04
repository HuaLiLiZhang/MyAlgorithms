package InterviewDirectory.LeetCode_after;

import java.util.ArrayList;

/**
 * Created by huali on 2018/7/18.
 */
public class restoreIpAddresses1 {
    //没通过
    public ArrayList<String> restoreIpAddresses(String s)
    {
        String ch = "";
        ArrayList<String> arr = new ArrayList<>();
        getArray(arr, ch, s, 0);
        return arr;
    }

    private void getArray(ArrayList<String> arr, String ch, String s, int count) {
        if(count==3&&isvalid(s))
        {
            arr.add(ch+s);
            return ;
        }
        for(int i=1;i<4&&i<s.length();i++)
        {
            String sub = s.substring(0,i);
            if(isvalid(sub))
            {
                getArray(arr, ch+sub+".",s.substring(i), count+1);
            }
        }
    }

    private boolean isvalid(String s) {
        if(s.matches("[0]+"))
            return true;
        if(s.charAt(0)=='0')
            return false;
        int num = Integer.parseInt(s);
        if(s.length()>1)
            return s.charAt(0)!='0'&&num>=0&&num<=255;
        return num>=0&&num<=255;
    }


    public static void main(String[] args)
    {
        String s = "0000";
        restoreIpAddresses1 re = new restoreIpAddresses1();
        ArrayList<String> list= re.restoreIpAddresses(s);
        System.out.println(list);
    }


}