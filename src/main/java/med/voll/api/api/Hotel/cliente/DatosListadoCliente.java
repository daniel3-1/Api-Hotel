package med.voll.api.api.Hotel.cliente;
 

public record DatosListadoCliente(Long id, String nombre, String telefono, String email, String documento) {

    public DatosListadoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNombre(), cliente.getTelefono(), cliente.getEmail(), cliente.getDocumento());
    }
}
