class Rectangle implements IShape {

    private double centerX;
    private double centerY;
    private double width;
    private double height;
    private double angle;

    public Rectangle(double centerX, double centerY,
                     double width, double height) {

        this.centerX = centerX;
        this.centerY = centerY;
        this.width = Math.max(0, width);
        this.height = Math.max(0, height);
        this.angle = 0;
    }

    // Getter và Setter
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getAngle() {
        return angle;
    }

    public void setWidth(double width) {
        if (width >= 0) this.width = width;
    }

    public void setHeight(double height) {
        if (height >= 0) this.height = height;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
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
        this.angle += angle;
    }

    @Override
    public void zoom(double ratio) {
        if (ratio <= 0) return;

        width *= ratio;
        height *= ratio;
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
                "Rectangle(center=(%.2f, %.2f), width=%.2f, height=%.2f, angle=%.2f)",
                centerX, centerY, width, height, angle
        );
    }
}