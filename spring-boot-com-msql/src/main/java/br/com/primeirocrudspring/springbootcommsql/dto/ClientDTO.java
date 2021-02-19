package br.com.primeirocrudspring.springbootcommsql.dto;

import br.com.primeirocrudspring.springbootcommsql.model.Client;

import java.util.Objects;

public class ClientDTO {

    private long id;

    private String nome;

    private String sobrenome;

    public static ClientDTO toDTO(Client c) {
        var client = new ClientDTO();
        client.setId(c.getId());
        client.setSobrenome(c.getSobrenome());
        client.setNome(c.getNome());
        return client;
    }

    public static Client toModel(ClientDTO c) {
        var client = new Client();
        client.setId(c.getId());
        client.setSobrenome(c.getSobrenome());
        client.setNome(c.getNome());
        return client;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return id == clientDTO.id && Objects.equals(nome, clientDTO.nome) && Objects.equals(sobrenome, clientDTO.sobrenome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }


}
