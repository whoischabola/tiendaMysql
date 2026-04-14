package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClienteDAO {
    public void insertarCliente(Cliente cliente) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password);) {
            String sql = "INSERT INTO clientes (id, nombre, email, telefono, edad, dinero_gastado, productos_comprados) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cliente.getId());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setInt(5, cliente.getEdad());
            pstmt.setDouble(6, cliente.getDinero_gastado());
            pstmt.setInt(7, cliente.getProductos_comprados());

            pstmt.executeUpdate();
            System.out.println("Cliente insertado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente " + e.getMessage());
        }
    }
}