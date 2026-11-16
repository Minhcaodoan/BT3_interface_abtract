public interface IShape {
    double area();
    double perimeter();
    double distance(IShape other);
    void move(double dx, double dy);
    void rotate(double angle);
    void zoom(double ratio);
    double getCenterX();
    double getCenterY();
}
