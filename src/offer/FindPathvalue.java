package offer;

import sun.util.resources.cldr.ki.LocaleNames_ki;

import java.util.ArrayList;

/**
 * Created by huali on 2018/6/22.
 */
public class FindPathvalue {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        //if(root==null||(root.left==null&&root.right==null&&root.val!=target))
        //    return arr;
        arr = findpath(root, target, list ,arr);

        return arr;
    }

    public ArrayList<ArrayList<Integer>> findpath(TreeNode root, int target,
                                                  ArrayList<Integer> list,
                                                  ArrayList<ArrayList<Integer>> arr)
    {
        if(root ==null)
        {
            return arr;
        }

        list.add(root.val);
        target -= root.val;
        if(target==0&&root.left==null&&root.right==null)
            arr.add(new ArrayList<Integer>(list));
        findpath(root.left, target, list,arr);
        findpath(root.right, target, list,arr);
        list.remove(list.size()-1);
        return arr;
    }
}