package com.becyclist.configuration;

import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;
import com.fasterxml.jackson.datatype.threetenbp.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.threetenbp.deser.LocalTimeDeserializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.threeten.bp.*;

@Configuration
public class JacksonConfiguration {

    @Bean
    @ConditionalOnMissingBean(ThreeTenModule.class)
    ThreeTenModule threeTenModule() {
        ThreeTenModule module = new ThreeTenModule();
        module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
        module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
        module.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);
        module.addDeserializer(LocalDate.class, LocalDateDeserializer.INSTANCE);
        module.addDeserializer(LocalTime.class, LocalTimeDeserializer.INSTANCE);
        return module;
    }
}
