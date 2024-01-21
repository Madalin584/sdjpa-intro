package guru.springframework.sdjpaintro.aspect;

import guru.springframework.sdjpaintro.domain.Audit;
import guru.springframework.sdjpaintro.repositories.AuditRepository;
import guru.springframework.sdjpaintro.services.BookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

@Aspect
@Configuration
public class AopConfigAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AuditRepository auditRepository;

    @Autowired
    public AopConfigAspect(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @AfterReturning(value = "guru.springframework.sdjpaintro.aspect.JoinPointConfig.auditServiceAnnotation()",
            returning = "result"
    )
    public void testAnnotation(JoinPoint joinPoint, Object result) {
        logger.info(" short string  {}", joinPoint.toShortString());

        Audit audit = new Audit("GET", joinPoint.toShortString(), new Timestamp(System.currentTimeMillis()), result.toString());
        auditRepository.save(audit);
    }
}
