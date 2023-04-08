package magicGame.models.magics;

public class BlackMagic extends MagicImpl{
    private static final int FIRE_BULLET = 10;
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() < FIRE_BULLET) {
            return 0;
        }else {
            setBulletsCount(getBulletsCount() - FIRE_BULLET);
            return FIRE_BULLET;
        }
    }
}
