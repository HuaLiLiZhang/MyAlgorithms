package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/10.
 */
public class strMinLength {
    public int minLength1(String str1,String str2)
    {
        if(str1==null||str2==null||str1.length()<str2.length())
            //查找的str1串的长度要大于等于str2的长度
            return 0;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int [] map = new int[256];  //哈希表为map， key是char类型，value是int类型。
        // 每条记录的意义：对于key字符，str1字符目前欠str2字符串value 个。
        for(int i =0;i!=ch2.length;i++)
        {
            map[ch2[i]]++;  //欠着为正
        }
        int left = 0;  //str1(left, right),表示被框柱 的子串，left表示这个子串的左边界
        int right = 0;   //right代表str1倍框柱子串的右边界。初始值：right=0；
        int match = ch2.length;     //对于所有字符来说，str1[left, right]目前欠str2多少个。
        // 本例老说，match= 3；
        int minLen = Integer.MAX_VALUE;
        //最小包含子串的长度，初始值为32位整数最大值。
        while (right!=ch1.length)
        {
            map[ch1[right]]--;   //对于你每一个str1 中的字符，进来都要是的str2中的计数减去1，代表归还了一个。
            if(map[ch1[right]]>=0)  //剪完之后为0，说明减之前大于0，那么str1归还了1个‘a'，match也要减1.
            {
                match--;
            }
            if(match==0)//表示匹配完成，但是不知道是不是最短的子串，继续向后匹配，left向右移动。
            {
                while (map[ch1[left]]<0) //map[ch1[left]]<0说明str1拿回这个字符，也不会欠着str2
                    map[ch1[left++]]++;   //所以left++，map[ch1[left]]要++,
                // 当map[ch1[left]]=0时候，说明对str2刚刚好了。
                minLen = Math.min(minLen, right-left+1);  //此时计算较小的最短子串的长度
                map[ch1[left++]]++;  //map[ch1[left]]++，欠着str2
                match++;  //因为map[ch1[left]]<0，所以欠着str2，match++
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE?0:minLen;
    }
}