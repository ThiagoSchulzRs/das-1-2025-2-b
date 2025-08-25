package br.univille.observer;

import java.util.ArrayList;

public class Publisher {
    //private Subscriber[] subscribers = new Subscriber[10]; //Limitado
    private ArrayList<Subscriber> subscribers = new ArrayList<>(); //Ilimitado
    private String mainState;

    public String getMainState() {
        return mainState;
    }
    public void setMainState(String mainState) {
        this.mainState = mainState;
    }

    public void subscribe(Subscriber assinante){
        subscribers.add(assinante);
    }

    public void notifySubscriber(){
        for(Subscriber umAssinante: subscribers){
            umAssinante.update(mainState);
        }
    }
}
