package ar.com.opendevsolutions.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerConfig {
    @RequestMapping("/swagger-ui")
    public String redirectToUi(HttpServletRequest request) {
        return "redirect:/webjars/swagger-ui/index.html?url=http://" + request.getServerName()  + ":8180/archetype/swagger&validatorUrl=";
    }
}
