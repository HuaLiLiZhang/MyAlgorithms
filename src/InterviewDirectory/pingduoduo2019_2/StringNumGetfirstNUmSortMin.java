package InterviewDirectory.pingduoduo2019_2;


import java.util.*;

/**
 * Created by huali on 2018/8/30.
 */
public class StringNumGetfirstNUmSortMin {
    //现在给出N个长度都为L的单词，单词中仅包含大写的英文字母（A-Z）
    //可以这样从这些单词中的第一个字母中挑一个作为你拼词的第一个字母，所有单词中的第二个单词作为你拼词的第二个字母。。。。以此类推
    //比如给你 N= 3， L= 4的单词
//CAKE
//TORN
//SHOW
    //你可以评出以下单词（但不仅限于）
    //CORN
    //SAKE
    //CHRE
    //但不能评出KARE

    //输出最小字典序的那个单词。

    static int N;
    static int L;
    static char [][] ch;
    static Set<String> set;
    static char [] output;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        sc.nextLine();
        ch = new char[L][N];
        set = new HashSet<>();
        output  = new char[L];
        for(int i = 0;i<N;i++)
        {
            String s = sc.nextLine();
            set.add(s);//存原来的，不能生成与原来字符串相等的。
            for(int j = 0;j<L;j++)
            {
                ch[j][i] = s.charAt(j);
            }
        }

        for(int j = 0;j<L;j++)
        {
            Arrays.sort(ch[j], 0,N);
        }


        boolean ishas = dfs(0);
        if(ishas)
        {
            for(int k = 0;k<L;k++)
            {
                System.out.print(output[k]);
            }
        }else
            System.out.println("-");



//3 4
//CAKE
//TORN
//SHOW
//CAKE  //错误：不能出现与原来输入的字符串相等的字符串。
    }

    //3 4
    //CAKE
    //TORN
    //SHOW
    //CAKN

    //3 4
    //COKE
    //TARN
    //SHOW
    //CAKE

    private static boolean dfs(int index) {
        if(index==L)
        {
            String temp = "";
            for(int i = 0;i<L;i++)
            {
                temp += output[i];
            }
            if(set.contains(temp))
                return false;
            else
                return true;
        }
        for(int i = 0;i<N;i++)
        {
            if(index>=L)
                continue;
            output[index] = ch[index][i];
            boolean ok = dfs(index+1);
            if(ok)
                return true;
        }
        return false;

    }


    //static char[][] s = new char[1010][1010];
//    static int n,l;
//    static char [] output = new char[100];
//    static Set<String> se = new HashSet<>();
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        l = sc.nextInt();
//        sc.nextLine();
//        for(int i = 0;i<n;i++) {
//            String x = sc.nextLine();
//            se.add(x);
//            for (int j = 0; j < l; j++) {
//                s[j][i] = x.charAt(j);
//            }
//        }
//        for(int i=0;i<l;i++)
//            Arrays.sort(s[i],0, n);
//        boolean ok = dfs(0);
//        if(ok)
//        {
//            int lk = 0;
//            while (lk<l&&output[lk]!=0)
//            {
//                System.out.print(output[lk++]);
//            }
//
//            System.out.println();
//        }
//        else
//            System.out.println("-");
//
////3 4
////COKE
////TARN
////SHOW
////CAKE
//
//    }
//
//    public static boolean dfs(int now)
//    {
//        if(now == l)
//        {
//            //output[now] = '\0';
//            if(se.contains(Arrays.toString(output)))
//                return false;
//            else
//                return true;
//        }
//        char last = '#';
//        for(int i=0;i<n;i++)
//        {
//            if(last == s[now][i])
//                continue;
//            last = s[now][i];
//            output[now] = last;
//            boolean ok = dfs(now + 1);
//            if(ok)
//                return true;
//        }
//        return false;
//    }
}