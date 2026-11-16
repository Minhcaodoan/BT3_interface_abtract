import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Tạo danh sách hình ngẫu nhiên
    public static ArrayList<IShape> createShapes(int n) {

        ArrayList<IShape> shapes = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < n; i++) {

            int type = random.nextInt(5);

            // Tọa độ ngẫu nhiên
            double x = random.nextInt(20) - 10;
            double y = random.nextInt(20) - 10;

            // Kích thước ngẫu nhiên
            double w = random.nextInt(10) + 1;
            double h = random.nextInt(10) + 1;

            switch (type) {

                case 0:
                    // Point
                    shapes.add(new Point(x, y));
                    break;

                case 1:
                    // Circle
                    shapes.add(new Circle(x, y, w));
                    break;

                case 2:
                    // Line
                    shapes.add(new Line(
                            new Point(x, y),
                            new Point(x + w, y + h)
                    ));
                    break;

                case 3:
                    // Triangle
                    shapes.add(new Triangle(
                            new Point(x, y),
                            new Point(x + w, y),
                            new Point(x, y + h)
                    ));
                    break;

                case 4:
                    // Rectangle
                    shapes.add(new Rectangle(x, y, w, h));
                    break;
            }
        }

        return shapes;
    }

    // Hiển thị danh sách hình
    public static void displayShapes(ArrayList<IShape> shapes) {

        System.out.println("\n========== DANH SACH HINH ==========");

        for (int i = 0; i < shapes.size(); i++) {

            IShape s = shapes.get(i);

            System.out.println("\nHinh thu " + (i + 1));
            System.out.println(s);

            System.out.printf("Dien tich: %.2f%n", s.area());
            System.out.printf("Chu vi: %.2f%n", s.perimeter());
        }
    }

    // Tính tổng diện tích
    public static double totalArea(ArrayList<IShape> shapes) {

        double sum = 0;

        for (IShape s : shapes) {
            sum += s.area();
        }

        return sum;
    }

    // Tính tổng chu vi
    public static double totalPerimeter(ArrayList<IShape> shapes) {

        double sum = 0;

        for (IShape s : shapes) {
            sum += s.perimeter();
        }

        return sum;
    }

    // Tìm hình có diện tích lớn nhất
    public static IShape findMaxArea(ArrayList<IShape> shapes) {

        if (shapes.isEmpty()) return null;

        IShape max = shapes.get(0);

        for (IShape s : shapes) {

            if (s.area() > max.area()) {
                max = s;
            }
        }

        return max;
    }

    // Tìm hình có diện tích nhỏ nhất
    public static IShape findMinArea(ArrayList<IShape> shapes) {

        if (shapes.isEmpty()) return null;

        IShape min = shapes.get(0);

        for (IShape s : shapes) {

            if (s.area() < min.area()) {
                min = s;
            }
        }

        return min;
    }

    // Phóng to tất cả các hình
    public static void zoomShapes(ArrayList<IShape> shapes, double ratio) {

        if (ratio <= 0) {
            System.out.println("Ty le phai lon hon 0!");
            return;
        }

        for (IShape s : shapes) {
            s.zoom(ratio);
        }
    }

    // Chương trình chính
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Tạo danh sách hình ngẫu nhiên
        System.out.print("Nhap so luong hinh: ");

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("So luong hinh phai lon hon 0!");
            sc.close();
            return;
        }

        ArrayList<IShape> shapes = createShapes(n);

        // 2. Hiển thị danh sách hình
        displayShapes(shapes);

        // 3. Tính tổng diện tích và chu vi
        System.out.println("\n========== THONG KE ==========");

        System.out.printf(
                "Tong dien tich: %.2f%n",
                totalArea(shapes)
        );

        System.out.printf(
                "Tong chu vi: %.2f%n",
                totalPerimeter(shapes)
        );

        // 4. Tìm hình có diện tích lớn nhất và nhỏ nhất
        IShape max = findMaxArea(shapes);
        IShape min = findMinArea(shapes);

        System.out.println("\n========== HINH CO DIEN TICH LON NHAT ==========");

        System.out.println(max);
        System.out.printf("Dien tich: %.2f%n", max.area());

        System.out.println("\n========== HINH CO DIEN TICH NHO NHAT ==========");

        System.out.println(min);
        System.out.printf("Dien tich: %.2f%n", min.area());

        // 5. Phóng to các hình
        System.out.print("\nNhap ty le zoom: ");

        double ratio = sc.nextDouble();

        zoomShapes(shapes, ratio);

        System.out.println("\n========== DANH SACH SAU KHI ZOOM ==========");

        displayShapes(shapes);

        sc.close();
    }
}