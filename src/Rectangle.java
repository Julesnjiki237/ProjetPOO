public class Rectangle {
    protected Point bottomLeft;
    protected double width;
    protected double height;
    private static int nbr = 0; // Compteur d'instances

    // Constructeur avec 2 points (compatibilité)
    public Rectangle(Point p1, Point p2) {
        double x1 = Math.min(p1.getX(), p2.getX());
        double y1 = Math.min(p1.getY(), p2.getY());
        double x2 = Math.max(p1.getX(), p2.getX());
        double y2 = Math.max(p1.getY(), p2.getY());

        this.bottomLeft = new Point(x1, y1);
        this.width = x2 - x1;
        this.height = y2 - y1;
        nbr++;
    }

    // Constructeur principal avec point et dimensions
    public Rectangle(Point bottomLeft, double width, double height) {
        this.bottomLeft = new Point(bottomLeft.getX(), bottomLeft.getY());
        this.width = width;
        this.height = height;
        nbr++;
    }

    // Constructeur avec 4 doubles (compatibilité)
    public Rectangle(double x, double y, double width, double height) {
        this(new Point(x, y), width, height);
    }

    // Calcul de la surface
    public double surface() {
        return width * height;
    }

    // Translation du rectangle
    public void translate(double dx, double dy) {
        bottomLeft.translate(dx, dy);
    }

    // Rotation (implémentation vide pour compatibilité)
    public void rotate(double angle) {
        // Ne fait rien pour un rectangle standard
    }

    // Test si un point est contenu
    public boolean contains(Point p) {
        return p.getX() >= bottomLeft.getX() &&
                p.getX() <= bottomLeft.getX() + width &&
                p.getY() >= bottomLeft.getY() &&
                p.getY() <= bottomLeft.getY() + height;
    }

    // Test si un rectangle est contenu
    public boolean contains(Rectangle r) {
        Point[] corners = r.getCorners();
        for (Point corner : corners) {
            if (!this.contains(corner)) {
                return false;
            }
        }
        return true;
    }

    // Test d'égalité
    public boolean sameAs(Rectangle other) {
        if (this == other) return true;
        return bottomLeft.equals(other.bottomLeft) &&
                Double.compare(width, other.width) == 0 &&
                Double.compare(height, other.height) == 0;
    }
    //Redéfinition de la méthode equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;// verifie si c'est le meme objet en memoire 
        if (!(obj instanceof Rectangle)) return false;//verifie si l'objet est null ou pas un rectangle
        Rectangle other = (Rectangle) obj;//convertit l'objet en rectangle
        return sameAs(other); // compare les attributs un par un
    }
    // Rectangle englobant
    public static Rectangle hull(Rectangle[] rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            return null;
        }

        double minX = Double.POSITIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;

        for (Rectangle r : rectangles) {
            Point[] corners = r.getCorners();
            for (Point p : corners) {
                minX = Math.min(minX, p.getX());
                minY = Math.min(minY, p.getY());
                maxX = Math.max(maxX, p.getX());
                maxY = Math.max(maxY, p.getY());
            }
        }

        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    // Obtenir les coins du rectangle
    protected Point[] getCorners() {
        return new Point[] {
                bottomLeft,
                new Point(bottomLeft.getX() + width, bottomLeft.getY()),
                new Point(bottomLeft.getX() + width, bottomLeft.getY() + height),
                new Point(bottomLeft.getX(), bottomLeft.getY() + height)
        };
    }

    // Getters
    public Point getBottomLeft() {
        return new Point(bottomLeft.getX(), bottomLeft.getY());
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public static int getNbr() {
        return nbr;
    }

    // Méthode toString pour le débogage
    @Override
    public String toString() {
        return "Rectangle[(" + bottomLeft.getX() + "," + bottomLeft.getY() +
                "), w=" + width + ", h=" + height + "]";
    }
}