package InterviewDirectory.pingduoduo2019;

/**
 * Created by huali on 2018/8/13.
 */

//
//题目四: 变成靓号的最少代价
//
//题意简单，号码长度为n，每个数字范围是0-9，同样的数字的个数大于等于k，则为靓号，找出成本最小且字典序最小的靓号。
//代码如下，因为是最后一道，写的有些仓促，代码有点不忍直视。主要思路就是首先用number数组记录每个数字出现的次数，然后遍历10种可能，就是将每个数字为靓号，共10种可能。用anscost和ansstr记录结果，然后每个数字比较字典序。重点在于如何修改，才能使得成本最低。
//比如，对于要使得7的个数大于等于k，那么首先进行广度优先遍历，dif = 1..9，即往7的左右两边遍历，显然先替换大于7的会使得字典序更小，因此先7+dif，再计算7-dif，直到数字7的个数==k，然后记录原号码中每个数字中有多少个数要替换为7。然后从左往右替换大于7的数字，
//再从右往左替换小于7的数字即可。
public class beautyNUmber {
//    C++

//#include<iostream>
//#include<queue>
//#include<string>
//#include<algorithm>
//#include<sstream>
//using namespace std;
//int main(){
// vector<int> number(10, 0);
// vector<int> times(10, 0);
// string ansstr;
//int ansi;
//int n, k;
//int anscost = -1;
//string str;
//bool flag = false;
//cin>>n>>k;
//char c;
//for(int i = 0; i < n; i++){
//cin>>c;
//str.push_back(c);
//number[c-'0']++;
//if(number[c-'0'] >= k){
//flag = true;
//}
//}
//if(flag) cout<<str<<endl;
//else{
//for(int i = 0; i <= 9; i++){
//for(int ii = 0; ii <= 9; ii++) times[ii] = 0;
//if(number[i] == 0) continue;
//int tmpcost = 0;
//int t = number[i];
//int dif = 1;
//while(t < k){
//if(i+dif <= 9){
//if(number[i+dif] + t >= k){
//times[i+dif] = k-t;
//tmpcost += (dif)*(k-t);
//break;
//}
//else{
//times[i+dif] = number[i+dif];
//tmpcost += (dif)*number[i+dif];
//t += number[i+dif];
//}
//}
//if(i-dif >= 0){
//if(number[i-dif] + t >= k){
//times[i-dif] = k-t;
//tmpcost += dif*(k-t);
//break;
//}
//else{
//times[i-dif] = number[i-dif];
//tmpcost += number[i-dif];
//t += number[i-dif];
//}
//}
//dif++;
//}
//string sstr(str);
//for(int j = 0; j < sstr.size(); j++){
//int ttt = sstr[j]-'0';
//if(sstr[j]-'0' > i && times[(int)(sstr[j]-'0')] > 0){
//times[ttt] = times[(int)(sstr[j]-'0')]- 1;
//sstr[j] = '0'+i;
//}
//}
//cout<<"  "<<endl;
//for(int j = sstr.size()-1; j >= 0; j--){
//if(sstr[j]-'0' < i && times[(int)(sstr[j]-'0')] > 0){
//times[(int)(sstr[j]-'0')]--;
//sstr[j] = '0'+i;
//}
//}
//if(anscost == -1){
//anscost = tmpcost;
//ansi = i;
//ansstr = sstr;
//}
//else if(anscost > tmpcost){
//ansi = i;
//anscost = tmpcost;
//ansstr = sstr;
// 
//}
//else if(anscost == tmpcost){
//anscost = tmpcost;
//if(ansstr > sstr){
//ansi = i;
//ansstr = sstr;
//}
//}
//}
//cout<<anscost<<endl;
//cout<<ansstr<<endl;
//}
// 
//}
}