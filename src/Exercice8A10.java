public class Exercice8A10 {
   

/*nous remarquons ici une notion d'heritage entre la classe A et B ou B est la classe fille
 
 */
class A {
    void f(A o) {
        System.out.println("void f(A o) dans A");
    }
}

class B extends A {
    void f(A o) {
        System.out.println("void f(A o) dans B");
    }
}

//ci dessus nous avons la definition des classes A et B
//constrution des objects de A et B
/*A a = new A();
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
*/    
                //********************* */ EXERCICE 8***************************************

                /*LES SORTIES DE CES INSTRUCTIONS SERONT:  void f(A o)  
                 * 
                 * car les 02 classes appelles la meme methode avec les memes paramentres
                  */


                  //************************  EXERCICE 9 **************************** 
                  class A {
                    void f(A o) {
                        System.out.println("void f(A o) dans A");
                    }
                }
                  class B extends A {
                    void f(A o) {
                        System.out.println("void f(A o) dans B");
                    }
                    
                    void f(B o) {  // NOUVELLE MÉTHODE
                        System.out.println("void f(B o) dans B");
                    }
                }
                      /* ici on a une Surcharge de classe dans B

                       * operation               Sortie
                       
                       * a.f(a);                  f(A o)
                        a.f(ab);                    f(A o)
                        a.f(b);                    f(A o) 
                        ab.f(a);                    f(A o)
                        ab.f(ab);                   f(A o)
                        ab.f(b);                     f(A o)
                        b.f(a);                       f(A o)
                        b.f(ab);                     f(A o)
                        b.f(b);                       f(B o)    car c'est un objet de B referencee par B et qui correspond a la nouvelle methode 
                       * 
                       */

                       /**************************  EXERCICE 10 ******************************
                       */

                       class A {
                        void f(A o) {
                            System.out.println("void f(A o) dans A");
                        }
                        
                        void f(B o) {  // NOUVELLE MÉTHODE DANS A
                            System.out.println("void f(B o) dans A");
                        }
                    }
                    
                    class B extends A {
                        void f(A o) {
                            System.out.println("void f(A o) dans B");
                        }
                        
                        void f(B o) {
                            System.out.println("void f(B o) dans B");
                        }
                    }

                    /* ICI , il y'a SURCHARGE DANS LA CLASSE A ET REDEFINITION DANS LA CLASSE B 
                     * car f(B o) dans B est une redefinition de f(B o) dans A
                    */


                  /*   * operation               Sortie
                       
                    * a.f(a);                  f(A o)
                     a.f(ab);                    f(A o)
                     a.f(b);                    f(B o) 
                     ab.f(a);                    f(A o)
                     ab.f(ab);                   f(A o)
                     ab.f(b);                     f(B o)
                     b.f(a);                       f(A o)
                     b.f(ab);                     f(A o)
                     b.f(b);                       f(B o)    car c'est un objet de B referencee par B et qui correspond a la nouvelle methode 
                    */
        }
