package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/28.
 */
public class str_01_boolean {
    //表达式得到期望结果的组成种数。
    //判断合法性
    //划分进行判断。时间复杂度为：O(N!) ,空间复杂度为：O(N)
    public int str_01_num1(String str, boolean desired)
    {
        if(str==null||str.equals(""))
            return 0;
        char[] ch = str.toCharArray();
        if(!isValid(ch))
            return 0;
        return p(ch,desired,0,ch.length-1);
    }

    public int p(char[]ch,boolean desired, int l,int r) {
        if (l == r) {
            if (ch[l] == '1')
                return desired ? 1 : 0;
            else
                return desired ? 0 : 1;
        }
        int res = 0;
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (ch[i]) {
                    case '&':
                        res += p(ch, true, l, i - 1) * p(ch, true, i + 1, r);
                        break;
                    case '|':
                        res += p(ch, true, l, i - 1) * p(ch, true, i + 1, r);
                        res += p(ch, true, l, i - 1) * p(ch, false, i + 1, r);
                        res += p(ch, false, l, i - 1) * p(ch, true, i + 1, r);
                        break;
                    case '^':
                        res += p(ch, true, l, i - 1) * p(ch, false, i + 1, r);
                        res += p(ch, false, l, i - 1) * p(ch, true, i + 1, r);
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i = i + 2) {
                switch (ch[i]) {
                    case '&':
                        res += p(ch, false, l, i - 1) * p(ch, true, i + 1, r);
                        res += p(ch, true, l, i - 1) * p(ch, false, i + 1, r);
                        res += p(ch, false, l, i - 1) * p(ch, false, i + 1, r);
                        break;
                    case '|':
                        res += p(ch, false, l, i - 1) * p(ch, false, i + 1, r);
                        break;
                    case '^':
                        res += p(ch, true, l, i - 1) * p(ch, true, i + 1, r);
                        res += p(ch, false, l, i - 1) * p(ch, false, i + 1, r);
                        break;
                }
            }
        }
        return res;
    }

    public boolean isValid(char[] ch)
    {
        if((ch.length&1)==0)
            return false;
        for(int i =0;i<ch.length;i=i+2)
        {
            if(ch[i]!='0'&&ch[i]!='1')
                return false;
        }
        for(int j =1;j<ch.length;j=j+2)
        {
            if(ch[j]!='&'&&ch[j]!='|'&&ch[j]!='^')
                return false;
        }
        return true;
    }

//此方法。。。有待思考。动态规划的， 时间复杂度为O(N3) ，空间复杂度是：O(N2)
    public int num2(String express, boolean desired)
    {
        if(express==null||express.equals(""))
            return 0;
        char[]exp = express.toCharArray();
        if(!isValid(exp))
            return 0;
        int [][] t = new int [exp.length][exp.length];
        int [][] f = new int [exp.length][exp.length];
        t[0][0] = exp[0]=='0'?0:1;
        f[0][0] = exp[0]=='1'?0:1;
        for(int i=2;i<exp.length;i+=2)
        {
            t[i][i] = exp[i]=='0'?0:1;
            f[i][i] = exp[i]=='1'?0:1;
            for(int j = i-2;j>=0;j-=2)
            {
                for(int k=j;k<i;k+=2)
                {
                    if(exp[k+1]=='&')
                    {
                        t[j][i]+=t[j][k]*t[k+2][i];
                        f[j][i]+=(f[j][k]+t[j][k])*f[k+2][i]+f[j][k]*t[k+2][i];
                    }else if(exp[k+1]=='|')
                    {
                        t[j][i]+=(f[j][k]+t[j][k])*t[k+2][i]+t[j][k]*f[k+2][i];
                        f[i][j]+=f[j][k]*f[k+2][i];
                    }else {
                        t[j][i]+=f[j][k]*t[k+2][i]+t[j][k]*f[k+2][i];
                        f[j][i]+=f[j][k]*f[k+2][i]+t[j][k]*t[k+2][i];
                    }
                }
            }
        }
        return desired?t[0][t.length-1]:f[0][f.length-1];
    }


}