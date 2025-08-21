package br.univille.singleton;

public class Cliente {
    public static void main(String[] args) {
        var segredo = "Quem ta lendo é fofoqueiro";
        //um é mentira e ou outro é vdd
        var singleton = Singleton.getInstance();
        singleton.setSegredo(segredo);

        System.out.println(
            Singleton.getInstance().getSegredo()
        );
    }
}
