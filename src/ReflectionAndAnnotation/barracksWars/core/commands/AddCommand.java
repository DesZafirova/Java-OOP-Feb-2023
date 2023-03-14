package ReflectionAndAnnotation.barracksWars.core.commands;

import ReflectionAndAnnotation.barracksWars.annotations.Inject;
import ReflectionAndAnnotation.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";

    }
}
