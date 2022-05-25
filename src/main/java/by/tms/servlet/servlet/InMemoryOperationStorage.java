package by.tms.servlet.servlet;

import by.tms.servlet.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage {

    private static final List<Operation> operations = new ArrayList<>();

    public void save(Operation operation) {
        operations.add(operation);
    }
public List<Operation> findAllOperationByUsername(String username) {
    List<Operation> list = new ArrayList<>();
    for (Operation operation : operations) {
if (operation.getUser().getUserName().equals(username)){
    list.add(operation);
}
    }
    return list;
}
}
