package nukethea;

import arc.util.*;
import mindustry.content.*;
import mindustry.mod.*;

public class Mindsutry extends Mod {

    public Mindsutry(){
        Log.info("Loaded Mindsutry");
        for (int i = 1; i < 5; i++) {
            UnitTypes.vanquish.weapons.get(i).top = true;
            UnitTypes.vanquish.weapons.get(i).shootY = -0.5f;
        }
        
    }

}
