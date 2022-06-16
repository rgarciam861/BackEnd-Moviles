package com.example.demo.security;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRol {

	 ADMIN(ApplicationUserPermission.TELEFONO_READ,ApplicationUserPermission.TELEFONO_WRITE),
	    GUEST(ApplicationUserPermission.TELEFONO_READ);
	    private final Set<ApplicationUserPermission> permissions;
	    
	    ApplicationUserRol(ApplicationUserPermission ...permisions) {
	    	this.permissions= new HashSet();
	    	for (ApplicationUserPermission applicationUserPermission : permisions) {
	    		this.permissions.add(applicationUserPermission);
			}
	    }
	    
	    public Set<ApplicationUserPermission> getPermissions() {
	        return permissions;
	    }

	    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
	        Set<SimpleGrantedAuthority> permissionsAuth = getPermissions().stream()
	                //el map crea una nueva lista donde sustituye cada permiso por una authority de tipo simple
	                //recuerda que getPermision() te da "student:read" o algo asi
	                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
	                .collect(Collectors.toSet());
	        //le add el usuario actual de la enumeracion y volvemos al ApllicationSecurityConfig
	        permissionsAuth.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
	        return permissionsAuth;
	    }
}
