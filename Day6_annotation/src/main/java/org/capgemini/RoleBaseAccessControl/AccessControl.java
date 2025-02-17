package org.capgemini.RoleBaseAccessControl;
import java.util.Set;
import java.lang.reflect.Method;

public class AccessControl {

    public static boolean hasAccess(User user, Method method) {
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            Set<String> userRoles = user.getRoles();
            for (String role : roleAllowed.value()) {
                if (userRoles.contains(role)) {
                    return true; // User has one of the required roles
                }
            }
            return false; // User lacks required roles
        }
        return true; // No RoleAllowed annotation; allow access
    }
}

 class User {
    private String username;
    private Set<String> roles;

    public User(String username, Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getRoles() {
        return roles;
    }
}

