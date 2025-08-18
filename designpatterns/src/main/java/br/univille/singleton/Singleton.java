package br.univille.singleton;

public class Singleton {
    //Parece com uma variavel global
    private static Singleton instance;

    private Singleton{
        //Construtor privado, nínguem pode instancia-la a não ser ela mesma
    }
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}