package com.itb.tcc.amazbook.amazbook.modules.file.repository;

import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FilesBook, Integer> {
}
