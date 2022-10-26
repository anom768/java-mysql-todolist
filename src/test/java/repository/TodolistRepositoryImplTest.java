package repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import entity.Todolist;
import util.DatabaseUtil;

public class TodolistRepositoryImplTest {
    
    private HikariDataSource dataSource;
    private TodolistRepository todolistRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        Todolist todolist = new Todolist();
        todolist.setTodo("anom");
        todolistRepository.add(todolist);
    }

    @Test
    void testRemove() {
        System.out.println(todolistRepository.remove(4));
        System.out.println(todolistRepository.remove(3));
        System.out.println(todolistRepository.remove(2));
        System.out.println(todolistRepository.remove(1));
    }

    @Test
    void testGetAll() {
        todolistRepository.add(new Todolist("bangkit"));
        todolistRepository.add(new Todolist("anom"));
        todolistRepository.add(new Todolist("sedhayu"));

        Todolist[] todolists = todolistRepository.getAll();
        for (var todo : todolists) {
            System.out.println(todo.getId() + ". " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }

}
