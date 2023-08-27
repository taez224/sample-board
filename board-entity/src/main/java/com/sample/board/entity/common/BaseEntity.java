package com.sample.board.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseEntity {
    @Id
    private String id;
    @CreatedDate
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
    @Version
    private Long version;

    protected BaseEntity() {

        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    protected BaseEntity(String id) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
    }

}
