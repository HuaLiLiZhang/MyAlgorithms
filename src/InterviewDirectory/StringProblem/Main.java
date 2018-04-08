package InterviewDirectory.StringProblem;


/**
 * Created by huali on 2018/4/4.
 */
public class Main {
    public static void main(String []args)
    {
        //System.out.println(Integer.MIN_VALUE/10);
        //System.out.println(Integer.MIN_VALUE%10);
        //
        //String a = "123";
        //String b = "312";
        //isRotation is = new isRotation();
        //boolean rotation  = is.isrotation(b, a);
        //System.out.println(rotation);

        //char[] crr = {'2','1','0','4','3','9','6','1','a'};
        //strtoint hep = new strtoint();
        //boolean is = hep.isUnique2(crr);
        //System.out.println(is);
        //System.out.println(Arrays.toString(crr));

        //String[] strs = {"a","b",null, "b",null ,"c"};
        //int index = new strGetIndex().getIndex(strs, "d");
        //System.out.println(index);

        //String str= "A1B21C";
        //addLeastchar_toPalindrome1 palindrome1 = new addLeastchar_toPalindrome1();
        //String rel_str = palindrome1.getPalindrom1(str);
        //System.out.println(rel_str);

        //String str= "A1BC22DE1F";
        //String sp = "121";
        //System.out.println(new addLeastchar_toPalindrome1().getPalindrome2(str,sp));


        //String str = "()(()()(";
        //System.out.println(new MaxLength().maxlength(str));

        //String str = "48*((70-65)-43)+8*1";
        //System.out.println(new str_getValue().getValue(str));

        //Integer a = 1;
        //Integer b = 2;
        //Integer c = 3;
        //Integer d = 3;
        //Integer e = 321;
        //Integer f = 321;
        //Long g = 3L;
        //System.out.println(c==d);  //true
        //System.out.println(e==f);  //false
        //System.out.println(c==(a+b));  //true
        //System.out.println(c.equals(a+b));  //true
        //System.out.println(g==(a+b));  //true
        //System.out.println(g.equals(a+b));  //false

        //String[] strs = {"abc","ab","be"};
        //System.out.println(new LowestString().lowestString(strs));

        //String str = "abcabefg";
        //int num = new MaxUnique().maxunique(str);
        //System.out.println(num);


        String str= "aaAACDEcBCg";
        pointNewChar po = new pointNewChar();
        System.out.println(po.pointnewchar1(str,7));
        System.out.println(po.pointnewchar1(str,4));
        System.out.println(po.pointnewchar1(str,10));

    }
}