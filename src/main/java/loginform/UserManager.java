

import java.sql.*;

//Вход Базу данных SQL
public class UserManager {
    private static final String url = "jdbc:mysql://localhost:3306/userbd?useSSL=false&serverTimezone=UTC";
    private static final String dbUser = " ";
    private static final String dbPassword = " ";

    //Вход в систему
    public static Connection getConection() throws SQLException {
        return DriverManager.getConnection(url,dbUser,dbPassword);
    }

    //Метод регистрации пользователей
    public boolean registerUsers(String username, String email, String password) {
        try (Connection conn = UserManager.getConection()) {
            String checkSql = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            checkStmt.setString(2, email);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();

            if(rs.getInt(1)>0){
                System.out.println("Ошибка: пользователь с таким логином или email уже существует.");
                return false;
            } else {
                String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении пользователя: " + e.getMessage());
            return false;
        }
    }

    //Удаление пользователя из базы данных по его имени
    public void deleteUser(User username) {
        try (Connection conn = UserManager.getConection()) {
            String sql = "DELETE FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(username));
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Пользователь \"" + username + "\" удалён.");
            } else {
                System.out.println("Пользователь \"" + username + "\" не найден.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении: " + e.getMessage());
        }
    }

    //Изменение пароля пользователя
    public void changePassword(String username, String password, String newPassword) {
        try (Connection conn = UserManager.getConection()) {
            String sql = "UPDATE users SET password =? WHERE username =? AND password = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newPassword);
            stmt.setString(2, username);
            stmt.setString(3, password);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Пароль успешно обновлён для пользователя \"" + username + "\".");
            } else {
                System.out.println("Ошибка: неверное имя пользователя или старый пароль.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении пароля: " + e.getMessage());
        }
    }

    public boolean loginUser (String username, String password){
        String sql = "SELECT password FROM users WHERE username = ?";

        try(Connection conn = UserManager.getConection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String storedPassword = rs.getString("password");

                if(!storedPassword.equals(password)) {
                    System.out.println("Неверный пароль.");
                    return false;
                }

                System.out.println("Вход выполнен. Добро пожаловать!");
                return true;
            } else {
                System.out.println("Пользователь не найден.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при входе: " + e.getMessage());
            return false;
        }
    }
}