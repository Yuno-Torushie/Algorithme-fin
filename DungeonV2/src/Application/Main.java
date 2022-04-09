package Application;


import Util.*;
import Model.*;

public class Main {
	
    public static void main(final String[] args) {
        Model theRootModel = new Model();
        Screen theRootView = new Screen();
        final Game leJeu = new Game(theRootModel, theRootView);
        leJeu.launch();
    }
}
