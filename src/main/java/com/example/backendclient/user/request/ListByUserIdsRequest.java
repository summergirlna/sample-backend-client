package com.example.backendclient.user.request;

import java.util.List;

public record ListByUserIdsRequest(List<String> userIds) {}
