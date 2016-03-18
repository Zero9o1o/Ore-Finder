package arceus.orefinder.item;

import arceus.orefinder.OreFinderConfig;

import java.util.Random;

public class prospectorTool extends orefinderItem{
    private static Random randomNumber = new Random();

    public prospectorTool(){
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(100);
    }

    public byte rng(float chance) {

        if (OreFinderConfig.doRandomResult) {

            float rng = randomNumber.nextFloat();

            if (rng <= chance / 2) {

                return 1;

            } else if (rng <= chance) {

                return 2;
            }
        }

        return 0;

    }
}
