package api.security;

import api.models.Account;
import api.services.IAccountService;
import api.services.impl.AccountDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    Created by KhaiTT
    Date: 17:08 31/05/2022
    Function: This JwtFilter class extends OncePerRequestFilter class to override method doFilterInternal()
*/
@Component
public class JwtFilter extends OncePerRequestFilter {
    private String jwtToken;
    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AccountDetailsServiceImpl accountDetailsService;

    @Autowired
    private IAccountService iAccountService;

    /*
        Function: This doFilterInternal() method is used to filter requests from clients and it will run
                  before entering the methods that the client calls it via the url.
    */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getTokenFromRequest(request);
            if (token != null && jwtUtility.validateJwtToken(token)) {
                // save token to jwtToken variable to use in findAccountByJwtToken() method below
                jwtToken = token;
                UserDetails userDetails = accountDetailsService.loadUserByUsername(token);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }
        filterChain.doFilter(request, response);
    }

    /*
        Function: This getTokenFromRequest() method is used to get jwt code from request.
    */
    private String getTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7, token.length());
        }
        return null;
    }

    /*
        Function: This findAccountByJwtToken() method is used to find account object by jwt.
    */
    public Account findAccountByJwtToken() {
        String username = jwtUtility.getUserNameFromJwtToken(jwtToken);
        return iAccountService.findByUserName(username);
    }
}
