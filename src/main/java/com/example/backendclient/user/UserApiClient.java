package com.example.backendclient.user;

import com.example.backendclient.user.request.ListByUserIdsRequest;
import com.example.backendclient.user.response.UserResponse;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class UserApiClient {

  private static final String USERS_SEARCH_PATH = "/api/users/search";
  private static final ParameterizedTypeReference<List<UserResponse>> USER_RESPONSE_LIST_TYPE =
      new ParameterizedTypeReference<>() {};

  private final RestClient backendRestClient;

  public List<UserResponse> listByIds(List<String> ids) {
    List<UserResponse> response =
        backendRestClient
            .post()
            .uri(USERS_SEARCH_PATH)
            .body(new ListByUserIdsRequest(ids))
            .retrieve()
            .body(USER_RESPONSE_LIST_TYPE);

    return Objects.requireNonNullElse(response, List.of());
  }
}
