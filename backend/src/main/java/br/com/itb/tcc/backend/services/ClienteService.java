package br.com.itb.tcc.backend.services;

import br.com.itb.tcc.backend.dtos.ClienteDTO;
import br.com.itb.tcc.backend.entities.Cliente;
import br.com.itb.tcc.backend.exceptions.BusinessException;
import br.com.itb.tcc.backend.mappers.ClienteMapper;
import br.com.itb.tcc.backend.repositories.ClienteRepository;
import br.com.itb.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    @Autowired
    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> findAll() {
        List<Cliente> userList = repository.findAll();

        if (userList.isEmpty()) {
            throw new BusinessException(MessageUtil.NOT_FOUND_USER);
        }
        return mapper.dtoList(userList);
    }

    @Transactional
    public void save(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.toEntity(clienteDTO);

        repository.save(cliente);
    }
}
