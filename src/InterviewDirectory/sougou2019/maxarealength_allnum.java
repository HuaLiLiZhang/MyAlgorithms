package InterviewDirectory.sougou2019;

import java.util.*;

/**
 * Created by huali on 2018/9/14.
 */
public class maxarealength_allnum {

        //一个由若干个取值范围[1-2^31-1]的整数构成长度为N的数字序列，其中N<=5000000，求该数字序列上一段最小的连续区间的长度
        //要求该区间内正好包含了所有的不同的数字，如果存在多个这样的区间，按照出现的顺序有序的输出所有的区间的起始位置和结束位置
        //序列的位置编号从1到N，其中最小的区间长度不会超过10000.
        //输入：N，以及N个数
        //10
        //1 1 3 4 6 6 5 1 3 3
        //输出
        //6 3
        //[2,7] [3,8] [4,9]
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            long[] arr = new long[N];


            Set<Long> set = new HashSet<>(N);
            for(int i = 0;i<N;i++){
                arr[i] = in.nextLong();
                set.add(arr[i]);
            }

            int i = 0,j = 0;
            Map<Long, Integer> map = new HashMap<>(N);
            while(!isAllContained(map, set)){
                while(map.containsKey(arr[j])){
                    map.put(arr[j], map.get(arr[j])+1);
                    j++;
                }
                map.put(arr[j], 1);
                j++;
            }
            int state = 0;

            List<Integer> list = new ArrayList<>();
            int qujian = Integer.MAX_VALUE;
            int count = 0;

            while(isAllContained(map, set)||j!=N){
                if(state==0){
                    int temp = map.get(arr[i]);
                    if(temp==1){
                        map.remove(arr[i]);
                    }else{
                        map.put(arr[i], temp-1);
                    }

                    if(!isAllContained(map, set)){
                        count++;
                        if(j-i+1<qujian){
                            qujian = j-i;
                        }
                        list.add(i+1);
                        list.add(j);

                        i++;
                        state = 1;  //不包含set的话，表示此时是最大区间。
                        // i++并且继续执行，此后state = 1，继续将没有添加到map的元素，继续添加进去，arr[j]添加到map中，j++
                        continue;
                    }
                    i++;  //如果map包含set那么i++，继续移除元素。
                }else if(state == 1){
                    if(j==N) continue;

                    if(map.containsKey(arr[j])){
                        int temp = map.get(arr[j]);
                        map.put(arr[j], temp+1);
                        j++;
                    }else{
                        map.put(arr[j], 1);
                        j++;
                        if(isAllContained(map, set))
                            state = 0;  //如果此时添加元素导致map包含set，那么将状态state= 0；此后继续添加区间。
                    }
                }
            }

            System.out.println(qujian +" "+count);
            for(int m = 0;m<list.size();m+=2){
                System.out.print("["+list.get(m)+","+list.get(m+1)+"] ");
            }
        }

        private static boolean isAllContained(Map<Long, Integer> map,Set<Long> set){
            return map.keySet().containsAll(set);
        }

}