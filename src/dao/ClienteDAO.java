package dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


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

    public void actualizarCliente(Cliente cliente) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "1234";

        String sql = "UPDATE clientes SET id = ?, nombre = ?, email = ?, telefono = ?, edad = ?, dinero_gastado = ?, productos_comprados = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            {
                pstmt.setInt(1, cliente.getId());
                pstmt.setString(2, cliente.getNombre());
                pstmt.setString(3, cliente.getEmail());
                pstmt.setString(4, cliente.getTelefono());
                pstmt.setInt(5, cliente.getEdad());
                pstmt.setDouble(6, cliente.getDinero_gastado());
                pstmt.setInt(7, cliente.getProductos_comprados());
                // No se como hacer esta consulta.
            }

        }
    }

    public void eliminarCliente(Cliente cliente) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "1234";

        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            {
                pstmt.setInt(1, cliente.getId());

                int filasAfectadas = pstmt.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Cliente eliminado correctamente");
                } else {
                    System.out.println("Error al eliminar cliente " + cliente.getNombre());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente " + e.getMessage());
        }
    }

    public Cliente obtenerCliente(int idBusqueda) throws SQLException {
        Cliente cliente = null;


        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "1234";

        String sql = "SELECT * FROM clientes WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, idBusqueda);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setDinero_gastado(rs.getDouble("dinero_gastado"));
                cliente.setProductos_comprados(rs.getInt("productos_comprados")); {
                }
            }

            } catch(SQLException e){
            System.out.println("Error al obtener cliente " + e.getMessage());

        }
        return cliente;
    }
    public List<Cliente> obtenerTodosLosClientes() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "1234";
        List<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Cliente cliente = new Cliente();

            cliente.setId(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setEmail(rs.getString("email"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setEdad(rs.getInt("edad"));
            cliente.setDinero_gastado(rs.getDouble("dinero_gastado"));
            cliente.setProductos_comprados(rs.getInt("productos_comprados"));

        listaClientes.add(cliente);
        }
            } catch (SQLException e) {
            System.out.println("Error al listar " + e.getMessage());
        }
        return listaClientes;
    }
    public List<Cliente> obtenerMayoresDe30() {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "1234";
        List<Cliente> listaFiltrada = new ArrayList<>();

        String sql = "SELECT * FROM clientes WHERE edad > 30";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setEdad(rs.getInt("edad"));
                    cliente.setEmail(rs.getString("email"));

                    listaFiltrada.add(cliente);
                }
            } catch (SQLException e) {
                System.out.println("Error al filtrar " + e.getMessage());
            }
            return listaFiltrada;
        }
    public List<Cliente> obtenerClientesGastoMayor500() {
        String url = "jdbc:mysql://localhost:3306/tienda";
        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes WHERE dinero_gastado > 500";

        try (Connection conn = DriverManager.getConnection(url, "root", "1234");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDinero_gastado(rs.getDouble("dinero_gastado"));


                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al filtrar por gasto: " + e.getMessage());
        }
        return lista;
    }
    public List<Cliente> obtenerClientesOrdenadosPorGasto() {
        String url = "jdbc:mysql://localhost:3306/tienda";
        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes ORDER BY dinero_gastado DESC";

        try (Connection conn = DriverManager.getConnection(url, "root", "1234");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDinero_gastado(rs.getDouble("dinero_gastado"));

                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al ordenar clientes: " + e.getMessage());
        }
        return lista;
    }
    public List<Cliente> obtenerTop3Compradores() {
        String url = "jdbc:mysql://localhost:3306/tienda";
        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes ORDER BY productos_comprados DESC LIMIT 3";

        try (Connection conn = DriverManager.getConnection(url, "root", "1234");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setProductos_comprados(rs.getInt("productos_comprados"));

                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el Top 3: " + e.getMessage());
        }
        return lista;
    }
    }

