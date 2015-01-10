package holding;

/**
 * RUN:
 *         javac typeinfo/pets/*.java
 *         javac holding/InterfaceVsIterator.java && java holding.InterfaceVsIterator
 * OUTPUT:
 *         0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 *         2:Cymric 1:Manx 0:Rat 6:Pug 5:Cymric 4:Pug 3:Mutt 7:Manx
 *         0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 *         2:Cymric 1:Manx 0:Rat 6:Pug 5:Cymric 4:Pug 3:Mutt 7:Manx
 *         {Ralph=Rat,  Eric=Manx,  Robin=Cymric,  Lacey=Mutt,  Britney=Pug,  Sam=Cymric,  Spot=Pug,  Fluffy=Manx}
 *         [Ralph,  Eric,  Robin,  Lacey,  Britney,  Sam,  Spot,  Fluffy]
 *         0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 *         0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 */

import java.util.*;
import typeinfo.pets.*;

public class InterfaceVsIterator {

    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> pets) {
        for (Pet p : pets) {
            System.out.print(p.id() + ":" + p + " ");    
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> petList = new Pets().arrayList(8);
        Set<Pet> petSet = new HashSet<Pet>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<String, Pet>();

        String[] names = ("Ralph, Eric, Robin, Lacey, " + "Britney, Sam, Spot, Fluffy").split(",");
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i], petList.get(i));
        }

        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());

        System.out.println(petMap);
        System.out.println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());
    }
}