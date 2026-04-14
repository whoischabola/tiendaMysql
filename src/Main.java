import dao.Cliente;
import dao.ClienteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws SQLException {
    Cliente c = new Cliente();
    c.setId(11);
    c.setNombre("Isabel Ruiz");
    c.setEmail("ruiz@gmail.com");
    c.setTelefono("555-1234");
    c.setEdad(20);
    c.setDinero_gastado(165.80);
    c.setProductos_comprados(3);

    ClienteDAO dao = new ClienteDAO();
    dao.insertarCliente(c);

    System.out.println("Proceso finalizado");
}



