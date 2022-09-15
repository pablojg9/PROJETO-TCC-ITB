package com.itb.tcc.amazbook.amazbook.modules.user.controller;

import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioRequest;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioResponse;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import com.itb.tcc.amazbook.amazbook.modules.user.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping(value = "/save")
    public ResponseEntity<UsuarioResponse> save(@RequestBody @Valid UsuarioRequest usuarioRequest) {

        Usuario user = new Usuario();
        user.setSenha(new BCryptPasswordEncoder().encode(usuarioRequest.getSenha()));

        return ResponseEntity.ok(usuarioService.save(usuarioRequest));
    }
}
