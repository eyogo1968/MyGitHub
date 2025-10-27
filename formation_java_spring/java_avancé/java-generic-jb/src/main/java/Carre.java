public class Carre extends Forme{

    String name;

    public Carre(String name) {
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
        System.out.println("dessin du carre");
    }
}
