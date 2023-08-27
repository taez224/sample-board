package com.sample.board.api.comment.command;

import com.sample.board.api.common.BaseRequest;
import com.sample.board.core.comment.model.CommentCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCommentCommand extends BaseRequest {
    //
    private CommentCdo commentCdo;

}
