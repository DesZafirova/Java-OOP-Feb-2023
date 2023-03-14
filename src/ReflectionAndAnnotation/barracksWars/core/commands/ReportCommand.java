package ReflectionAndAnnotation.barracksWars.core.commands;

import ReflectionAndAnnotation.barracksWars.annotations.Inject;
import ReflectionAndAnnotation.barracksWars.interfaces.Repository;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);

    }

    @Override
    public String execute() {
        return repository.getStatistics();

    }
}
