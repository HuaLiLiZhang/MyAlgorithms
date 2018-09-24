package InterviewDirectory.beike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by huali on 2018/8/19.
 */
public class bag01bag {
    int[] price={40,42,25,12}; //每个东西的价格
    int[] weight={4,7,5,3};  //每个东西的重量
    int max=16;               //最多存储重量
    List<Produce> list=new ArrayList<Produce>();//存放商品的列表，按照价值从大到小排
    PriorityQueue<Bag> heap=new PriorityQueue<Bag>((a, b)->
    {return (b.maxPrice-a.maxPrice)==0?b.reWeight-a.reWeight:b.maxPrice-a.maxPrice;});//存放当前背包的状态
    List<Bag> result=new ArrayList<Bag>();//存放结果
    bag01bag()
    {
        for(int i=0;i<weight.length;i++)
        {
            Produce produce=new Produce(price[i],weight[i],i);
            list.add(produce);
        }
        Collections.sort(list,(a, b)->b.bw-a.bw);

        Bag root=new Bag(max);//起点状态
        getUpPrice(root,list);
        heap.add(root);
        while(!heap.isEmpty())
        {
            Bag temp=heap.poll();
            if(temp.i>=list.size()-1)
            {
                printAnswer(temp);
                break;
            }

            //不放入
            Bag notPut=new Bag(temp,temp.i+1);
            if(!notPut.boon)
            {
                getUpPrice(notPut, list);
                heap.add(notPut);
            }

            //放入
            Bag putIn=new Bag(temp,list.get(temp.i+1),temp.i+1);
            if(!putIn.boon)
            {
                getUpPrice(putIn, list);
                heap.add(putIn);
            }
        }
    }

    //获得最大价值
    private void getUpPrice(Bag tempBag,List<Produce> list)
    {
        int re=tempBag.reWeight;
        for(int i=tempBag.i+1;i<list.size();i++)
        {
            int temp=re-list.get(i).weight;
            if(temp>=0)
            {
                re=temp;
                tempBag.maxPrice+=list.get(i).price;
            }else
            {
                tempBag.maxPrice+=list.get(i).price/list.get(i).weight*re;
                break;
            }
        }
    }
    private void printAnswer(Bag temp)
    {
        for(int i=0;i<list.size();i++)
        {
            if(temp.stute.charAt(i)=='1')
                System.out.println("放入价值为"+list.get(i).price+",重量为 "+list.get(i).weight+"的商品");
        }
    }
    public static void main(String[] argc)
    {
        bag01bag test=new bag01bag();
    }
}
//定义背包类
class Bag
{
    int sumPrice;  //背包内的总价格
    int reWeight; //背包内的剩余
    int maxPrice;//最大价值
    int max;      //最大承载重量
    int i;        //当前商品的序列值
    boolean boon=false;//是否重量是否爆炸
    String stute;
    Bag father;   //前一个背包的状态
    Bag(){}
    //初始状态包
    Bag(int max)
    {
        father=null;
        sumPrice=0;
        reWeight=max;
        this.max=max;
        this.i=-1;
        stute="";
    }
    //构建一个不放入该项的包
    Bag(Bag father,int i)
    {
        sumPrice=father.sumPrice;
        reWeight=father.reWeight;
        maxPrice=father.sumPrice;
        max=father.max;
        this.i=i;
        stute=father.stute+"0";
        this.father=father;
    }
    //构建一个放入的包
    Bag(Bag father,Produce produce,int i)
    {
        sumPrice=father.sumPrice+produce.price;
        reWeight=father.reWeight-produce.weight;
        maxPrice=father.sumPrice+produce.price;
        if(reWeight<0)
            boon=true;
        max=father.max;
        this.i=i;
        stute=father.stute+"1";
        //maxPrice 到时候会由getUpPrice后期算出来的
        this.father=father;
    }
}
//定义商品类
class Produce
{
    int id=0;
    int price;
    int weight;
    int bw;
    Produce(){}
    Produce(int price,int weight,int id)
    {
        this.id=id;
        this.price=price;
        this.weight=weight;
        bw=price/weight;
    }
}