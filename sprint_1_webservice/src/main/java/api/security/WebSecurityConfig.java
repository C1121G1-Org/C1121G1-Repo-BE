package api.security;

import api.services.impl.AccountDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
    Created by KhaiTT
    Date: 10:45 31/05/2022
    Function: This WebSecurityConfig class extends WebSecurityConfigurerAdapter class is the security
              deployment stopper. It provides HttpSecurity profiles to configure cors, csrf, session management,
              rules for resources to be protected.
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountDetailsServiceImpl accountDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountDetailsService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
        Function: This configure() method allows requests to see which requests are accessed
                  by which method respectively.
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/public/**")
                .permitAll()
                .antMatchers("/api/employee/**").hasRole("ADMIN")
                .antMatchers("/api/storage/create", "/api/supplier/list").hasAnyRole("ADMIN", "STOREKEEPER")
                .antMatchers("/api/supplier/create").hasAnyRole("ADMIN", "STOREKEEPER", "BUSINESS_STAFF")
                .antMatchers("/api/invoiceDetail/create", "/api/updateQuantityProduct", "/api/customer/list", "/api/customer/{id}", "/api/invoice/list").hasAnyRole("ADMIN", "SELLER")
                .antMatchers("/api/qrcode/**", "/api/product/list", "/api/product/delete/{id}").hasAnyRole("ADMIN", "STOREKEEPER", "SELLER")
                .antMatchers("/api/sale-report/**", "/api/category/list", "/api/customer/report-custome", "/api/customer/info-customer/{id}", "/api/customer/report-customer-search-gender", "/api/customer/report-customer-search-age", "/api/customer/report-customer-search", "/api/customer/purchase-history/{id}", "/api/customer/purchase-products/{id}", "/api/product/create", "/api/product/{id}", "/api/product/update/{id}").hasAnyRole("ADMIN", "BUSINESS_STAFF")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
