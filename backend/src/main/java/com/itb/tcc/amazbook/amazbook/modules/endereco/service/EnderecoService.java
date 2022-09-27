package com.itb.tcc.amazbook.amazbook.modules.endereco.service;

import com.itb.tcc.amazbook.amazbook.exceptions.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.exceptions.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.endereco.dto.EnderecoRequest;
import com.itb.tcc.amazbook.amazbook.modules.endereco.dto.EnderecoResponse;
import com.itb.tcc.amazbook.amazbook.modules.endereco.model.Endereco;
import com.itb.tcc.amazbook.amazbook.modules.endereco.repository.EnderecoRepository;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import com.itb.tcc.amazbook.amazbook.modules.user.service.UsuarioService;
import com.itb.tcc.amazbook.amazbook.utils.ErrorUtil;
import com.itb.tcc.amazbook.amazbook.utils.SuccessUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final UsuarioService usuarioService;

    public List<EnderecoResponse> findAll(){
        return enderecoRepository
                .findAll()
                .stream()
                .map(EnderecoResponse::of)
                .collect(Collectors.toList());
    }

    public EnderecoResponse save(EnderecoRequest enderecoRequest) {
        validateBookDataInformed(enderecoRequest);

        Usuario usuario = usuarioService.findById(enderecoRequest.getUserId());
        Endereco endereco = enderecoRepository.save(Endereco.of(enderecoRequest, usuario));
        return EnderecoResponse.of(endereco);

    }

    public SuccessResponse deleteByid(Integer id) {
        validateInformedId(id);

        enderecoRepository.deleteById(id);

        return SuccessResponse
                .create(SuccessUtil.DELETE_SUCCESS);
    }

    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException(ErrorUtil.ID_EMPTY);
        }
    }

    private void validateBookDataInformed(EnderecoRequest enderecoRequest) {
        if(isEmpty(enderecoRequest.getCep())){
            throw new ValidationException(ErrorUtil.CEP_EMPTY);
        }

    }
}
