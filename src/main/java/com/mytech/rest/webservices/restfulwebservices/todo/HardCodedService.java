package com.mytech.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardCodedService {

    private static final List<Todo> todos = new ArrayList<Todo>();
    private static int idcounter = 0;

    static {
        todos.add(new Todo(++idcounter, "MayTech", "Lear to Dance", new Date(), false));
        todos.add(new Todo(++idcounter, "MayTech", "Lear about AWS", new Date(), false));
        todos.add(new Todo(++idcounter, "MayTech", "Visit Egypt", new Date(), false));
        todos.add(new Todo(++idcounter, "MayTech", "Visit Canada", new Date(), false));
        todos.add(new Todo(++idcounter, "MayTech", "Visit USA", new Date(), false));
    }

    public static List<Todo> FindAll() {
        return todos;
    }

    public static List<Todo> FindByUserName(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equals(username)).collect(Collectors.toList());
    }

    public static Todo deleteById(String username, Long id) {
        Todo todo = findById(username, id);
        if (todo == null) return null;
        if (todos.remove(todo)) return todo;
        return null;
    }

    private static Todo findById(String username, Long id) {
        return todos.stream().filter(todo -> todo.getId() == id && todo.getUsername().equals(username)).findFirst().orElseThrow();
    }


    public static Todo FindByUserNameAndId(String username, long id) {
        return findById(username, id) == null ? null : findById(username, id);
    }

    public static Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idcounter);
            todos.add(todo);
        } else {
            deleteById(todo.getUsername(), todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}
