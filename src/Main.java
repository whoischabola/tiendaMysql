import dao.Cliente;
import dao.ClienteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    ClienteDAO dao2 = new ClienteDAO();
    dao2.eliminarCliente(c);

    Cliente c3 = new Cliente();
    int idBuscar = 10;
    Cliente encontrado = dao.obtenerCliente(idBuscar);

    if(encontrado != null){
        System.out.println("Cliente encontrado");
        System.out.println("Nombre: " + encontrado.getNombre());
    } else {
        System.out.println("Cliente no encontrado");
    }
    Cliente c4 = new Cliente();
    List<Cliente> Lista = dao.obtenerTodosLosClientes();

    if (Lista.isEmpty()) {
        System.out.println("No se encuentran clientes");
    } else {
        System.out.println("Lista de clientes completa");
    }
    ClienteDAO dao3 = new ClienteDAO();
    List<Cliente> jovenes = dao3.obtenerMayoresDe30();

    System.out.println("Mayores de 30");

    if (jovenes.isEmpty()) {
        System.out.println("No se encuentran clientes");
    } else {
        for (Cliente j : jovenes) {
            System.out.println("Nombre: " + j.getNombre());
            System.out.println("Edad: " + j.getEdad());
        }
            ClienteDAO dao4 = new ClienteDAO();
            List<Cliente> vips = dao.obtenerClientesGastoMayor500();

            System.out.println("Clientes que han gastado más de 500€");
            for (Cliente cliente : vips) {
                System.out.println("Cliente: " + c.getNombre() + " | Gastado: " + c.getDinero_gastado() + "€");
            }
            ClienteDAO dao5 = new ClienteDAO();
            List<Cliente> listaOrdenada = dao.obtenerClientesOrdenadosPorGasto();

            System.out.println("Clientes clasificados por gasto €");
            for (Cliente cliente : listaOrdenada) {
                System.out.println(c.getDinero_gastado() + "€ - " + c.getNombre());
            }
            ClienteDAO dao6 = new ClienteDAO();
            List<Cliente> top3 = dao.obtenerTop3Compradores();

            System.out.println("Podio de compradores");

            int puesto = 1;
            for (Cliente cliente : top3) {
                System.out.println(puesto + "º Lugar: " + c.getNombre() + " (" + c.getProductos_comprados() + " productos)");
                puesto++;
            }
            double media = dao.obtenerMediaProductos();
        System.out.println("Media: " + media);
        }
        ClienteDAO dao7 = new ClienteDAO();
    double resultado = dao.obtenerMediaConCondiciones();
    System.out.println("Resultado gasto mayores de 25 años y +3 productos: " + resultado);

    ClienteDAO dao8 = new ClienteDAO();
    int cantidad = dao8.contarClientesGastoMayor100();
    System.out.println("Cantidad de dinero: " + cantidad);
}










