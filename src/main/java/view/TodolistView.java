package view;

import service.TodolistService;
import util.InputUtil;

public class TodolistView {

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodolist() {
        while (true) {
            System.out.println("TODOLIST");
            todolistService.showTodolist();

            System.out.println("MENU :");
            System.out.println("[1] Tambah");
            System.out.println("[2] Hapus");
            System.out.println("[x] Keluar");

            var menu = InputUtil.input("Pilih menu");
            if (menu.equals("1")) {
                addTodolist();
            } else if (menu.equals("2")) {
                removeTodolist();
            } else if (menu.equals("x")) {
                break;
            } else {
                System.out.println("[!] PILIHAN SALAH");
            }
        }
    }

    public void addTodolist() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("Masukkan TODO (x batal)");
        if (todo.equals("x")) {

        } else {
            todolistService.addTodolisst(todo);
        }
    }

    public void removeTodolist() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = InputUtil.input("Nomor TODO (x batal)");
        if (number.equals("x")) {

        } else {
            todolistService.removeTodolist(Integer.valueOf(number));
        }
    }

}
