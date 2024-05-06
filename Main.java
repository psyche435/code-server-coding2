public class Main{
    public static void main(String[] args){
    //主方法
    int[] a=new int[8];
    for(int i=0;i<a.length;i++)
    {
        a[i]=i;
    }
    for(int x:a)
    {
        System.out.println(x);
    }
    }
}