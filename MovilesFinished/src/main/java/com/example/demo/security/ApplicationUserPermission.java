package com.example.demo.security;

public enum ApplicationUserPermission {
	TELEFONO_READ("Telefono:read"), TELEFONO_WRITE("Telefono:write");

	private final String permission;

	ApplicationUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
