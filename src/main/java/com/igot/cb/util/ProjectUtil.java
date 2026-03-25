package com.igot.cb.util;


import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProjectUtil {

  public static ApiResponse createDefaultResponse(String api) {
    ApiResponse response = new ApiResponse();
    response.setId(api);
    response.setVer(Constants.API_VERSION_1);
    response.setParams(new ApiRespParam(UUID.randomUUID().toString()));
    response.getParams().setStatus(Constants.SUCCESS);
    response.setResponseCode(HttpStatus.OK);
    response.setTs(LocalDateTime.now().toString());
    return response;
  }

  public static Map<String, Object> createDefaultMapResponse(String api, String err, String errMsg) {
    Map<String, Object> response = new HashMap<>();
    response.put(Constants.HEALTHY, Constants.TRUE);
    response.put(Constants.NAME, api);
    response.put(Constants.ERR, err != null ? err : "");
    response.put(Constants.ERROR_MESSAGE, errMsg != null ? errMsg : "");
    return response;
  }

}
