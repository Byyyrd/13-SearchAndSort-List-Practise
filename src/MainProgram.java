import control.MainController;

import java.awt.*;

public class MainProgram {
    public static void main (String[] args){
        EventQueue.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        MainProgram.setup();
                    }
                });
    }

    private static void setup(){
        MainController mainController = new MainController(10);
        //Aufgabe der Liste
        System.out.println(mainController.showList());

        //Suche in der Liste
        String name = mainController.getRandomName();
        System.out.println("Suche nach " + name+ " ergab: "+mainController.searchList(name));

        //Sortieren der Liste
        System.out.println(mainController.showList());  //Liste vorher
        mainController.sortList();                      //Liste sortieren
        System.out.println(mainController.showList());  //Liste nachher

    }
}
