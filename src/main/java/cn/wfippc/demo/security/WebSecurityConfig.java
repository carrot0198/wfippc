package cn.wfippc.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity // 注解开启Spring Security的功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	UserDetailsService myUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }
	@Autowired
	MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

	@Autowired
	MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 解决静态资源被拦截的问题
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/js/**");
		web.ignoring().antMatchers("/images/**");
		web.ignoring().antMatchers("/lib/**");
		web.ignoring().antMatchers("/fonts/**");
		web.ignoring().antMatchers("/lang/**");
		web.ignoring().antMatchers("/login/**");
		web.ignoring().antMatchers("/login.html");
		// 解决服务注册url被拦截的问题
		web.ignoring().antMatchers("/swagger-resources/**");
		web.ignoring().antMatchers("/v2/**");
		web.ignoring().antMatchers("/**/*.json");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserService()); //user Details Service验证

    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/index.html")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
   	 	filter.setEncoding("UTF-8"); filter.setForceEncoding(true);
   	 	http.addFilterBefore(filter, CsrfFilter.class);
	}
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().anyRequest().authenticated().and().formLogin()
	 * .failureHandler(myAuthenctiationFailureHandler) // 自定义登录失败处理
	 * .successHandler(myAuthenctiationSuccessHandler) // 自定义登录成功处理
	 * .and().authorizeRequests() // 定义哪些url需要保护，哪些url不需要保护
	 * .anyRequest().authenticated().and().sessionManagement().maximumSessions(1).
	 * and().and().logout()
	 * .logoutUrl("/logout").and().formLogin().loginPage("/index.html") //
	 * 定义当需要用户登录时候，转到的登录页面
	 * .permitAll().defaultSuccessUrl("/home.html").permitAll().and().logout().
	 * permitAll() // 自动登录 .and().rememberMe(); http.csrf().disable(); // 解决中文乱码问题
	 * CharacterEncodingFilter filter = new CharacterEncodingFilter();
	 * filter.setEncoding("UTF-8"); filter.setForceEncoding(true);
	 * http.addFilterBefore(filter, CsrfFilter.class); }
	 */

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.inMemoryAuthentication().withUser("admin").password("12345678").roles(
	 * "USER"); // 在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER }
	 */
}
