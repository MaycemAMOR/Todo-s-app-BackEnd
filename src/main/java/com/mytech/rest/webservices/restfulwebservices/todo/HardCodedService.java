package com.mytech.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardCodedService {

    private static List<Todo> todos = new ArrayList<Todo>();
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

    public static void setTodos(List<Todo> todos) {
        HardCodedService.todos = todos;
    }
}
