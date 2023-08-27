package com.sample.board.api.post.rest;

import com.sample.board.api.common.BaseResponse;
import com.sample.board.core.post.model.PostDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;


@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
@DisplayName("Post Controller Test")
class PostControllerTest {
    //
    private WebTestClient webTestClient;

    @Mock
    private PostController postController;

    private final String sampleId = "sample-id";

    @BeforeEach
    public void beforeEach() {
        //
        this.webTestClient = WebTestClient
                .bindToController(this.postController)
                .build();
    }

    @Test
    @DisplayName("Mock Client Test - findPostById")
    public void findPostById() {
        //
        PostDetail expectedResult = PostDetail.sample(sampleId);

		// given
        Mockito.when(postController.findPostById(ArgumentMatchers.anyString()))
                .thenAnswer((Answer<BaseResponse<PostDetail>>) invocation -> {
                    if (sampleId.equals(invocation.getArgument(0))) {
                        return BaseResponse.of(expectedResult);
                    }
                    return null;
                });

		// when
        WebTestClient.ResponseSpec responseSpec = webTestClient
                .get()
                .uri("/api/posts/" + sampleId)
                .exchange();

        // then
        PostDetail result = responseSpec
                .expectStatus().isOk()
                .expectBody(PostDetail.class)
                .returnResult().getResponseBody();

        Assertions.assertNotNull(result, "result is null!");
        Assertions.assertEquals(expectedResult.getId(), result.getId());
    }

}
