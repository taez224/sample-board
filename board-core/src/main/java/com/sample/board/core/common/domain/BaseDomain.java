package com.sample.board.core.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseDomain extends DataTransferObject {


    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private long version;

}
