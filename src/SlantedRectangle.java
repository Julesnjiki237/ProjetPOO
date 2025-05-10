public class SlantedRectangle extends Rectangle {
    private double angle; // angle en radians

    public SlantedRectangle(Point bottomLeft, double width, double height) {
        this(bottomLeft, width, height, 0);
    }

    public SlantedRectangle(Point bottomLeft, double width, double height, double angle) {
        super(bottomLeft, width, height);
        this.angle = angle;
    }

    public void rotate(double deltaAngle) {
        this.angle += deltaAngle;
        // Normalisation de l'angle entre 0 et 2π
        this.angle = this.angle % (2 * Math.PI);
        if (this.angle < 0) this.angle += 2 * Math.PI;
    }

    @Override
    public boolean contains(Point p) {
        // Translation du point dans le repère du rectangle
        double translatedX = p.getX() - bottomLeft.getX();
        double translatedY = p.getY() - bottomLeft.getY();

        // Rotation inverse
        double cos = Math.cos(-angle);
        double sin = Math.sin(-angle);
        double rotatedX = translatedX * cos - translatedY * sin;
        double rotatedY = translatedX * sin + translatedY * cos;

        // Vérification dans le repère non incliné
        return rotatedX >= 0 && rotatedX <= width &&
                rotatedY >= 0 && rotatedY <= height;
    }

    @Override
    protected Point[] getCorners() {
        Point[] corners = super.getCorners();
        Point center = new Point(
                bottomLeft.getX() + width/2,
                bottomLeft.getY() + height/2
        );

        // Rotation de chaque coin autour du centre
        for (int i = 0; i < corners.length; i++) {
            corners[i] = rotatePoint(corners[i], center, angle);
        }
        return corners;
    }

    private Point rotatePoint(Point p, Point center, double angle) {
        double x = p.getX() - center.getX();
        double y = p.getY() - center.getY();

        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        double newX = x * cos - y * sin + center.getX();
        double newY = x * sin + y * cos + center.getY();

        return new Point(newX, newY);
    }

    @Override
    public String toString() {
        return String.format("SlantedRectangle[(%.2f,%.2f), w=%.2f, h=%.2f, angle=%.2f rad]",
                bottomLeft.getX(), bottomLeft.getY(), width, height, angle);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof SlantedRectangle)) return false;
        SlantedRectangle other = (SlantedRectangle) obj;
        return Double.compare(angle, other.angle) == 0;
    }

    @Override
    public boolean contains(Rectangle r) {
        Point[] corners = r.getCorners();
        for (Point p : corners) {
            if (!this.contains(p)) return false;
        }
        return true;
    }

    public boolean contains(SlantedRectangle sr) {
        Point[] corners = sr.getCorners();
        for (Point p : corners) {
            if (!this.contains(p)) return false;
        }
        return true;
    }
}