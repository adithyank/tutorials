package xyz.reachadi.custannotscanner;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

@Component
public class ClassScanner
{
    public Set<String> findAnnotatedClasses(Class<? extends Annotation> annotationType, String... packages)
    {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(annotationType));

        Set<String> ret = new HashSet<>();

        for (String pkg : packages)
        {
            Set<BeanDefinition> beanDefs = provider.findCandidateComponents(pkg);
            beanDefs.stream()
                    .map(BeanDefinition::getBeanClassName)
                    .forEach(ret::add);
        }

        return ret;
    }
}
