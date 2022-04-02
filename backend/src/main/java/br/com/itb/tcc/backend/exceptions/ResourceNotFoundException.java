package br.com.itb.tcc.backend.exceptions;

import br.com.itb.tcc.backend.utils.MessageUtil;

public class ResourceNotFoundException extends RuntimeException {

    // TODO - NOT FOUND USER

    public ResourceNotFoundException() {
        super(MessageUtil.NOT_FOUND_USER);
    }
}
