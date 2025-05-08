//Résumé des résultats ligne par ligne
System.out.println(a instanceof A); //  true car a est un objet A.
System.out.println(ab instanceof A); // true car ab contient un objet B, donc aussi un A.
System.out.println(b instanceof A); // true car b est un B, et B hérite de A.

System.out.println(a instanceof B); // false car a est un A, pas un B.
System.out.println(ab instanceof B); // true car ab contient réellement un B.
System.out.println(b instanceof B); // true car b est un objet de type B.

//Donc ce programme affiche:
true
true
true
false
true
true

