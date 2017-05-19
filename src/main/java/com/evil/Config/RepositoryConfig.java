package com.evil.Config;

import com.evil.Entity.Review;
import com.evil.Entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0518
 * @since 1.7
 */

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration
            (RepositoryRestConfiguration config) {
        config.exposeIdsFor(Review.class, User.class);
    }
}
