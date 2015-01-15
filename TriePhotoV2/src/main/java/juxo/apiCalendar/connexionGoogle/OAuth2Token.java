package juxo.apiCalendar.connexionGoogle;

import javax.ws.rs.client.Client;

import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow.Builder;
import org.glassfish.jersey.client.oauth2.OAuth2FlowGoogleBuilder;
import org.glassfish.jersey.client.oauth2.TokenResult;

public class OAuth2Token {
	
    public OAuth2CodeGrantFlow flow;
    public String authURI;
    public String tokenAcess;
    public String refreshToken;
    public String type; 
    public int expirationDelay;
	public static String OOB = "urn:ietf:wg:oauth:2.0:oob";
	public int statut;
    
	/***
     * Construction d'un objet token selon les spécifications google
     * @param clientId
     * @param callbackURI
     * @param scope
     */
    public OAuth2Token(ClientIdentifier clientId, String scope) {
    	Builder<OAuth2FlowGoogleBuilder> builder = 
    			OAuth2ClientSupport.googleFlowBuilder(clientId, OOB, scope);
		flow = builder
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "readOnly","true")
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION,"redirect_uri", OOB)
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "state", "")
				.scope(scope).build();
    	authURI = flow.start();
    }
    
    /**
     * Permet d'actualiser le token pour avoir accès aux données
     * Dans le cas où l'utilisateur a déjà accepté que l'application utilise les données
     * (C'est à dire qu'on a déjà obtenu un token) 
     * @param clientId
     * @param scope
     */
    public void refreshToken(ClientIdentifier clientId, String scope){
    	Builder<OAuth2FlowGoogleBuilder> builder = 
    			OAuth2ClientSupport.googleFlowBuilder(clientId, OOB, scope);
		flow = builder.build();
    	TokenResult result = flow.refreshAccessToken(refreshToken);
        this.tokenAcess = result.getAccessToken();
        String refreshtok = (String) result.getAllProperties().get("refresh_token");
        if(refreshtok!=null)
        	this.refreshToken = refreshtok; 
        this.expirationDelay = (int) result.getAllProperties().get("expires_in");
        this.type = (String) result.getAllProperties().get("token_type");
    }
    
    /***
     * Si on a déjà une clef d'accès
     * @param token
     */
    public OAuth2Token(String token) {
    	this.tokenAcess = token;
    }
    
    /***
     * On récupère l'accès après avoir fournit le code
     * @param code
     */
    public void doAccessTokenRequest(String code) {
    	TokenResult result = flow.finish(code, "");// we do not provide state
        this.tokenAcess = result.getAccessToken();
        this.refreshToken = (String) result.getAllProperties().get("refresh_token");
        this.expirationDelay = (int) result.getAllProperties().get("expires_in");
        this.type = (String) result.getAllProperties().get("token_type");
    }

    
    public String toString(){
    	String s = "";
    	s += "Token Access : " + tokenAcess + "\n";
    	s += "Refresh Access : " + refreshToken + "\n";
    	s += "Expire in : " + expirationDelay + "\n";
    	s += "Statut code : " + statut + "\n";
		return s;
    	
    }
}