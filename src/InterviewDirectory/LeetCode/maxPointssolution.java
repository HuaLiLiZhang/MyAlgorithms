package InterviewDirectory.LeetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by huali on 2018/7/3.
 */
public class maxPointssolution {
    public int maxPoints(Point[] points) {
        if(points==null||points.length<=0)
            return 0;
        if(points.length<=2)
            return points.length;
        int ret = 0;
        for(int i=0;i<points.length;i++)
        {
            Map<Float, Integer> map = new HashMap<>();
            int dup = 0;
            int vet = 0;
            Point a = points[i];
            for(int j=0;j<points.length;j++)
            {
                if(i==j)
                    continue;
                Point b = points[j];
                if(a.x==b.x)
                {
                    if(a.y==b.y)
                        dup++;
                    else
                        vet++;
                }
                else
                {
                    float k = (float)(a.y-b.y)/(a.x-b.x);
                    if(!map.containsKey(k))
                        map.put(k,1);
                    else
                        map.replace(k,map.get(k)+1);
                }
            }
            int max = vet;
            for(float k:map.keySet())
            {
                max = Math.max(max, map.get(k));
            }
            ret = Math.max(ret,max+dup);
        }
        return ret;
    }

}
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
