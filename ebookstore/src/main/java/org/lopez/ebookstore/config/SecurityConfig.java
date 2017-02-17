package org.lopez.ebookstore.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.authoritiesByUsernameQuery("SELECT username, authority From authorities WHERE username = ?")
			.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().mvcMatchers("/").permitAll()
			.mvcMatchers("/admin/**").access("hasRole('ADMIN')")
			.and().formLogin().loginPage("/login")
			.defaultSuccessUrl("/admin")
			.usernameParameter("username")
			.passwordParameter("password")
			.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
}
