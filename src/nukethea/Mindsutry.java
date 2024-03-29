package nukethea;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class Mindsutry extends Mod {

    public Mindsutry(){
        Log.info("Loaded Mindsutry");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("Impostor sus me harder").row();
                dialog.cont.button("[scarlet]Eat the impostor[]", dialog::hide).size(400f, 25f);
                dialog.show();
            });
        });
    }

}
