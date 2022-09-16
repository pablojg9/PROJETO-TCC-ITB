package com.itb.tcc.amazbook.amazbook.modules.user.controller;

import com.itb.tcc.amazbook.amazbook.exceptions.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioRequest;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioResponse;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import com.itb.tcc.amazbook.amazbook.modules.user.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping(value = "/save")
    public ResponseEntity<UsuarioResponse> save(@RequestBody @Valid UsuarioRequest usuarioRequest) {

        Usuario user = new Usuario();
        user.setSenha(new BCryptPasswordEncoder().encode(usuarioRequest.getSenha()));

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioRequest));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findByIdResponse(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessResponse> deleteById(@PathVariable @Valid Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.deleteById(id));
    }

}
