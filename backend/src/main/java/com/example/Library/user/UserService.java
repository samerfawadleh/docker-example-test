package com.example.Library.user;


import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Map;

@Service
public class UserService {

    @Value("${keycloak.auth-server-url}")
    private String keycloakAuthServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${master-username}")
    private String username;

    @Value("${master-password}")
    private String password;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    @Value("${demo-realm}")
    private String demoRealm;

    public UsersResource getUsersResource() {
        Keycloak keycloak = KeycloakBuilder
                .builder()
                .serverUrl(keycloakAuthServerUrl)
                .realm(realm)
                .username(username)
                .password(password)
                .clientId("admin-cli")
                .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
                .build();

        RealmResource realmResource = keycloak.realm(demoRealm);
        return realmResource.users();

    }

    public void getUserEmail(String keycloakUserId) {
        UsersResource usersResource = getUsersResource();

        for(UserRepresentation userRepresentation : usersResource.list()) {
            System.out.println("Email :" + userRepresentation.getId());
        }

        UserResource userResource = usersResource.get(keycloakUserId);
        try{
            System.out.println(userResource.toRepresentation().getEmail());
        } catch (Exception e) {
            System.out.println("ERROR EMAIL\n" + e);
        }

        try{
            System.out.println(userResource.toRepresentation().getUsername());
        } catch (Exception e) {
            System.out.println("ERROR USERNAME\n" + e);
        }
    }

    public void createUser(User user) {
        UsersResource usersResource = getUsersResource();

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(user.getFirstName() + user.getLastName());
        userRepresentation.setEmail(user.getEmail());
        userRepresentation.setFirstName(user.getFirstName());
        userRepresentation.setLastName(user.getLastName());

        Response response = usersResource.create(userRepresentation);
//        System.out.println("PATH::: " + response.getLocation().getPath());
//        System.out.println("location::: " + response.getLocation().toString());
//
//        System.out.println("META::: " + response.getMetadata().toString());

    }

    public void updateUser(String keycloakUserId, User user) {
        UsersResource usersResource = getUsersResource();
        UserResource userResource = usersResource.get(keycloakUserId);

        UserRepresentation userRepresentation = userResource.toRepresentation();
        userRepresentation.setEmail(user.getEmail());
        userRepresentation.setFirstName(user.getFirstName());
        userRepresentation.setLastName(user.getLastName());

        userResource.update(userRepresentation);
    }

    public void resetPassword(String keycloakUserId, Map<String, Object> payload) {
        UsersResource usersResource = getUsersResource();
        UserResource userResource = usersResource.get(keycloakUserId);

//        UserRepresentation userRepresentation = userResource.toRepresentation();

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setValue(payload.get("password").toString());

        userResource.resetPassword(credentialRepresentation);
        //        CredentialRepresentation
//        userRepresentation.getCredentials().get(0).;
    }

    public void deleteUser(String keycloakUserId) {
        getUsersResource().get(keycloakUserId).remove();
    }
}
