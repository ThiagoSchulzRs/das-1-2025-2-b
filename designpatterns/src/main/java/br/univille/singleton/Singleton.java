package br.univille.singleton;

public class Singleton {
    //Parece com uma variavel global
    private static Singleton instance;
    private String segredo;

    public String getSegredo() {
        return segredo;
    }
    public void setSegredo(String segredo) {
        this.segredo = segredo;
    }

    private Singleton(){
        //Construtor privado, nínguem pode instancia-la a não ser ela mesma
        System.out.println("Singleon: Contrutor");
    }
    public static Singleton getInstance(){
        System.out.println("Singleon: getInstance");
        if(instance == null){
            System.out.println("Singleon: NEW");
            instance = new Singleton();
        }
        return instance;
    }
}