class Line implements IShape {

    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = new Point(p1.getX(), p1.getY());
        this.p2 = new Point(p2.getX(), p2.getY());
    }

    // Getter và Setter
    public Point getP1() {
        return new Point(p1.getX(), p1.getY());
    }

    public Point getP2() {
        return new Point(p2.getX(), p2.getY());
    }

    public void setP1(Point p1) {
        this.p1 = new Point(p1.getX(), p1.getY());
    }

    public void setP2(Point p2) {
        this.p2 = new Point(p2.getX(), p2.getY());
    }

    private double length(Point a, Point b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return length(p1, p2);
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
    }

    @Override
    public void rotate(double angle) {
        double cx = getCenterX();
        double cy = getCenterY();

        rotatePoint(p1, cx, cy, angle);
        rotatePoint(p2, cx, cy, angle);
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
    }

    private void scalePoint(Point p, double cx, double cy, double ratio) {
        p.setX(cx + (p.getX() - cx) * ratio);
        p.setY(cy + (p.getY() - cy) * ratio);
    }

    @Override
    public double getCenterX() {
        return (p1.getX() + p2.getX()) / 2;
    }

    @Override
    public double getCenterY() {
        return (p1.getY() + p2.getY()) / 2;
    }

    @Override
    public String toString() {
        return String.format("Line(%s -> %s)", p1, p2);
    }
}