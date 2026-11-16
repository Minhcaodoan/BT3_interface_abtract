public class Rectangle implements IShape{
    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB(){
        return b;
    }

    public void setB(){
        this.b = b;
    }

    public Rectangle(){

    }

    public Rectangle(double a,double b){
        this.a = a;
        this.b = b;
    }
    public double area(){
        double s = a*b;
        return s;
    }
    public double perimeter(){
        double c = 2*(a+b);
        return c;
    }
    public double distance(){
        System.out.print("a");
        double a=2;
        return a;
    }
    public void move(){
        System.out.print("a");
    }
    public void zoom(){
        System.out.print("a");
    }
}
