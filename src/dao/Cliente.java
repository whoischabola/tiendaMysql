package dao;

import java.util.Objects;

public class Cliente {
    public int id;
    public String nombre;
    public String email;
    public String telefono;
    public int edad;
    public double dinero_gastado;
    public int productos_comprados;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String email, String telefono, int edad, double dinero_gastado, int productos_comprados) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.dinero_gastado = dinero_gastado;
        this.productos_comprados = productos_comprados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero_gastado() {
        return dinero_gastado;
    }

    public void setDinero_gastado(double dinero_gastado) {
        this.dinero_gastado = dinero_gastado;
    }

    public int getProductos_comprados() {
        return productos_comprados;
    }

    public void setProductos_comprados(int productos_comprados) {
        this.productos_comprados = productos_comprados;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                ", dinero_gastado=" + dinero_gastado +
                ", productos_comprados=" + productos_comprados +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && edad == cliente.edad && Double.compare(dinero_gastado, cliente.dinero_gastado) == 0 && productos_comprados == cliente.productos_comprados && Objects.equals(nombre, cliente.nombre) && Objects.equals(email, cliente.email) && Objects.equals(telefono, cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, telefono, edad, dinero_gastado, productos_comprados);
    }
}
