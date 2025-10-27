public class Forme {

    String name;

    public Forme(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void dessiner(){
        System.out.println("dessin de le forme");
    }
}
