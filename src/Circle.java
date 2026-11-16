class Circle implements IShape {

    private double centerX;
    private double centerY;
    private double radius;

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = Math.max(0, radius);
    }

    // Getter và Setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius >= 0) {
            this.radius = radius;
        }
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double distance(IShape other) {
        double dx = centerX - other.getCenterX();
        double dy = centerY - other.getCenterY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void move(double dx, double dy) {
        centerX += dx;
        centerY += dy;
    }

    @Override
    public void rotate(double angle) {
        // Xoay hình tròn quanh tâm không làm thay đổi hình.
    }

    @Override
    public void zoom(double ratio) {
        if (ratio > 0) {
            radius *= ratio;
        }
    }

    @Override
    public double getCenterX() {
        return centerX;
    }

    @Override
    public double getCenterY() {
        return centerY;
    }

    @Override
    public String toString() {
        return String.format(
                "Circle(center=(%.2f, %.2f), radius=%.2f)",
                centerX, centerY, radius
        );
    }
}