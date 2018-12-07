package GreedySelect;

public class ActionOrder {
    public int greedySelect(int[] s,int[] f,boolean[] a){
        int n = s.length-1;
        a[1] = true;
        int j = 1;
        int count = 1;
        for(int i = 2;i<=n;i++){
            if(s[i] >= f[j]){
                a[i] = true;
                j = i;
                count++;
            }else{
                a[i] = false;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] s = {-1,1,3,0,5,3,5,6,8,8,2,12};
        int[] f = {-1,4,5,6,7,8,9,10,11,12,13,14};
        boolean[] a = new boolean[s.length];
        ActionOrder ac = new ActionOrder();
        int counts =   ac.greedySelect(s,f,a);
        System.out.println("活动集合中最大相容活动数量为："+counts);
        for (int i = 1; i <=s.length-1 ; i++) {
            if(a[i]){
                System.out.println("第"+i+"活动被选中,其开始时间是："+s[i]+",结束时间为："+f[i]);
            }
        }
    }
}
