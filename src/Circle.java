public class Circle implements IShape{
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

    public Circle(){

    }

    public Circle(double a,double b){
        this.a = a;
        this.b = b;
    }
    public double area(){
        return 0;
    }
    public double perimeter(){
        return 0;
    }
    public double distance(){
        return 0;
    }
    public void move(){
        System.out.print("a");
    }
    public void zoom(){
        System.out.print("a");
    }
}
