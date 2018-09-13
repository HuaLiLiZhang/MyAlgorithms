package InterviewDirectory.souhu2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/13.
 */
public class compareversion12 {
    //比较版本号。比较两个版本号version1和version2
    //if version1>version2 return 1;if version1<version2 return -1;else return 0;

    //7.5.2.4 7.5.3
    //-1
    //0.1 1.1
    //-1
    //1.0.1 1
    //1
    //1.0.1 1
    //1
    //1.0 1
    //0
    //1.0.2 1.0.2.1
    //-1
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];
            int flag = compareVersion(s1,s2);
            if(flag>0)
                System.out.println(1);
            if(flag<0)
                System.out.println(-1);
            else if(flag==0)
                System.out.println(0);
        }

    }
    public static int compareVersion(String version1, String version2) throws Exception {
        if (version1 == null || version2 == null) {
            throw new Exception("compareVersion error:illegal params.");
        }
        String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，多的位数中全是0的话，相等，不全是的话，长度长的大；
        diff = (diff != 0) ? diff : is0full(versionArray1,versionArray2,idx);
        return diff;
    }

    private static int is0full(String[] versionArray1, String[] versionArray2,int idx) {
        int dif = versionArray1.length - versionArray2.length;
        String temp [] = dif>0?versionArray1:versionArray2;
        for(int i = idx;i<temp.length;i++)
        {
            if(!temp[i].equals("0"))
                return dif;
        }
        return 0;
    }

  /*  private static int compareVersion1(String version1, String version2) {
        if (version1 == null || version2 == null) {
            //logger.error("++++++++数据为空");
            return 0;
        }
        version1 = version1.replace("V", "");
        version1 = version1.replace("_beta", "");
        version2 = version2.replace("V", "");
        version2 = version2.replace("_beta", "");
        String[] versionArray1 = version1.split("\\.");// 注意此处为特殊字符，需要转义
        String[] versionArray2 = version2.split("\\.");// 注意此处为特殊字符，需要转义

        if (versionArray1.length >= versionArray2.length) {
            int sum = 0;
            for (int i = 0; i < versionArray2.length; i++) {
                sum = Integer.parseInt(versionArray1[i])
                        - Integer.parseInt(versionArray2[i]);
                if (sum > 0) {
                    return 1;
                } else if (sum < 0) {
                    return -1;
                }
            }
            if (sum == 0) {
                return 1;
            }
        } else {
            int sum = 0;
            for (int i = 0; i < versionArray1.length; i++) {
                sum = Integer.parseInt(versionArray1[i])
                        - Integer.parseInt(versionArray2[i]);
                if (sum > 0) {
                    return 1;
                } else if (sum < 0) {
                    return -1;
                }
            }
            if (sum == 0) {
                return -1;
            }
        }
        return 0;
    }*/



}