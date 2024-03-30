package nukethea;

import arc.*;
import arc.struct.Seq;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.type.Weapon;
import mindustry.ui.dialogs.*;

public class Mindsutry extends Mod {

    public Mindsutry(){
        Log.info("Loaded Mindsutry");
        for (int i = 1; i < 5; i++) {
            let weapon = UnitTypes.vanquish.weapons.get(1);
            weapon.outlineColor = Pal.darkOutline;
            UnitTypes.vanquish.weapons.remove(1);
            UnitTypes.vanquish.weapons.insert(1, weapon);
        }
        
    }

}
