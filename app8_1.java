class Person{
    protected String name;
    protected int age;
    static int count;
    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
        this.count++;
    }
    protected void show()
    {
        System.out.println("the name:"+this.name+"the age:"+this.age);
    }
}
class Student extends Person{
    private String department;
    static int count;
    public Student(String name,int age,String dep)
    {
        super(name,age);
        department=dep;
        this.count++;
    }
    protected void show()
    {
        System.out.println("the department:"+department+'\n'+"the age:"+super.age);
        System.out.println("the super count:"+super.count+'\n'+" the sub count:"+this.count);
    }
    public void subshow()
    {
        System.out.println("im in the sub");
    }
}
public class app8_1 {
    public static void main(String[] agrs){
        Person per1=new Person("L jc", 19);
        Person per2=new Student("Wang yongtao", 24, "CS");
        per1.show();
        System.out.println(per2.getClass().getName()+" "+per2.getClass().getSuperclass().getName());
        per2.show();
    }
}