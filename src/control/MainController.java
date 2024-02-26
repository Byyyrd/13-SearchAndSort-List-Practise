package control;

import model.List;
import model.Person;

public class MainController {

    private List<Person> allPersons;
    private String[] names = {"Alsbach", "Bachmann", "Cyrus", "Davidoff", "Eregon", "Füller","Giesehau","Halidsch","Irimoff","Zylla","Yilderim","Lupp","Schein","Xenomo","Iwan","Ali","Kötter","Kleinhans","Diablo","Overwatch","Starcraft","Warcraft","Minecraft","Krunker","Command","And","Conquer","Path","Exile","Valheim"};

    public MainController(int amount){
        allPersons = new List<>();
        for(int i = 0; i < amount; i++){
            allPersons.append(createPerson());
        }
    }

    private Person createPerson(){
        Person p = new Person(getRandomName());
        return p;
    }

    public String getRandomName(){
        return names[(int)(Math.random()*names.length)];
    }

    public String showList(){
        String output = "Ausgabe: ";
        allPersons.toFirst();
        while(allPersons.hasAccess()){
            output = output + allPersons.getContent().getName()+" ("+allPersons.getContent().getBirthdate()+"), ";
            allPersons.next();
        }
        return output;
    }

    /**
     * Schreibe einen Algorithmus zum Suchen einer Person innerhalb einer Liste. Falls die Person gefunden wurde, gib ihren Namen samt Geburtsdatum aus.
     * @param name
     * @return
     */
    public String searchList(String name){
        String output = "Nicht gefunden.";
        //COMPLETE 01: Schreibe einen Suchalgorithmus
        allPersons.toFirst();
        while (allPersons.hasAccess()){
            if(allPersons.getContent().getName().equals(name)){
                return allPersons.getContent().getName() + " " + allPersons.getContent().getBirthdate();
            }
            allPersons.next();
        }
        return output;
    }

    /**
     * Stortiere die Liste nach Namen (nicht nach Geburtsdatum!). Entscheide dich hierzu für einen Sortieralgorithmus.
     * Gib an, ob deine Umsetzung stabil ist und ob sie in-place ist.
     */
    public void sortList(){
        //COMPLETE 02: Schreibe einen
        int length = 0;
        allPersons.toFirst();
        while(allPersons.hasAccess()){
            length++;
            allPersons.next();
        }
        for (int i = 0; i < length; i++) {
            allPersons.toFirst();
            while(allPersons.hasAccess()){
                Person previous = allPersons.getContent();
                String name1 = allPersons.getContent().getName();
                allPersons.next();
                if(allPersons.hasAccess()){
                    Person current = allPersons.getContent();
                    String name2 = allPersons.getContent().getName();
                    if(name1.compareTo(name2) > 0){
                        allPersons.remove();
                        allPersons.toFirst();
                        while (allPersons.hasAccess() && allPersons.getContent() != previous){
                            allPersons.next();
                        }
                        allPersons.remove();
                        if(allPersons.hasAccess()){
                            allPersons.insert(current);
                            allPersons.insert(previous);
                        }else {
                            allPersons.append(current);
                            allPersons.append(previous);
                        }
                        allPersons.toFirst();
                        while (allPersons.hasAccess() && allPersons.getContent() != previous){
                            allPersons.next();
                        }
                    }
                }
            }
        }



    }



}
