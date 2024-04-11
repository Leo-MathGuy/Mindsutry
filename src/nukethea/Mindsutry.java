package nukethea;

import arc.util.*;
import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.gen.Sounds;
import mindustry.mod.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class Mindsutry extends Mod {

    public Mindsutry() {
        Log.info("Loaded Mindsutry");
        
    }

    public void loadContent() {
        Log.info("Loading vanquish mods...");

        for (int i = 1; i < UnitTypes.vanquish.weapons.size; i++) {
            var weapon = UnitTypes.vanquish.weapons.get(i);

            weapon.bullet = new ContinuousFlameBulletType(){{
                damage = 15f;
                length = 60f;
                knockback = 0.5f;
                pierceCap = 4;
                flareWidth = 2f;
                flareLength = 15f;
                flareColor = Color.valueOf("fac534").a(0.25f);
                width = 2.2f;

                colors = new Color[]{Color.valueOf("fac534").a(0.55f), Color.valueOf("f7ce5e").a(0.7f), Color.valueOf("fae19d").a(0.8f), Color.valueOf("91a4ff"), Color.white};
            }};

            weapon.shootY = -0.5f;
            weapon.continuous = true;
            weapon.shootSound = Sounds.torch;
            weapon.reload = 0;
            weapon.rotateSpeed = 2f;
            weapon.mirror = true;
            weapon.alternate = false;
        }

        var weapon = UnitTypes.flare.weapons.get(0);
        weapon.bullet = new ContinuousFlameBulletType(){{
            damage = 1.5f;
            length = 35f;
            knockback = 0.5f;
            pierceCap = 2;
            flareWidth = 2f;
            flareLength = 15f;
            flareColor = Color.valueOf("fac534").a(0.25f);
            width = 1.8f;

            colors = new Color[]{Color.valueOf("fac534").a(0.55f), Color.valueOf("f7ce5e").a(0.7f), Color.valueOf("fae19d").a(0.8f), Color.valueOf("91a4ff"), Color.white};
        }};

        weapon.continuous = true;
        weapon.shootSound = Sounds.torch;
        weapon.reload = 0;
        weapon.mirror = false;
        weapon.alternate = false;
        weapon.x = 0;
    

        var spectre = ((ItemTurret) Blocks.spectre);

        spectre.shootY = 14f;

        float[] xs = {-53f, -45f, -39f, -31f, -25f, -17f, -11f, -3f, 3f, 11f, 17f, 25f, 31f, 39f, 45f, 53f};
        float[] bars = new float[16*3];

        for (int i = 0; i < 16*3; i+=3) {
            bars[i] = xs[i/3];
            bars[i+1] = 0;
            bars[i+2] = 0;
        }

        spectre.shoot = new CoolerBarrel(){{
            barrels = bars;
        }};

        spectre.reload = 0.3f;
        spectre.recoilTime = 0.1f;
        spectre.recoil = 1f;
        spectre.coolantMultiplier = 1.5f;
        spectre.inaccuracy = 15f;
        spectre.ammoTypes.put(Items.copper, new BasicBulletType(8f, 100){{
            hitSize = 5;
            width = 8f;
            height = 30f;
            shootEffect = Fx.shootBig;
            pierceCap = 2;
            pierceBuilding = true;
            knockback = 3f;
            homingPower = 0.3f;
        }});

        var dagger = UnitTypes.dagger;
        
        dagger.speed = 3f;
        dagger.weapons.get(0).bullet.width = 30f;
        dagger.weapons.get(0).bullet.lifetime = 180f;        
        dagger.weapons.get(0).bullet.speed = 1f;        
    }
}
