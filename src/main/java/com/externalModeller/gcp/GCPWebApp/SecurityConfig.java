package com.externalModeller.gcp.GCPWebApp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
//@PropertySource("classpath:application.properties")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	private static List<String> clients = Arrays.asList("google");
		
//	private static String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";
		
//	@Autowired
//    private Environment env;
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated()
//	      .and()
//	      .oauth2Login()
//	      .clientRegistrationRepository(clientRegistrationRepository())
//	      .authorizedClientService(authorizedClientService());
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().antMatcher("/**").authorizeRequests()
        .antMatchers("/","/index").authenticated()
        .anyRequest().authenticated()
        .and()
        .oauth2Login().loginPage("/").permitAll()
        .and()
        .logout()
        .logoutSuccessUrl("/");
	}
	
	
//	
//	@Bean
//	public OAuth2AuthorizedClientService authorizedClientService() {
//	 
//	    return new InMemoryOAuth2AuthorizedClientService(
//	      clientRegistrationRepository());
//	}
//	
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        List<ClientRegistration> registrations = clients.stream()
//          .map(c -> getRegistration(c))
//          .filter(registration -> registration != null)
//          .collect(Collectors.toList());
//        
//        return new InMemoryClientRegistrationRepository(registrations);
//    }
//    
//    private ClientRegistration getRegistration(String client) {
//        String clientId = env.getProperty(
//          CLIENT_PROPERTY_KEY + client + ".client-id");
//
//        if (clientId == null) {
//            return null;
//        }
//
//        String clientSecret = env.getProperty(
//          CLIENT_PROPERTY_KEY + client + ".client-secret");
//     
//        if (client.equals("google")) {
//            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
//              .clientId(clientId).clientSecret(clientSecret).build();
//        }
//        return null;
//    }
//    
//	@Bean
//	public ClientRegistrationRepository clientRegistrationRepository() {
//		return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
//	}
//
//	private ClientRegistration googleClientRegistration() {
//		return ClientRegistration.withRegistrationId("google")
//				.clientId("439378483548-l995nd0fgpqvvl95br9tf67nl0l10a45.apps.googleusercontent.com")
//				.clientSecret("2x8iBRJqvayWbUEWk9f9qWNB")
//				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//				.redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
//				.scope("openid", "profile", "email", "address", "phone")
//				.authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
//				.tokenUri("https://www.googleapis.com/oauth2/v4/token")
//				.userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//				.userNameAttributeName(IdTokenClaimNames.SUB).jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
//				.clientName("Google").build();
//	}

}
