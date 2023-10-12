package med.voll.api.api.Hotel.cliente;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCliente(@NotNull Long id,
                                     String nombre,
                                     String telefono,
                                     String email,
                                     String documento) {
}
