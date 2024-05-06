import java.text.DecimalFormat;
abstract class Shape
{
    protected String name;
    public Shape(String name){
        this.name=name;
        System.out.println("the name of shape is:"+this.name);
    }
    abstract double area();
    abstract double length();
}
class Circle extends Shape
{   
    private float pi=3.14f;
    private double radius;
    public Circle(String name,double r)
    {
        super(name);
        radius=r;
    }
    public double area()
    {
        return pi*radius*radius;
    }
    public double length()
    {
        return 2*pi*radius;
    }
}
class Rectangle extends Shape
{
    private double l;
    private double w;
    private double h=1;//假设要用这块方形为底做一个方形水箱，实验是否能用父类对象指向子类对象调用volunm();
    public Rectangle(String name,double l, double w)
    {
        super(name);
        this.l=l;
        this.w=w;
    }
    public double area()
    {
        return l*w;
    }
    public double length()
    {
        return 2*(l+w);
    }
    public double volumn()
    {
        return 1*this.area();
    }
}
public class app8_11 {
    public static void main(String[] args) {
        Shape cir1=new Circle("c1", 2.0);
        Shape rec1=new Rectangle("r1", 3.0, 2.0);
        DecimalFormat df=new DecimalFormat("0.00");
        System.out.println("the area of cir1 is:"+df.format(cir1.area()));
        System.out.println("the length of the cir1 is:"+df.format(cir1.length()));
        System.out.println("the area of the rec1 is:"+df.format(rec1.area()));
        System.out.println("the length of the rec1 is:"+df.format(rec1.length()).toString());
        //System.out.println("是否能通过父类调用”非覆盖父类“类型的子类方法："+rec1.volunm());
        //结果是不能，会显示volunm()在shape()中未定义；下面试试定义子类类型指向子类类型的rec2
        Rectangle rec2=new Rectangle("r2",4.0,3.0);
        System.out.println("是否能用子类指向子类的对象调用volunm(),约等于对比实验。如果能调用则输出rec2的体积:"+df.format(rec2.volumn()));
        //此时显示结果为12，能正常使用子类中volunm()函数这说明”父类的对象声明指向子类对象“所产生的对象只能使用”父类中的方法“或者“在子类中被覆盖的父类方法(也就是方法名还是只会出现父类中的方法名)”
        //另外这说明”父类对象指向子类对象，如：superclassname c1=new subclassname()“的方法和abstract很搭配，这样你未来需要的都在abstract类中声明abstract方法，不需要的别人另外加在子类中也反正用不了
        //如果真需要使用子类中的特别函数，就请用“子类对象指向子类，如:subclassname c1=new subclassname()
    }
    
}