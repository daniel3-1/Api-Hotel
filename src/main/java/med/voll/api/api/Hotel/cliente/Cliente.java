package med.voll.api.api.Hotel.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "clientes")
@Entity(name= "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String documento;

    private Boolean activo;

    public Cliente(DatosRegistroCliente datosRegistroCliente){
        this.nombre = datosRegistroCliente.nombre();
        this.telefono = datosRegistroCliente.telefono();
        this.email = datosRegistroCliente.email();
        this.documento = datosRegistroCliente.documento();
    }

    public void actualizarDatos(DatosActualizarCliente datosActualizarCliente) {
        if(datosActualizarCliente.nombre() != null){
            this.nombre = datosActualizarCliente.nombre();
        }
        if(datosActualizarCliente.documento() != null){
            this.documento = datosActualizarCliente.documento();
        }
    }

    public void desactivarCliente(){
        this.activo = false;
    }
}
