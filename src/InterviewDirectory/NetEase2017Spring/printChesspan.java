package InterviewDirectory.NetEase2017Spring;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/5.
 */
public class printChesspan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [][] ch = new char[n][n];
        for(int i =0;i<n;i++)
        {
            ch[i] = sc.next().toCharArray();
        }
    }
}