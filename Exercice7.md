# Exercice 7:
## Redefinition de la methode equals dans la classe Rectangle :
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Rectangle)) return false;
    Rectangle other = (Rectangle) obj;
    return sameAs(other);
}
```
## Redefinition de la methode equals dans la classe SlantedRectangle:
```java
@Override
public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    if (!(obj instanceof SlantedRectangle)) return false;
    SlantedRectangle other = (SlantedRectangle) obj;
    return this.angle == other.angle;
}
```