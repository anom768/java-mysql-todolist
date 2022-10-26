import javax.sql.DataSource;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import util.DatabaseUtil;
import view.TodolistView;

public class Application {

    public static void main(String[] args) {

        DataSource dataSource = DatabaseUtil.getDataSource();
        TodolistRepository todolistRepository = new TodolistRepositoryImpl(dataSource);
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.showTodolist();

    }

}
