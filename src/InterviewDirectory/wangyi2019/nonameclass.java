package InterviewDirectory.wangyi2019;

/**
 * Created by huali on 2018/8/11.
 */
public class nonameclass {
    public static void main(String[] args)
    {
        Pracel pracel = new Pracel();
        Contents c = pracel.contents();
    }
}
interface Contents
{
    int value();
}
class Pracel{
    public Contents contents(){
        return new Contents() {
            private int i = 42;
            @Override
            public int value() {
                return i;
            }
        };
    }
}