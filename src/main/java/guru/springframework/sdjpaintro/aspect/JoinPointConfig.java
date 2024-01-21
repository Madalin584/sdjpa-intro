package guru.springframework.sdjpaintro.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfig {

    @Pointcut("@annotation(guru.springframework.sdjpaintro.aspect.AuditService)")
    public void auditServiceAnnotation(){}
}
