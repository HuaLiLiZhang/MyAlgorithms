package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/9.
 */
public class PetEnterQueue {
    private Pet pet;
    private long count;
    //Pet :是用户原有的实例
    //count：实例的时间戳。
    public PetEnterQueue(Pet pet,Long count)
    {
        this.pet=pet;
        this.count=count;
    }
    public Pet getPet()
    {
        return this.pet;
    }
    public long getCount()
    {
        return this.count;
    }
    //public String getEnterPetType()
    //{
    //    return this.pet.getPetType();
    //}

}