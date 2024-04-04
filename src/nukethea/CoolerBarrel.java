package nukethea;

import arc.math.Mathf;
import arc.util.Nullable;
import mindustry.entities.pattern.ShootBarrel;

public class CoolerBarrel extends ShootBarrel {
    @Override
    public void shoot(int totalShots, BulletHandler handler, @Nullable Runnable barrelIncrementer){
        for(int i = 0; i < shots; i++){
            int index = ((Mathf.random(0,barrels.length/3-1) + barrelOffset) % (barrels.length / 3)) * 3;
            handler.shoot(barrels[index], barrels[index + 1], barrels[index + 2], firstShotDelay + shotDelay * i);
            if(barrelIncrementer != null) barrelIncrementer.run();
        }
    }
}