package ma.millergraphics.it.Stock.security.configuration;

import lombok.AllArgsConstructor;
import ma.millergraphics.it.Stock.model.bo.Utilisateur;
import ma.millergraphics.it.Stock.model.service.UtilisateurService;
import ma.millergraphics.it.Stock.security.filter.JwtAuthenticationFilter;
import ma.millergraphics.it.Stock.security.filter.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UtilisateurService utilisateurService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Utilisateur user=utilisateurService.loadByUsername(username);
                Collection<GrantedAuthority> authorities=new ArrayList<>();
                user.getRoles().forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority(role.getDesignation()));
                });
                return new User(user.getUsername(),user.getPassword(),authorities);
            }
        });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    void plaquesAndConsomablesAuhorities(String resources,HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/"+resources+"/**").hasAuthority("responsable production");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/"+resources+"/**").hasAuthority("operateur production");
        if(resources.equals("consomables")) {
            http.authorizeRequests().antMatchers(HttpMethod.GET, "/" + resources + "/**").hasAnyAuthority("operateur production","commercial");
            http.authorizeRequests().antMatchers(HttpMethod.PUT, "/" + resources + "/**").hasAnyAuthority("operateur production","commercial");
            http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/" + resources + "/**").hasAnyAuthority("operateur production","commercial");
        }else{
            http.authorizeRequests().antMatchers(HttpMethod.GET, "/" + resources + "/**").hasAuthority("operateur production");
            http.authorizeRequests().antMatchers(HttpMethod.PUT, "/" + resources + "/**").hasAuthority("operateur production");
            http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/" + resources + "/**").hasAuthority("operateur production");
        }
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.headers().frameOptions().disable();
        http.formLogin().disable();
        //http.authorizeRequests().antMatchers("/users/refreshToken/**").permitAll();
        /*http.authorizeRequests().antMatchers(HttpMethod.POST,"/users/**").hasAuthority("admin");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/**").hasAuthority("user");*/
        http.authorizeRequests().antMatchers("/listPlaques/**").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/listConsomables/{id}/categorie/**").hasAnyAuthority("operateur production","commercial");
        http.authorizeRequests().antMatchers("/listConsomables/**").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/utilisateurs/search/byUsername/**").hasAnyAuthority("operateur production","commercial");
        http.authorizeRequests().antMatchers("/utilisateurs/{id}/utilisateurPlaques/**").hasAuthority("operateur production");
        http.authorizeRequests().antMatchers("/utilisateurs/{id}/utilisateurConsomables/**").hasAuthority("operateur production");
        http.authorizeRequests().antMatchers("/utilisateurs/**").hasAuthority("admin");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/consomables/**").hasAnyAuthority("operateur production","commercial");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/consomables/**").hasAnyAuthority("operateur production","commercial");
        http.authorizeRequests().antMatchers("/utilisateurConsomables/**").hasAuthority("operateur production");
        http.authorizeRequests().antMatchers("/utilisateurPlaques/**").hasAuthority("operateur production");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/ligneCommandes/**").hasAuthority("commercial");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/ligneCommandes/**").hasAuthority("commercial");
        plaquesAndConsomablesAuhorities("plaques",http);
        plaquesAndConsomablesAuhorities("consomables",http);
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new JwtAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new JwtAuthorizationFilter(),
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
