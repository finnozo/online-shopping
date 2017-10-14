package com.isolutions4u.onlineshopping.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	    @Autowired
	    private DataSource dataSource;

	    @Value("${spring.queries.users-query}")
	    private String usersQuery;

	    @Value("${spring.queries.roles-query}")
	    private String rolesQuery;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth)
	            throws Exception {
	        auth.
	                jdbcAuthentication()
	                .usersByUsernameQuery(usersQuery)
	                .authoritiesByUsernameQuery(rolesQuery)
	                .dataSource(dataSource);
	    }
	
	
	
	
	protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/manage/**").hasAuthority("SUPPLIER")
                .anyRequest()
                .authenticated().and().formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		web
		.ignoring()
		.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}