package br.com.itb.tcc.backend.mappers;

import br.com.itb.tcc.backend.dtos.ClienteDTO;
import br.com.itb.tcc.backend.entities.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setCPF(dto.getCPF());

        return cliente;
    }

    public ClienteDTO toDto(Cliente entity) {

        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setCPF(entity.getCPF());

        return dto;
    }

    public List<ClienteDTO> dtoList(List<Cliente> clienteList) {
        return clienteList.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}