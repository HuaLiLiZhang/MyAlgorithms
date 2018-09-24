package InterviewDirectory.JD2019_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/9.
 */
public class Main1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        ArrayList<String> re = new ArrayList<>();
        while (--T>=0)
        {
            String s = sc.nextLine();
            String[]str = s.split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            ArrayList<Edge> list = new ArrayList<>();
            for(int i = 0;i<M;i++)
            {
                String s0 = sc.nextLine();
                String[]str0 = s0.split(" ");
                int x = Integer.parseInt(str0[0]);
                int y = Integer.parseInt(str0[1]);
                list.add(new Edge(""+x, ""+y));
            }

            //用于存放重新排序之后的结果集合
            ArrayList<Edge> newlist = new ArrayList<>();

            Edge e1 = list.get(0);
            list.remove(0);
            newlist.add(e1);
            String citing = e1.getCITING();
            String cited = e1.getCITED();

            //第一步，选取第一条边，取得所有与该边相连的所有连边，add到newlist
            for(int i =0;i<list.size();i++){
                if(list.get(i).isExistOf(citing)){
                    newlist.add(0,list.get(i));
                    list.remove(i);
                    i--;
                }
                else if(list.get(i).isExistOf(cited)){
                    newlist.add(list.get(i));
                    list.remove(i);
                    i--;
                }
            }

            //System.out.println("newlist");
            //for (Edge edge : newlist) {
            //    System.out.println(edge.toString());
            //}
            //
            //System.out.println("list");
            //for (Edge edge : list) {
            //    System.out.println(edge.toString());
            //}

            //第二步，从剩余边中依次进行判断，有序加入到newlist中
            int point = 0;//设置一个指针，指明当前进行判断的记录
            while(!list.isEmpty()){
                e1 = list.get(point);
                citing = e1.getCITING();
                cited = e1.getCITED();
                for(int i =0 ;i<newlist.size();i++){
                    //如果list(point)与newlist中的记录是相连的
                    if(newlist.get(i).isExistOf(citing)||newlist.get(i).isExistOf(cited)){
                        //相连的记录在newlist的头部，直接在头部插入
                        if(i == 0){
                            newlist.add(0,e1);
                            list.remove(point);
                            point=-1;//注意指针要回归到-1
                            break;
                        }
                        //相连的记录在newlist的尾部，直接在尾部插入
                        else if(i == newlist.size()-1){
                            newlist.add(e1);
                            list.remove(point);
                            point=-1;//注意指针要回归到-1
                            break;
                        }
                        //相连的记录不在头尾的，先调整顺序至于尾部，再插入
                        else{
                            newlist.add(newlist.get(i));
                            newlist.remove(i);

                            newlist.add(e1);
                            list.remove(point);
                            point=-1;//注意指针要回归到-1
                            break;
                        }
                    }
                }
                point++;//指针下移，判断下一个结点
            }

            //System.out.println("newlist");
            //for (Edge edge : newlist) {
            //    System.out.println(edge.toString());
            //}
            //
            //System.out.println("list");
            //for (Edge edge : list) {
            //    System.out.println(edge.toString());
            //}

            if(newlist.get(0).getCITED().equals(newlist.get(newlist.size()-1).getCITED()))
                re.add("Yes");
            else
                re.add("No");

//2
//5 7
//1 3
//1 5
//2 3
//2 5
//3 4
//4 5
//3 5
//4 3
//1 2
//2 3
//3 4
//yes
//no
        }
        for(String sss:re)
            System.out.println(sss);

    }
}
class Edge {
    private String CITING;
    private String CITED;

    public Edge(String CITING,String CITED){
        this.CITING = CITING;
        this.CITED = CITED;
    }

    public String getCITING() {
        return CITING;
    }

    public void setCITING(String cITING) {
        CITING = cITING;
    }

    public String getCITED() {
        return CITED;
    }

    public void setCITED(String cITED) {
        CITED = cITED;
    }

    public boolean equals(Edge obj) {
        // TODO Auto-generated method stub
        String citing = obj.getCITING();
        String cited = obj.getCITED();
        if(CITING.equals(citing)&&CITED.equals(cited))
            return true;
        else
            return false;

    }

    public boolean isExistOf(String str){
        if(str.equals(CITING)||str.equals(CITED))
            return true;
        else
            return false;
    }

    public boolean isLinked(Edge e){
        if(e.getCITING().equals(CITING)||e.getCITING().equals(CITED)||
                e.getCITED().equals(CITING)||e.getCITED().equals(CITED))
            return true;
        else
            return false;
    }

    public String toString(){
        return CITING +" -> "+CITED;
    }
}