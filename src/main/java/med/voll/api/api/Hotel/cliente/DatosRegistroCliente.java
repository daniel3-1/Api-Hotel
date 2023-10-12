package med.voll.api.api.Hotel.cliente;

import jakarta.validation.constraints.NotBlank;
public record DatosRegistroCliente(
        @NotBlank
        String nombre,
        @NotBlank
        String telefono,
        @NotBlank
        String email,
        @NotBlank
        String documento
){

}


