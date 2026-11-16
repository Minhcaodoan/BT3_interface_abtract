class Point implements IShape {

    private double x;
    private double y;

    // Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter và Setter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double distance(IShape other) {
        double dx = x - other.getCenterX();
        double dy = y - other.getCenterY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void rotate(double angle) {
        double rad = Math.toRadians(angle);

        double newX = x * Math.cos(rad) - y * Math.sin(rad);
        double newY = x * Math.sin(rad) + y * Math.cos(rad);

        x = newX;
        y = newY;
    }

    @Override
    public void zoom(double ratio) {
        if (ratio <= 0) return;

        x *= ratio;
        y *= ratio;
    }

    @Override
    public double getCenterX() {
        return x;
    }

    @Override
    public double getCenterY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Point(x=%.2f, y=%.2f)", x, y);
    }
}