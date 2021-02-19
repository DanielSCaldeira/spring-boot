package br.com.primeirocrudspring.springbootcommsql.controller;

import br.com.primeirocrudspring.springbootcommsql.dto.ClientDTO;
import br.com.primeirocrudspring.springbootcommsql.dto.ResponseDTO;
import br.com.primeirocrudspring.springbootcommsql.repository.ClientRepository;
import br.com.primeirocrudspring.springbootcommsql.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/")
    public ResponseDTO get() throws Exception {
        ClientService service = new ClientService(clientRepository);
        List<ClientDTO> clients = service.list();
        return new ResponseDTO(clients, clients.stream().count());
    }

    @GetMapping("/{id}")
    public ResponseDTO get(@PathVariable("id") long id) throws Exception {
        ClientService service = new ClientService(clientRepository);
        var client = service.findById(id);
        return new ResponseDTO(client);
    }

    @PutMapping("/")
    public ResponseDTO put(@RequestBody ClientDTO clientDTO) throws Exception {
        ClientService service = new ClientService(clientRepository);
        ClientDTO client = service.update(clientDTO);
        return new ResponseDTO("Registro atualizado com sucesso!", client);
    }

    @PostMapping("/")
    public ResponseDTO post(@RequestBody ClientDTO clientDTO) throws Exception {
        ClientService service = new ClientService(clientRepository);
        ClientDTO client = service.save(clientDTO);
        return new ResponseDTO("Registro inserido com sucesso!", client);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO del(@PathVariable("id") long id) throws Exception {
        ClientService service = new ClientService(clientRepository);
        service.delete(id);
        return new ResponseDTO("Registro excluido com sucesso!");
    }
}
