class Rectangle {
    protected Point topLeft;
    protected double width, height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
        this.width = width;
        this.height = height;
    }

    public double surface() {
        return width * height;
    }

    public boolean contains(Point p) {
        return p.getX() >= topLeft.getX() &&
                p.getX() <= topLeft.getX() + width &&
                p.getY() >= topLeft.getY() &&
                p.getY() <= topLeft.getY() + height;
    }

    public void translate(double dx, double dy) {
        topLeft.translate(dx, dy);
    }
}