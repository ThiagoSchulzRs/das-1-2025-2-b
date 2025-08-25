package br.univille.observer;

public class Cliente {
    public static void main(String[] args){
        //publicador
        var grupoFamilia = new Publisher();

        var zezinho = new ConcreteSubscriber();
        var huguinho = new ConcreteSubscriber();
        var tia = new ConcreteSubscriber(); //Tia que ta mais para a minha mãe

        grupoFamilia.subscribe(zezinho);
        grupoFamilia.subscribe(huguinho);
        grupoFamilia.subscribe(tia);

        grupoFamilia.setMainState("BOM DIA! Que deus abençoe o seu dia e que lhe de tudo do melhor <3 s2 :)");
        grupoFamilia.notifySubscriber(); //Botão enviar
    }
}
