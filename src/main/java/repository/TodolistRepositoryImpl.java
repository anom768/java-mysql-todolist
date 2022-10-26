package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository {

    private DataSource dataSource;

    public TodolistRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Todolist[] getAll() {
        String sql = "SELECT * FROM todolist";
        
        try (Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
                
                List<Todolist> list = new ArrayList<>();
                while (resultSet.next()) {
                    Todolist todolist = new Todolist();
                    todolist.setId(resultSet.getInt("id"));
                    todolist.setTodo(resultSet.getString("todo"));

                    list.add(todolist);
                }

                return list.toArray(new Todolist[]{});

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void add(Todolist todolist) {
        String sql = "INSERT INTO todolist(todo) VALUES(?)";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql) ) {
                preparedStatement.setString(1, todolist.getTodo());
                preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {
        String select = "SELECT * FROM todolist WHERE id = ?";
        String delete = "DELETE FROM todolist WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(select)) {
                preparedStatement.setInt(1, number);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        try (PreparedStatement preparedStatement2 = connection.prepareStatement(delete)) {
                            preparedStatement2.setInt(1, number);
                            preparedStatement2.executeUpdate();
                            return true;
                        }
                    }
                    return false;
                }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
