package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiaoyu
 * @date 2020/6/26 - 21:20
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${server.port}")
    private String ServerPort;

    @Value("${config.info}")
    private String ConfigInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return ServerPort+"........"+ConfigInfo;
    }
}
