package com.sample.board.domain.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;


@Getter
@Setter
public abstract class AuditEntity extends BaseEntity {

    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifiedBy;
}
