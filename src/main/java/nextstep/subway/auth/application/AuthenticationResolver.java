package nextstep.subway.auth.application;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import nextstep.subway.auth.domain.Authentication;
import nextstep.subway.auth.infrastructure.SecurityContext;
import nextstep.subway.auth.infrastructure.SecurityContextHolder;

public class AuthenticationResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Authentication.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }
}
