package com.aljamaly.springsecurityplayground.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Set;
import static com.aljamaly.springsecurityplayground.security.ApplicationUserPermission.*;

@AllArgsConstructor
@Getter

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE,STUDENT_READ,STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

}
