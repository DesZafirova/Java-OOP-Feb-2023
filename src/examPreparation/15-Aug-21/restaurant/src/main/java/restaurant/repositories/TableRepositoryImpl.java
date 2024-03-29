package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.*;
import java.util.stream.Collectors;

public class TableRepositoryImpl implements TableRepository<Table> {

    private Map<Integer, Table> tables;

    public TableRepositoryImpl() {
        tables = new LinkedHashMap<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return tables.values();
    }

    @Override
    public void add(Table entity) {
        tables.put(entity.getTableNumber(), entity);
    }

    @Override
    public Table byNumber(int number) {
        return tables.get(number);
    }
}

