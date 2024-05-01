package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import database.DatabaseConnection;
import model.Menu;

public class MenuController {
    DatabaseConnection db = new DatabaseConnection();

    public boolean insertMenu(Menu menu) {
        String query = "INSERT INTO menu(Nama, Harga, Stock) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = db.connection.prepareStatement(query);
            stmt.setString(1, menu.getNama());
            stmt.setString(2, menu.getHarga());
            stmt.setInt(3, menu.getStock());
            int rowAffected = stmt.executeUpdate();
            System.out.println("Rows affected from insert: " + rowAffected);
            return rowAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void insertDefaultMenu() {
		try {
			boolean insert = insertMenu(new Menu("coffee pudding","Rp25.000", 20));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM menu";
        try {
            PreparedStatement stmt = db.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu(
                        rs.getString("Nama"),
                        rs.getString("Harga"),
                        rs.getInt("Stock")
                );
                menus.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menus;
    }

    public boolean updateMenu(Menu menu) {
        String query = "UPDATE menu SET Nama=?, Harga=?, Stock=? WHERE ID=?";
        try {
            PreparedStatement stmt = db.connection.prepareStatement(query);
            stmt.setString(1, menu.getNama());
            stmt.setString(2, menu.getHarga());
            stmt.setInt(3, menu.getStock());
            int rowAffected = stmt.executeUpdate();
            System.out.println("Rows affected from update: " + rowAffected);
            return rowAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteMenu(int id) {
        String query = "DELETE FROM menu WHERE ID=?";
        try {
            PreparedStatement stmt = db.connection.prepareStatement(query);
            stmt.setInt(1, id);
            int rowAffected = stmt.executeUpdate();
            System.out.println("Rows affected from delete: " + rowAffected);
            return rowAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
