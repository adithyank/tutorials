package xyz.reachadi.custannotscanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringApp implements CommandLineRunner
{
    @Autowired
    private ClassScanner classScanner;

    public static void main(String[] args)
    {
        SpringApplication.run(SpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        Set<String> annotatedClasses = classScanner.findAnnotatedClasses(MyCustomAnnotation.class);

        for (String c : annotatedClasses)
            System.out.println("Annotated Class : " + c);
    }
}
