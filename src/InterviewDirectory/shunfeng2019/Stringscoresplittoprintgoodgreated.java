package InterviewDirectory.shunfeng2019;

import java.util.*;

/**
 * Created by huali on 2018/9/17.
 */
public class Stringscoresplittoprintgoodgreated {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Map<Integer,List<String> > map = new HashMap<>();
        //while (sc.hasNext())
        //{
        //    String s = sc.nextLine();
        //    if(s.equals("end"))
        //        break;
        //    String [] step = s.split(" ");
        //    return;
        //
        //
        //}
    //NO.	100M	800M	JUMP	BALL
        //6789	GREAT	GOOD	FAIL	GREAT
        //0002	GREAT	GOOD	GOOD	GOOD
        //8901	GREAT	GOOD	GOOD	GOOD
        //5678	GOOD	GREAT	GREAT	GREAT
        //7890	GOOD	GREAT	GREAT	GOOD
        List<String> list = new ArrayList<>();
        list.add("NO.\t100M\t800M\tJUMP\tBALL");
        list.add("6789\tGREAT\tGOOD\tFAIL\tGREAT");
        list.add("0002\tGREAT\tGOOD\tGOOD\tGOOD");
        list.add("8901\tGREAT\tGOOD\tGOOD\tGOOD");
        list.add("5678\tGOOD\tGREAT\tGREAT\tGREAT");
        list.add("7890\tGOOD\tGREAT\tGREAT\tGOOD");
        for(String s0 : list)
            System.out.println(s0);
        //System.out.println(" "+'b'+1);
    }
}