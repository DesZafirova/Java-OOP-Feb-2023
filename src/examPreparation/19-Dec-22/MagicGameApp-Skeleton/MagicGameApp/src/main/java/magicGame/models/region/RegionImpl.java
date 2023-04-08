package magicGame.models.region;

import magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {


    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = getMagicians(magicians, "Wizard");
        List<Magician> blackWidows = getMagicians(magicians, "BlackWidow");

        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            Magician wizard = wizards.get(0);
            Magician blackWidow = blackWidows.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());
            if (blackWidow.isAlive()) {
                wizard.takeDamage(blackWidow.getMagic().fire());
                if (!wizard.isAlive()) {
                    wizards.remove(wizard);
                }
            } else {
                blackWidows.remove(blackWidow);
            }
        }


        String output = "";
        if (wizards.isEmpty()) {
            output = "Black widows win!";
        } else if (blackWidows.isEmpty()) {
            output = "Wizards win!";
        }
        return output;

    }

    private static List<Magician> getMagicians(Collection<Magician> magicians, String BlackWidow) {
        return magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals(BlackWidow) && m.isAlive())
                .collect(Collectors.toList());
    }
}
