
public class Main
{
    public static void main(String[] args)
    {
        int a = 2;
        int b = 3;

        Calculator c = new Calculator();

        System.out.println(c.add(a,b));
        System.out.println(c.subtract(b,a));
    }
}