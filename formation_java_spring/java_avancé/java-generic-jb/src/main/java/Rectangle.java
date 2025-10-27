public class Rectangle extends Forme{

    String name;

    public Rectangle(String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void dessiner(){
        System.out.println("dessin du rectangle");
    }
}
