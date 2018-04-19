package InterviewDirectory.huawei;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/19.
 */
public class playingCard {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        String[] left , right;
        String [] line;
        String nextLine, outString;
        while (sr.hasNext())
        {
            nextLine = sr.nextLine();
            if(nextLine.contains("joker JOKER"))
            {
                outString = "joker JOKER";
            }else {
                line = nextLine.split("-");
                left = line[0].split(" ");
                right = line[1].split(" ");

                if(left.length==right.length)
                {
                    if(count(left[0])>count(right[0]))
                        outString = line[0];
                    else
                        outString = line[1];
                }
                else if(left.length==4&&right.length!=4)
                {
                    outString = line[0];
                }else if(left.length!=4&&right.length==4){
                    outString = line[1];
                }else
                    outString = "ERROR";
            }
            System.out.println(outString);
        }
    }

    public static int count (String str)
    {
        return "345678910JQKA2jokerJOKER".indexOf(str);
    }
}