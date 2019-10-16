package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth);
		
//		using user details service
		auth.userDetailsService(userDetailsService);
		
//		set the configuration to the auth object using in memory authentication
//		auth.inMemoryAuthentication()
//			.withUser("user").password("pass").roles("USER")
//			.and()
//			.withUser("admin").password("admin").roles("ADMIN");
		
//		set the configuration to the auth object using jdbc authentication
//		auth.jdbcAuthentication()
//			.dataSource(dataSource);
//			.usersByUsernameQuery("select username,password,enabled "
//					+ "from users "
//					+ "where username = ?")
//			.authoritiesByUsernameQuery("select username,authority "
//					+ "from authorities "
//					+ "where username = ?");
			
//		using default schema and populating users
//		following comes after .dataSource(dataSource)
//			.withDefaultSchema()
//			.withUser(
//					User.withUsername("user")
//					.password("pass")
//					.roles("USER")
//			)
//			.withUser(
//					User.withUsername("admin")
//					.password("admin")
//					.roles("ADMIN")
//			);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("USER", "ADMIN")
			.antMatchers("/").permitAll()
			.and().formLogin();
	}
}
