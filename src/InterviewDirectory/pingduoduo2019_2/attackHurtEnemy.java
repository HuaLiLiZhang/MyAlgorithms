package InterviewDirectory.pingduoduo2019_2;

import java.util.Scanner;

/**
 * Created by huali on 2018/8/30.
 */
public class attackHurtEnemy {
    //攻击敌人，敌人有初试血量HP，每一次回合可以选择聚力或攻击中一个，
    //聚力：会提高你下一哥回合的伤害
    //攻击：会对敌人造成一定的伤害，如果你上一个回合使用了聚力，那么这一个回合会对敌人造成BufferedAttack的伤害
    //否则，会造成normalAttack的伤害。
    //



    //思路：
    //使用一次攻击，直接减少血量，下一次可以再次使用攻击，也可以使用聚力，
    //若此次使用聚力攻击，当前敌人血量不减，下一回合才会血量减少BufferedAttack，需要两个回合。
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int [] arr= new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

//13 3 5
//5
        //System.out.println((float) 13/3);  //5
        if(arr[1]*2>=arr[2])
            System.out.println((int) Math.ceil((float)arr[0]/arr[1]));
        else {
            int resHp = arr[0];
            int num = 0;
            num = (int)Math.floor((float)arr[0]/arr[2]);
            resHp = arr[0] - num*arr[2];

            num*=2;
            while (resHp>0)
            {
                resHp-=arr[1];
                num+=1;
            }
            System.out.println((int) num);
        }

        //int [] temp = {0, 1};
        //int ncount = getnum(arr, temp,0);
        //int [] temp1 = {1, 0};
        //int bcount = getnum(arr, temp1,0);
        //System.out.println(Math.min(ncount,bcount));
    }

    //private static int getnum(int[] arr, int[] temp,int count) {
    //    if(arr[0]==0)
    //        return count;
    //    if(temp[0]==0)
    //    {
    //        arr[0]=arr[0]-arr[1];
    //        temp[0] = 1;
    //        count  = getnum(arr,temp, count)+1;
    //    }
    //    else
    //    {
    //        //if(temp[1])
    //    }
    //    return count;
    //
    //}

//13 2 5
//6
}