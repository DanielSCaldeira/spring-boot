package br.com.primeirocrudspring.springbootcommsql.service;

import br.com.primeirocrudspring.springbootcommsql.dto.ClientDTO;
import br.com.primeirocrudspring.springbootcommsql.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> list() throws Exception {
        try {
            var clients = clientRepository.findAll();
            return clients
                    .stream()
                    .map((c) -> ClientDTO.toDTO(c))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ClientDTO findById(long id) throws Exception {
        try {
            var c = clientRepository.findById(id);
            return ClientDTO.toDTO(c.get());
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ClientDTO save(ClientDTO client) throws Exception {
        try {
            var model = ClientDTO.toModel(client);
            var registro = clientRepository.save(model);
            return ClientDTO.toDTO(registro);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ClientDTO update(ClientDTO client) throws Exception {
        try {
            var c = clientRepository.findById(client.getId());

            if (c.isPresent()) {
                var clientUpdate = c.get();
                clientUpdate.setId(client.getId());
                clientUpdate.setNome(client.getNome());
                clientUpdate.setSobrenome(client.getSobrenome());
                clientRepository.save(clientUpdate);
            } else {
                throw new Exception("Registro não encontrado na base de dados");
            }
            return client;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void delete(long id) throws Exception {
        try {
            var c = clientRepository.findById(id);

            if (c.isPresent()) {
                clientRepository.deleteById(id);
            } else {
                throw new Exception("Registro não encontrado na base de dados");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
