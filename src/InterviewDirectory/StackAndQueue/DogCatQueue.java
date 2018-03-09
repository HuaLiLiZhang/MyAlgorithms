package InterviewDirectory.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huali on 2018/3/9.
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> CatQ;
    private long count;

    public DogCatQueue()
    {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.CatQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }
    public void add(Pet pet)
    {
        if(pet.getPetType().equals("dog"))
            this.dogQ.add(new PetEnterQueue(pet,this.count++));
        else if(pet.getPetType().equals("cat"))
            this.CatQ.add(new PetEnterQueue(pet,this.count++));
        else
            throw new RuntimeException("err,not dog or cat");
    }

    public Pet pollAll()
    {
        if(!this.dogQ.isEmpty()&&!this.CatQ.isEmpty())
        {
            if(this.dogQ.peek().getCount()<this.CatQ.peek().getCount())
            {
                return this.dogQ.poll().getPet();
            }else
            {
                return this.CatQ.poll().getPet();
            }
        }else if(!this.dogQ.isEmpty())
        {
            return this.dogQ.poll().getPet();
        }
        else if(!this.CatQ.isEmpty())
        {
            return this.CatQ.poll().getPet();
        }
        else
        {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Dog PollDog()
    {
        if(!this.isDogQueueEmpty())
        {
            return (Dog) this.dogQ.poll().getPet();
        }
        else
        {
            throw new RuntimeException("err, dog queue is empty!");
        }
    }
    public Cat PollCat()
    {
        if(!this.isCatQueueEmpty())
        {
            return (Cat) this.CatQ.poll().getPet();
        }
        else
        {
            throw new RuntimeException("err, dog queue is empty!");
        }
    }
    public  boolean isEmpty()
    {
        return this.dogQ.isEmpty()&&this.CatQ.isEmpty();
    }
    public boolean isDogQueueEmpty()
    {
        return this.dogQ.isEmpty();
    }
    public boolean isCatQueueEmpty()
    {
        return this.CatQ.isEmpty();
    }
}