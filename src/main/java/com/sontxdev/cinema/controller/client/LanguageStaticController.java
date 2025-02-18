package com.sontxdev.cinema.controller.client;

import com.sontxdev.cinema.configuration.languageconfig.Translator;
import com.sontxdev.cinema.dto.response.ApiResponse;
import com.sontxdev.cinema.dto.response.LanguageStaticHomeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lang")
public class LanguageStaticController {

    @GetMapping("/home")
    public ApiResponse<LanguageStaticHomeResponse> getHomeContent() {

        // Sử dụng builder và gán giá trị vào đối tượng response
        LanguageStaticHomeResponse response = LanguageStaticHomeResponse.builder()
                .headerVipContent1(Translator.toLocale("header.vip.content.1"))
                .headerVipContent2(Translator.toLocale("header.vip.content.2"))
                .headerVipContent3(Translator.toLocale("header.vip.content.3"))
                .headerVipContent4(Translator.toLocale("header.vip.content.4"))
                .build();

        // Trả về ApiResponse chứa response
        return ApiResponse.<LanguageStaticHomeResponse>builder()
                .result(response)
                .build();
    }
}
