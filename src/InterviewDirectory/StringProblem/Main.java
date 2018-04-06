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

        char[] crr = {'2','1','0','4','3','9','6','1','a'};
        //strtoint hep = new strtoint();
        //boolean is = hep.isUnique2(crr);
        //System.out.println(is);
        //System.out.println(Arrays.toString(crr));

        String[] strs = {"a","b",null, "b",null ,"c"};
        int index = new strGetIndex().getIndex(strs, "d");
        System.out.println(index);
    }
}