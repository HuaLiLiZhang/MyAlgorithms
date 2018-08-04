package InterviewDirectory.offerTwice;


/**
 * Created by huali on 2018/7/25.
 */
public class printMax1_Nbit {
    public static void main(String[] args)
    {
        int n = 3;
        char [] number = new char[n];
        for(int i = 0;i<n;i++)
        {
            number[i] = '0';
        }
        while (!increment(number))
        {
            print(number);
        }
    }

    private static boolean increment(char[] number) {
        boolean isoverflow = false;
        int ntakeover = 0;
        for(int i = number.length-1;i>=0;i--)
        {
            int sum = number[i]-'0'+ntakeover;
            if(i==number.length-1)
                sum++;
            if(sum>=10)
            {
                if(i==0)
                    isoverflow = true;
                else {
                    ntakeover=1;
                    sum -=10;
                    number[i] =  (char)('0'+sum);
                }
            }else
            {
                number[i] = (char)('0'+sum);
                break;
            }
        }
        return isoverflow;
    }

    private static void print(char[] number) {
        boolean isbegin0 = false;
        for(int i = 0;i< number.length;i++)
        {
            if(!isbegin0&&number[i]-'0'!=0)
                isbegin0 = true;
            if(isbegin0)
            {
                System.out.print(number[i]);
            }
        }
        System.out.print(" ");
    }


}