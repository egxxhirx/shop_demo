package com.example.shopdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //静的リソースをセキュリティ対象外に設定
        web.ignoring().antMatchers("/webjars/**", "/css/**", "/scripts/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                //ログイン不要でアクセス可能なパス
                .antMatchers("/login").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/customer").permitAll()
                .antMatchers("/customer/index").permitAll()
                //上記以外は直リンク禁止
                .anyRequest().authenticated()
            .and()
            .formLogin()
                //ログインページ
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/customer/index", true) //ログイン成功時の遷移先
                .usernameParameter("email") //ログイン時のキー：名前
                .passwordParameter("password") //ログイン時のパスワード
                .failureUrl("/login/?error") //ログインエラー時の遷移先 ※パラメーターに「error」を付与
                .permitAll()
                .and()
                .logout()
                //ログアウト時の遷移先 POSTでアクセス
                .logoutSuccessUrl("/customer/index");
    }

       //パスワードのアルゴリズムをBCryptに設定
       @Bean
       PasswordEncoder passwordEncoder() {
           return new BCryptPasswordEncoder();
       }

    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
        
        @Autowired
        UserDetailsServiceImpl userDetailsServiceimpl;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsServiceimpl)
                .passwordEncoder(new BCryptPasswordEncoder());
        }
    }

}