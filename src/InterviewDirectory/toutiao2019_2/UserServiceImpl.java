package InterviewDirectory.toutiao2019_2;

/**
 * Created by huali on 2018/8/27.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("保存用户信息成功");
    }

    @Override
    public int select() {
        System.out.println("查询用户信息成功");
        return 10;
    }
}