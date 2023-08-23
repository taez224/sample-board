package com.sample.board.api.post.command;

import com.sample.board.api.common.BaseRequest;
import com.sample.board.entity.post.model.PostCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPostCommand extends BaseRequest {
    //
    private PostCdo postCdo;

}
