package med.voll.api.api.Hotel.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.api.Hotel.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // CREATE INFO
    @PostMapping
    public ResponseEntity<DatosRespuestaCliente> registrarCliente(@RequestBody DatosRegistroCliente datosRegistroCliente,
                                                                  UriComponentsBuilder uriComponentsBuilder){
        Cliente cliente = clienteRepository.save(new Cliente(datosRegistroCliente));
        DatosRespuestaCliente datosRespuestaCliente = new DatosRespuestaCliente(cliente.getId(),
                cliente.getNombre(), cliente.getTelefono(), cliente.getEmail(), cliente.getDocumento());

        URI url = uriComponentsBuilder.path("/clientes").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCliente);
    }

    // OBTAIN INFO
    @GetMapping
    public Page<Cliente> listadoClientes(){
        final Pageable pageable = PageRequest.of(0, 10);
        return clienteRepository.findAll(pageable);
    }
   // public ResponseEntity<Page<DatosListadoCliente>> listadoClientes(@PagebleDefault(size = 2) Pageable paginacion){
        //Page<Cliente> clientesPage = clienteRepository.findById(paginacion);
     //   return ResponseEntity.ok(clienteRepository.findById(paginacion).map(DatosListadoCliente::new));

    //}

    // UPDATE INFO
    @PutMapping
    public ResponseEntity actualizarCliente(@RequestBody @Valid DatosActualizarCliente datosActualizarCliente){
        Cliente cliente = clienteRepository.getReferenceById(datosActualizarCliente.id());
        cliente.actualizarDatos(datosActualizarCliente); // Este metodo hace la validacion
        return ResponseEntity.ok(new DatosActualizarCliente(cliente.getId(),
                cliente.getNombre(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getDocumento()));
    }

    // LOGIC DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.getReferenceById(id);
        cliente.desactivarCliente();
        return ResponseEntity.noContent().build();
    }
}