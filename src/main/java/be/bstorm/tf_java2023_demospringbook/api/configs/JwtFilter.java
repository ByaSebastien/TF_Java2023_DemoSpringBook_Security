package be.bstorm.tf_java2023_demospringbook.api.configs;

import be.bstorm.tf_java2023_demospringbook.api.utils.JwtUtils;
import be.bstorm.tf_java2023_demospringbook.bll.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtils utils;

    private final UserService userService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");
        //Bearer nfdsklnglkdnslknglkdfncslkgnlkdnsqlkgmvms
        if(authorization != null){
            String[] authorizations = authorization.split(" ");
            String type = authorizations[0];
            String token = authorizations[1];
            if(type.equals("Bearer") && !token.equals("")){
                if(utils.isValid(token)){
                    String email = utils.getEmail(token);
                    UserDetails user = userService.loadUserByUsername(email);
                    UsernamePasswordAuthenticationToken upt = new UsernamePasswordAuthenticationToken(user,token,user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(upt);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
