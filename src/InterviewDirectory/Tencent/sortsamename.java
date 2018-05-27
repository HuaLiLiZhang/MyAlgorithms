package InterviewDirectory.Tencent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by huali on 2018/5/27.
 */
public class sortsamename {
//    小米公司内部每个员工都会有一个专属的工作邮箱，邮箱的前缀是员工姓名的拼音全拼
// ，例如张强的邮箱是zhangqiang@xiaomi.com,但同时公司里有很多同名的人，为了避免大家相互之间发错邮件，
// 工程师们想了个规则来解决这个问题，即在这些同命人中，
// 入职最早的邮箱前缀为姓名的拼音全拼，第二个入职的邮箱前缀为姓名的拼音全拼后面加“_a”，
// 第三个入职的为姓名的拼音全拼后面加“_b”,以次类推，请按这个规则，
// 如果公司里同时有3位名叫张强的员工，
// 则他们的邮箱分别是zhangqiang@xiaomi.com，zhangqiang_a@xiaomi.com，zhangqiang_b@xiaomi.com...
// 邮箱前缀是员工在公司里的重要标识之一，问题来了：现在小米要举行一次全员野外拉练活动，
// 要求所有员工必须排成一队出去，并且，有的员工要求他必须排在某人的前面或后面，作为组织者的你，
// 收到这样的需求之后，如何给出一个让每个人都满意的排队方式呢？

//class RequestItem
//{
//    public String member;
//    public boolean standFront; //true表示要排在这个人的前面，false表示要排在这个人的后面
//}
//class Request
//{
//    public String owner;    //那个人提出的要求
//    List<RequestItem> requestItems;    //他要排在哪些人的前面，哪些人的后面
//}
//List<String> getValidOrder(List<String>allMembers, List<Request> requests);
//allMembers就是所有员工的邮箱前缀，
// requests是一些人的排队要求。小米公司现有几千名员工，
// 每个人最多有10个排队要求（要排在一个人的前面或者后面算一个排队要求），
// 也有人没有什么要求。现在你的任务是完成上面的getValidOrder函数，
// 如果有合法的排队序列，那么返回其中任何一个。否则返回null。

    static int[][] map;
    static int[] indegree; // 这n个点的入度
    static int n, m; //顶点数，边数  边的条数等于邻接矩阵中1的个数的一半。
    static LinkedList<Integer> stack = new LinkedList<Integer>(); //模拟栈


    public static void main(String []args)
    {

    }

    List<String> getValidOrder(List<String>allMembers, List<Request> requests)
    {
        List<String> list = new ArrayList<>();

        n = allMembers.size();
        map = new int [allMembers.size()][allMembers.size()];

        for(int i =0;i<requests.size();i++)
        {
            String owner = requests.get(i).owner;
            int num = allMembers.indexOf(owner);
            List<RequestItem> requestItems = requests.get(i).requestItems;
            for(int j=0;j<requestItems.size();j++)
            {
                String number = requestItems.get(j).member;
                int numo = allMembers.indexOf(number);
                boolean standfront = requestItems.get(j).standFront;
                if(standfront)
                {
                    if(map[numo][num]==-1)
                        return null;
                    map[numo][num] = 1;
                }
                else
                {
                    if(map[numo][num]== 1)
                        return null;
                    map[numo][num] = -1;
                }
            }
        }
        //选用数据结构，map[n][n]。
        //1、其中map[i][j]=1代表i在j的前面，=0代表前后位置，=-1带表在后面。
        // 若出现已经=-1的情况下，在后面又要求=1，会形成环，则返回null。。
        //2、这样就形成了一个图，然后进行拓扑排序即可。
        // 先找出所有入度为0的点，放在前面，然后去掉这些点和相应的边.如此得到最终结果

        //构建拓扑排序
        // 邻接矩阵的第i行的数组元素值为1的个数表示顶点i的出度，第i列的数组元素值为1表示顶点i的入度。


        indegree = new int[n];
        for (int i = 0; i < n; i++) {
            indegree[i] = 0;
            for (int j = 0; j < n; j++) {
                map[i][j] = 0;
            }
        }

        topSort1();
        while (!stack.isEmpty())
        {
            list.add(allMembers.get(stack.pollLast()));
        }

        return list;
    }


    private static void topSort1() {
        int count = 0; //判断有无回路（是否成环）
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                stack.addFirst(i);
                indegree[i] = -1;
            }
        }
        while (!stack.isEmpty()) {
            int p = stack.removeFirst();
            System.out.print(p + " ");
            count++;
            for (int j = 0; j < n; j++) {
                if (map[p][j] == 1) {
                    map[p][j] = 0;
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        stack.addFirst(j);
                        indegree[j] = -1;
                    }
                }
            }
        }
        System.out.println();
        if(count <n) System.out.println("The network has a cycle!"); //当输出的顶点数小于图中的顶点数时，输出有回路信息
        else  System.out.println("The network has not a cycle!");
    }

}


class RequestItem
{
    public String member;
    public boolean standFront; //true表示要排在这个人的前面，false表示要排在这个人的后面
}
class Request
{
    public String owner;    //那个人提出的要求
    List<RequestItem> requestItems;    //他要排在哪些人的前面，哪些人的后面
}