package aspects;

import com.becyclist.model.StatsStorage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StatsAspect {

    StatsStorage statsStorage = StatsStorage.getInstance();

    @After("execution(* com.becyclist.api.EventApiController.addEvent(..))")
    public void countEvents () throws Throwable {
        System.out.println("Event added!");
        statsStorage.increaseNumberOfEvents();
    }

    @After("execution(* com.becyclist.api.EventApiController.findAllEvents(..))")
    public void allEvents () throws Throwable {
        System.out.println("Search performed!");
        statsStorage.increaseNumberOfSearchs();
    }
}
