package service;

import repository.TodolistRepository;
import entity.Todolist;

public class TodolistServiceImpl implements TodolistService {

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        Todolist[] model = todolistRepository.getAll();

        for (var todo : model) {
            System.out.println(todo.getId() + ". " + todo.getTodo());
        }
    }

    @Override
    public void addTodolisst(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("[#] SUKSES MENAMBAH TODO");
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean success = todolistRepository.remove(number);

        if (success) {
            System.out.println("[#] SUKSES MENGHAPUS TODO");
        } else {
            System.out.println("[!] GAGAL MENGHAPUS TODO");
        }
    }
}
