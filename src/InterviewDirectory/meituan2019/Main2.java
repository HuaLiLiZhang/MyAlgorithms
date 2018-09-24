package InterviewDirectory.meituan2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/6.
 */
public class Main2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int wind = 1;
        for(int i = 0;i<n;i++)
        {
            int tempwind = 1;
            for(int j = i;j<i+k&&j<n;j++)
            {
                if(j-1>i&&arr[j]==arr[j-1])
                {
                    tempwind++;
                }else {
                    wind = Math.max(wind,tempwind);
                    tempwind=1;

                }
                if(tempwind>=t||wind>=t)
                    count++;
            }
        //    5 3 2
            //3 1 1 1 2
        }
        System.out.println(count+1);

    }
}

//第二题
//小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
//1、r-l+1=k;
//2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
//输出满足条件的区间个数。
//思路：
//先判断n和k的关系，若k>n，直接返回0，若k<n，再进行后续计算
//设置一维数组lst[10005]，保存数列中值出现次数
//设置count，保存ar-al中出现t次及以上数的个数
//设置num,保存区间数
//首先从0到n-k-1遍历一遍，对lst、count、num进行初始化
//然后将窗口向右滑动，每次从头去一个，从尾部添加一个，动态维护lst、count、num的值
//
//最后输出num的值即可
//
//#include<bits/stdc++.h>
//using namespace std;
//int lst[10005];
//int main(){
//    int n,k,t;
//    while(cin>>n>>k>>t){
//        if(k<=n){
//            vector<int> vec;
//            memset(lst,0,sizeof(lst));
//            for(int i = 0;i<n;i++){
//                int x;
//                cin>>x;
//                vec.push_back(x);
//            }
//            int count = 0;
//            int num = 0;
//            for(int i = 0;i<k;i++){
//                lst[vec[i]]++;
//                if(lst[vec[i]]==t)
//                    count++;
//            }
//            if(count>0)
//                num++;
//            for(int i = 0;i<n-k;i++){
//                lst[vec[i]]--;
//                if(lst[vec[i]]==t-1)
//                    count--;
//                lst[vec[i+k]]++;
//                if(lst[vec[i+k]]==t)
//                    count++;
//                if(count>0)
//                    num++;
//            }
//            cout<<num<<endl;
//        }
//        else
//            cout<<0<<endl;
//    }
//   