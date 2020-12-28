package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.datasource.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class ExtProperty {

    @Value("${guru.user}")
    String propUser;

    @Value("${guru.password}")
    String propPwd;

    @Value("${guru.url}")
    String propUrl;

    @Bean
    public FakeDataSource fakeDataSource()
    {
        FakeDataSource obj = new FakeDataSource();
        obj.setUser(propUser);
        obj.setPassword(propPwd);
        obj.setUrl(propUrl);
        return obj;
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties()
    {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
