class Triangle implements IShape {

    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = new Point(p1.getX(), p1.getY());
        this.p2 = new Point(p2.getX(), p2.getY());
        this.p3 = new Point(p3.getX(), p3.getY());
    }

    // Getter và Setter
    public Point getP1() {
        return new Point(p1.getX(), p1.getY());
    }

    public Point getP2() {
        return new Point(p2.getX(), p2.getY());
    }

    public Point getP3() {
        return new Point(p3.getX(), p3.getY());
    }

    public void setP1(Point p) {
        p1 = new Point(p.getX(), p.getY());
    }

    public void setP2(Point p) {
        p2 = new Point(p.getX(), p.getY());
    }

    public void setP3(Point p) {
        p3 = new Point(p.getX(), p.getY());
    }

    private double length(Point a, Point b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double perimeter() {
        return length(p1, p2)
                + length(p2, p3)
                + length(p3, p1);
    }

    @Override
    public double area() {
        double a = length(p1, p2);
        double b = length(p2, p3);
        double c = length(p3, p1);

        double s = perimeter() / 2;

        return Math.sqrt(Math.max(0,
                s * (s - a) * (s - b) * (s - c)));
    }

    @Override
    public double distance(IShape other) {
        double dx = getCenterX() - other.getCenterX();
        double dy = getCenterY() - other.getCenterY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
        p3.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        double cx = getCenterX();
        double cy = getCenterY();

        rotatePoint(p1, cx, cy, angle);
        rotatePoint(p2, cx, cy, angle);
        rotatePoint(p3, cx, cy, angle);
    }

    private void rotatePoint(Point p, double cx, double cy, double angle) {
        double rad = Math.toRadians(angle);

        double x = p.getX() - cx;
        double y = p.getY() - cy;

        double newX = x * Math.cos(rad) - y * Math.sin(rad);
        double newY = x * Math.sin(rad) + y * Math.cos(rad);

        p.setX(newX + cx);
        p.setY(newY + cy);
    }

    @Override
    public void zoom(double ratio) {
        if (ratio <= 0) return;

        double cx = getCenterX();
        double cy = getCenterY();

        scalePoint(p1, cx, cy, ratio);
        scalePoint(p2, cx, cy, ratio);
        scalePoint(p3, cx, cy, ratio);
    }

    private void scalePoint(Point p, double cx, double cy, double ratio) {
        p.setX(cx + (p.getX() - cx) * ratio);
        p.setY(cy + (p.getY() - cy) * ratio);
    }

    @Override
    public double getCenterX() {
        return (p1.getX() + p2.getX() + p3.getX()) / 3;
    }

    @Override
    public double getCenterY() {
        return (p1.getY() + p2.getY() + p3.getY()) / 3;
    }

    @Override
    public String toString() {
        return String.format(
                "Triangle(%s, %s, %s)", p1, p2, p3
        );
    }
}