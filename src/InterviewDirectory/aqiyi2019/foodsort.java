package InterviewDirectory.aqiyi2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/15.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();
        int[] foodnum = new int[N];

        for(int i = 0;i<N;i++){
            foodnum[i] = sc.nextInt();
        }
        sc.nextLine();

        for(int i = 0;i<M;i++){
            String temp = sc.nextLine();

            String[] str= temp.split(" ");
            int num = Integer.valueOf(str[1])-1;

            if("A".equals(str[0])){
                foodnum[num]++;
            }else{
                foodnum[num]--;
            }
        }

        int temp = foodnum[P-1];
        int sortNum = 0;
        for(int i = 0;i<foodnum.length;i++){
            if(foodnum[i]>temp){
                sortNum++;
            }
        }
        System.out.println(sortNum+1);
    }
}