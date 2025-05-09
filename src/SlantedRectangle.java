public class SlantedRectangle extends Rectangle {
    private double angle; // angle en radians

    public SlantedRectangle(Point bottomLeft, double width, double height) {
        this(bottomLeft, width, height, 0);
    }

    public SlantedRectangle(Point bottomLeft, double width, double height, double angle) {
        super(bottomLeft, width, height);
        this.angle = angle;
    }
    public SlantedRectangle(Point p1, Point p2, double angle) {
        super(p1, p2); // Appel au constructeur de Rectangle
        this.angle = angle;
    }

    // Constructeur avec 4 heights et un angle
    public SlantedRectangle(double x, double y, double width, double height, double angle) {
        super(x, y, width, height); // Appel au constructeur de Rectangle
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
    public boolean equals(Object obj) {
        if (!(obj instanceof SlantedRectangle)) return false; // Vérifie si l'objet est une instance de SlantedRectangle
        SlantedRectangle other = (SlantedRectangle) obj; // Cast de l'objet

        // Vérifie l'égalité des attributs de la classe parente
        return super.equals(other) && 
            Double.compare(this.angle, other.angle) == 0; // Vérifie si les angles sont égaux
    }
}
