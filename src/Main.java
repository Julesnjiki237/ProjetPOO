public class Main {
    public static void main(String[] args) {

        Point p = new Point(1, 2);

        // Tests des différentes fonctionnalités
        Rectangle r = new Rectangle(p, 2, 3);
        SlantedRectangle s = new SlantedRectangle(p, 2, 3, Math.PI/4); // 45 degrés

        System.out.println("Surface rectangle normal: " + r.surface());
        System.out.println("Surface rectangle incliné: " + s.surface());

        s.rotate(Math.PI/4); // Rotation supplémentaire de 45 degrés
        System.out.println("Nouvel angle: " + s.getAngle());
    }
}