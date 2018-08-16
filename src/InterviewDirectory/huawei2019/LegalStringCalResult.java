package InterviewDirectory.huawei2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by huali on 2018/8/15.
 */
public class hefashuString {
        //测试用例：
        //(+ (* 2 3) (^ 4))
        //11

        //(+ (* 2 3) (^ 4))(2 3)
        //11

        //(+ (+ (* 2 3) (^ 4)) (+ 2 3))
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String string = in.nextLine();

            Stack<Integer> yunsuanStatus = new Stack<>();//1 加法第一个数，2加法第二个数，3乘法第一个数，4乘法第二个数，5自增的数。
            int depth = 0;

            String[] strs = string.split(" ");
            List<String> list = new ArrayList<String>();

            for(int i = 0;i<strs.length;i++){
                if(isInteger(strs[i])||strs[i].length()==1){
                    list.add(strs[i]);
                }else{
                    String ss = strs[i];
                    if(isInteger(String.valueOf(strs[i].charAt(0)))){
                        int k = 0;
                        for(;k<ss.length();k++){
                            if(isInteger(String.valueOf(strs[i].charAt(k)))){
                                continue;
                            }else{
                                break;
                            }
                        }

                        list.add(ss.substring(0, k));
                        for(int m = k;m<ss.length();m++){
                            list.add(String.valueOf(ss.charAt(k)));
                        }
                    }else{
                        for(int m = 0;m<strs[i].length();m++){
                            list.add(String.valueOf(strs[i].charAt(m)));
                        }
                    }
                }
            }


            if(!"(".equals(list.get(0))){
                System.out.println(-1);
                return;
            }
            Stack<String> stack = new Stack<>();

            for(int i = 0;i<list.size();i++){
                if("(".equals(list.get(i))){
                    stack.push(list.get(i));
                    depth++;
                }else if(")".equals(list.get(i))){
                    if(depth<1) {
                        System.out.println(-1);
                        return;
                    }else if(depth==1){
                        if(yunsuanStatus.size()==0){
                            String string2 = stack.pop();

                            if(stack.size()==1&&isInteger(string2)){
                                System.out.println(string2);
                                return;
                            }else{
                                System.out.println(-1);
                                return;
                            }
                        }else{
                            int stuses = yunsuanStatus.pop();
                            switch (stuses) {
                                case 1:
                                    String string2 = stack.pop();
                                    String string3 = stack.pop();
                                    System.out.println(Integer.valueOf(string2)+Integer.valueOf(string3));
                                    return;
                                case 3:
                                    String string4 = stack.pop();
                                    String string5 = stack.pop();
                                    System.out.println(Integer.valueOf(string4)*Integer.valueOf(string5));
                                    return;


                                case 5:
                                    String string6 = stack.pop();
                                    System.out.println(Integer.valueOf(string6)+1);
                                    return;
                                default:
                                    break;
                            }
                        }
                        if(stack.size()>2){
                            String string2 = stack.pop();
                            String string3 = stack.pop();
                            if(isInteger(string3)){

                            }else{
                                System.out.println(string3);
                            }
                        }else{
                            String string2 = stack.pop();

                            if(stack.size()==1&&isInteger(string2)){
                                System.out.println(string2);
                                return;
                            }else{
                                System.out.println(-1);
                                return;
                            }
                        }
                    }else{
                        String string2 = stack.pop();
                        String string3 = stack.pop();
                        if(isInteger(string2)&&"(".equals(string3)){
                            stack.push(string2);
                        }else{
                            System.out.println(-1);
                            return;
                        }
                        depth--;
                    }
                }else if("+".equals(list.get(i))){
                    yunsuanStatus.push(1);
                }else if("*".equals(list.get(i))){
                    yunsuanStatus.push(3);
                }else if("^".equals(list.get(i))){
                    yunsuanStatus.push(5);
                }else if(isInteger(list.get(i))){
                    int status = yunsuanStatus.pop();
                    switch (status) {
                        case 1:
                            stack.push(list.get(i));
                            yunsuanStatus.push(++status);
                            break;
                        case 2:
                            String temp = stack.pop();
                            if(!isInteger(temp)) {
                                System.out.println(-1);
                                return;
                            }
                            stack.push(String.valueOf(Integer.valueOf(temp)+Integer.valueOf(list.get(i)))); //把两个数的和放入栈中。
                            break;
                        case 3:
                            stack.push(list.get(i));
                            yunsuanStatus.push(++status);
                            break;
                        case 4:
                            String temp1 = stack.pop();
                            if(!isInteger(temp1)) {
                                System.out.println(-1);
                                return;
                            }
                            stack.push(String.valueOf(Integer.valueOf(temp1)*Integer.valueOf(list.get(i)))); //把两个数的乘积放入栈中。
                            break;
                        case 5:
                            stack.push(String.valueOf(Integer.valueOf(list.get(i))+1)); //把这个数的自增放入栈中。
                            break;
                        default:
                            break;
                    }
                }
            }

            if(depth!=0){
                System.out.println(-1);
            }
        }

        public static boolean isInteger(String str) {
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            return pattern.matcher(str).matches();
        }

}