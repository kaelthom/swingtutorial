package com.openclassrooms.swingtutorial.observable;

import com.openclassrooms.swingtutorial.observer.Observer;

public interface Observable {
    void addObservateur(Observer obs);

    void updateObservateur();

    void delObservateur();
}
