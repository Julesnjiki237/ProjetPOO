public class Dessin {
    private Rectangle[] rectangles;
    private int count;
    private Rectangle hullRect;

    public Dessin(int capacity) {
        rectangles = new Rectangle[capacity];
        count = 0;
        hullRect = null;
    }

    public boolean add(Rectangle r) {
        if (count >= rectangles.length) return false;
        rectangles[count++] = r;
        updateHull(r);
        return true;
    }

    private void updateHull(Rectangle newRect) {
        if (hullRect == null) {
            hullRect = new Rectangle(newRect.getCorners()[0], 0, 0);
            hullRect = Rectangle.hull(new Rectangle[]{newRect});
        } else {
            Rectangle[] both = {hullRect, newRect};
            hullRect = Rectangle.hull(both);
        }
    }

    public double surface() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += rectangles[i].surface();
        }
        return total;
    }

    public void translate(double dx, double dy) {
        for (int i = 0; i < count; i++) {
            rectangles[i].translate(dx, dy);
        }
        if (hullRect != null) {
            hullRect.translate(dx, dy);
        }
    }

    public Rectangle hull() {
        if (hullRect == null && count > 0) {
            Rectangle[] existingRects = new Rectangle[count];
            System.arraycopy(rectangles, 0, existingRects, 0, count);
            hullRect = Rectangle.hull(existingRects);
        }
        return hullRect;
    }
}