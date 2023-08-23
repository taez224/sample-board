package com.sample.board.core.common.domain;

import java.time.LocalDateTime;

public abstract class BaseDomain extends DataTransferObject {


    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private long version;

}
