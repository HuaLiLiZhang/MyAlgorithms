package InterviewDirectory.haoweilai2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/28.
 */
public class Main5 {
    //对于正整数数组，求最大元素和，要求元素大小必须是升序。
    //int[] data = {5,1,3,4,9,7,6,8};
    //最大升序序列是：1,3,4,7,8

    //5 1 3 4 9 7 6 8
    //23

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] temp = s.split(" ");
            int[] a = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                a[i] = Integer.parseInt(temp[i]);
            }

            

            }


        }

    }















     /*   public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            List<Integer> list = new ArrayList<>();

            while(sc.hasNext()){
                try{
                    list.add(sc.nextInt());
                }catch (Exception e) {
                    break;
                }

            }
            int sum = themaxsum(Integer.MIN_VALUE,0,list,0);
            System.out.println(sum);

        }

        //5 1 3 4 9 7 6 8
        //23
        private static int themaxsum(int pre, int start, List<Integer> list, int sum) {
            if(start==list.size()){
                return sum;
            }else{
                if(start==0){
                    int sum1 = themaxsum(pre,start+1, list, sum);//不选第一个
                    int sum2 = themaxsum(list.get(start),start+1, list, sum+list.get(start));//选第一个
                    return Math.max(sum1, sum2);
                }else{
                    int sum1 = themaxsum(pre,start+1, list, sum);//不选第start个
                    if(list.get(start)>pre){//如果是大于前一个的则可以选。
                        int sum2 = themaxsum(list.get(start),start+1, list, sum+list.get(start));//选第一个
                        return Math.max(sum1, sum2);
                    }
                    return sum1;
                }
            }
        }
*/

}