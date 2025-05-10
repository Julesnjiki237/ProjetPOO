public class Main {
    public static void main(String[] args) {
        // Test des rectangles standards (ancien code)
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 3);

        Rectangle r1 = new Rectangle(p1, p2);
        Rectangle r2 = new Rectangle(p1, 4, 5);
        Rectangle r3 = new Rectangle(1, 1, 3, 2);

        System.out.println("Surface r1: " + r1.surface());
        System.out.println("Surface r2: " + r2.surface());

        // Test contains
        Point testPoint = new Point(1, 1);
        System.out.println("r1 contient (1,1): " + r1.contains(testPoint));
        System.out.println("r1 contient r3: " + r1.contains(r3));

        // Test sameAs
        Rectangle r4 = new Rectangle(p1, 2, 3);
        System.out.println("r1 equals r4: " + r1.sameAs(r4));

        // Test hull
        Rectangle[] rects = {r1, r2, r3};
        Rectangle hull = Rectangle.hull(rects);
        System.out.println("Rectangle englobant: " +
                hull.getBottomLeft().getX() + "," + hull.getBottomLeft().getY() +
                " w:" + hull.getWidth() + " h:" + hull.getHeight());

        // Test Dessin
        Dessin dessin = new Dessin(5);
        dessin.add(r1);
        dessin.add(r2);
        dessin.add(r3);

        System.out.println("Surface du dessin: " + dessin.surface());
        System.out.println("Rectangle englobant du dessin: " +
                dessin.hull().getBottomLeft().getX() + "," + dessin.hull().getBottomLeft().getY());

        // Test compteur
        System.out.println("Nombre de rectangles créés: " + Rectangle.getNbr());

        // Nouveaux tests avec SlantedRectangle
        SlantedRectangle sr1 = new SlantedRectangle(new Point(2, 2), 3, 2, Math.PI / 4);
        System.out.println("Surface rectangle incliné: " + sr1.surface());
        System.out.println("Contient (3,3): " + sr1.contains(new Point(3, 3)));

        // Test polymorphisme
        Rectangle polyRect = new SlantedRectangle(new Point(1, 1), 2, 2, Math.PI / 6);
        System.out.println("Surface via polymorphisme: " + polyRect.surface());


        //  Nouveau test
        Point p = new Point(1, 2);
        Rectangle r = new Rectangle(p, 2, 3);
        Rectangle t = new SlantedRectangle(p, 2, 3);
        SlantedRectangle s = new SlantedRectangle(p, 2, 3);
        System.out.println(r.surface());
        r.rotate(2);
        System.out.println(r.contains(p));
        System.out.println(t.surface());
        t.rotate(2);
        System.out.println(t.contains(p));
        System.out.println(s.surface());
        s.rotate(2);
        System.out.println(s.contains(p));

        class A {
            void f(A o) {
                System.out.println("void f(A o) dans A");
            }

            //Impossible d'ajouter cette methode en surchage
            //void f(B o) {
               // System.out.println("void f(B o) dans A");
            //}

        }
        class B extends A {
            void f(A o) {
                System.out.println("void f(A o) dans B");
            }
            void f(B o) {
                System.out.println("void f(B o) dans B");
                // C'est une surcharge car la signature change
            }
        }



        //exercice 8

        A a = new A();
        A ab = new B();
        B b = new B();
        a.f(a);
        a.f(ab);
        a.f(b);
        ab.f(a);
        ab.f(ab);
        ab.f(b);
        b.f(a);
        b.f(ab);
        b.f(b);

        //Exercice 11

        System.out.println(a instanceof A);
        System.out.println(ab instanceof A);
        System.out.println(b instanceof A);
        System.out.println(a instanceof B);
        System.out.println(ab instanceof B);
        System.out.println(b instanceof B);

        //Exercice 12
        /*
        Doit être redéfinie dans SlantedRectangle pour tenir compte de l'angle

        Cas non couverts :

        Un SlantedRectangle contenant un Rectangle standard

        Un Rectangle contenant partiellement un SlantedRectangle
        */

        //Exercice 13
        class C {
            char ch = 'C';
            char getCh() { return ch; }
        }
        class D extends C {
            char ch = 'D';
            char getCh() { return ch; }
        }

        C c = new C();
        C cd = new D();
        D d = new D();
        System.out.println(c.ch);
        System.out.println(c.getCh());
        System.out.println(cd.ch);
        System.out.println(cd.getCh());
        System.out.println(d.ch);
        System.out.println(d.getCh());
    }
}