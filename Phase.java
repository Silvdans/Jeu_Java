package com.company;

public interface Phase {

    void selectionerJoueurs();

    void déroulerPhase();

    boolean verifGagnants(int nbGagnantsAutorises);
}
