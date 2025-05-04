class SlantedRectangle extends Rectangle {
    private double angle; // angle en radians

    public SlantedRectangle(Point topLeft, double width, double height) {
        this(topLeft, width, height, 0); // angle 0 par défaut
    }

    public SlantedRectangle(Point topLeft, double width, double height, double angle) {
        super(topLeft, width, height);
        this.angle = angle;
    }

    public double getAngle() { return angle; }
    public void setAngle(double angle) { this.angle = angle; }

    public void rotate(double deltaAngle) {
        this.angle += deltaAngle;
        // Normaliser l'angle entre 0 et 2π
        this.angle = this.angle % (2 * Math.PI);
        if (this.angle < 0) {
            this.angle += 2 * Math.PI;
        }
    }

    @Override
    public boolean contains(Point p) {
        // Transformation inverse pour ramener le point dans le repère du rectangle
        double x = p.getX() - topLeft.getX();
        double y = p.getY() - topLeft.getY();

        // Rotation inverse
        double cos = Math.cos(-angle);
        double sin = Math.sin(-angle);
        double xRot = x * cos - y * sin;
        double yRot = x * sin + y * cos;

        // Vérification dans le repère non incliné
        return xRot >= 0 && xRot <= width && yRot >= 0 && yRot <= height;
    }

    // La surface ne change pas avec la rotation
    // Pas besoin de redéfinir surface()
}