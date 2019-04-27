package InterviewDirectory.nowcode_middle.String1;

/**
 * Created by huali on 2018/10/10.
 */
public class xuanhzuanstr {
    public static void main(String[] args)
    {
        String str = "1234adb"   ;
        String pat = "234adb1";
      //判断是否是旋转词: 只需要将str+str与pat进行字符串匹配就好
        boolean re = isxuanzhaunci(str+str, pat);

        boolean result = isxuanzhuancinextKMP(str+str,pat);


        System.out.println(re+","+result);



    }

    private static boolean isxuanzhuancinextKMP(String s, String pat) {
        int [] next = new int[pat.length()];
        int p = 2;
        int ans = 0;
        next[0] =-1; next[1] = 0;
        while (p<pat.length())
        {
            if(pat.charAt(p-1)==pat.charAt(ans))
                next[p++] = ++ans;
            else if(ans==0)
                next[p++]=0;
            else
                ans = next[ans];
        }
        int i = 0,j=0;
        for(;i<s.length()&&j<pat.length();)
        {
            if(s.charAt(i)==pat.charAt(j))
            {
                i++;
                j++;
            }else if(j!=0){
                j= next[j];
            }else
                i++;
        }


        if(i<s.length()&&j>=pat.length())
            return true;
        else
            return false;
    }

    private static boolean isxuanzhaunci(String s, String pat) {
        //第一笨方法：直接比较，从头开始
        int i =0,j = 0;
        int len = 0;
        for(;i<s.length()&&j<pat.length();)
        {
            if(s.charAt(i)==pat.charAt(j))
            {
                i++;
                j++;
                len ++;
            }
            else if(len==0)
            {
                i++;
            }else {
                j=0;
                i=i-len+1;
                len=0;
            }
        }
        if(i<s.length()&&j>=pat.length())
            return true;
        else
            return false;
    }
}