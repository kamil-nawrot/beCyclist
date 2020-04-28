package aspects;

import com.becyclist.model.StatsStorage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        Object retVal = thisJoinPoint.proceed();
        String searchTerm = (String)thisJoinPoint.getArgs()[0];
        System.out.println(searchTerm);

        if (searchTerm != null) statsStorage.setLastSearchTerm(searchTerm);

        Integer totalSearches = statsStorage.getNumberOfSearchs();
        Object[] searchTerms = thisJoinPoint.getArgs();
        ArrayList list = new ArrayList(Arrays.asList(searchTerms));
        System.out.println(list);

        Integer counter = 0;
        int[] fieldsCounter = {0, 0, 0};

        for(int i = 0; i<list.size(); i++) {
            if (list.get(i) != null) {
                fieldsCounter[i]++;
            }
        }

        System.out.println(Arrays.toString(fieldsCounter));

        statsStorage.setFieldsCounter(fieldsCounter);

        return retVal;
    }

}
