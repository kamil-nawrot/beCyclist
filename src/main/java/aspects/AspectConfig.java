package aspects;

import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableSpringConfigured
@ComponentScan(basePackages = { "aspects", "com.becyclist.model", "com.becyclist.api"})
public class AspectConfig {

	@Bean
	public StatsAspect statsAspect() {
		return Aspects.aspectOf(StatsAspect.class);
	}

	@Bean
	public InstrumentationLoadTimeWeaver loadTimeWeaver()  throws Throwable {
	    InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
	    return loadTimeWeaver;
	}
}