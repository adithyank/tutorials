package xyz.reachadi.custannotscanner;

import org.springframework.stereotype.Component;

@Component
public class Square
{
    @MyCustomAnnotation
    @Component
    public static class Rectangle
    {

    }

    @MyCustomAnnotation
    @Component
    public static class Circle
    {

    }
}
