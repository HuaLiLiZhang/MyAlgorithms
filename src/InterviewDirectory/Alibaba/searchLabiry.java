package InterviewDirectory.Alibaba;

/**
 * Created by huali on 2018/4/14.
 */
public class searchLabiry {
//    链接：https://www.nowcoder.com/questionTerminal/0b09751acbb64f9d8c63706052748cd4
//来源：牛客网
//
//学校图书馆共有 300 万册图书，想统计其中 Computer ， Science ，计算机，
// 科学这几个词出现的次数，并按照自然年度分类，
// 如 2016 年出版的书籍中这几个词各自出现的次数， 2015 年······依次类推。


//将每本书都存在hdfs里作为一个文件，文件名为 时间（4位年份）+书的id+书的名称。
//使用mapreduce进行运算，map输出为<日期，computer次数；science次数；计算机次数；科学次数>,
// reduce输出同样，不过作为value的字符串中的次数为总次数。
//   应该考虑的是粪桶原理，或者大数据以及空间限制。



}