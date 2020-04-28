package aspects;

import com.becyclist.model.StatsStorage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class StatsAspect {

    StatsStorage statsStorage = StatsStorage.getInstance();

    @After("execution(* com.becyclist.api.EventApiController.addEvent(..))")
    public void countEvents() throws Throwable {
        System.out.println("Event added!");
        statsStorage.increaseNumberOfEvents();
    }

    @After("execution(* com.becyclist.api.EventApiController.findAllEvents(..))")
    public void allEvents() throws Throwable {
        System.out.println("Search performed!");
        statsStorage.increaseNumberOfSearchs();
    }

    @Around("execution(* com.becyclist.api.EventApiController.findAllEvents(..))")
    public Object lastSearchTerm(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        System.out.println("Last term search aspect - before");
        Object retVal = thisJoinPoint.proceed();
        String searchTerm = (String)thisJoinPoint.getArgs()[0];
        System.out.println(searchTerm);

        statsStorage.setLastSearchTerm(searchTerm);

        System.out.println("Last term search aspect - after");
        return retVal;
    }

}
