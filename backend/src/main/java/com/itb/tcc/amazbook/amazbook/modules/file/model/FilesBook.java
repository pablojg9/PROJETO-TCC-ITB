package com.itb.tcc.amazbook.amazbook.modules.file.model;

import com.itb.tcc.amazbook.amazbook.modules.file.dto.FileRequest;
import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilesBook {

    @Id
    private Integer id;
    private String fileName;
    private Byte[] data;
    private String type;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "livro_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "livro_fk"))
    private Livro livro;

    public static FilesBook of(FileRequest fileRequest) {
        FilesBook filesBook = new FilesBook();
        BeanUtils.copyProperties(fileRequest, filesBook);
        return FilesBook
                .builder()
                .id(filesBook.getId())
                .fileName(filesBook.getFileName())
                .data(filesBook.getData())
                .type(filesBook.getType())
                .build();
    }
}
