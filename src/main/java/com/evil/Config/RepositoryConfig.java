package com.evil.Config;

import com.evil.Entity.Review;
import com.evil.Entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Configures repositories.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    /**
     * Configures review and user repositories to expose IDs.
     *
     * @param config    Config
     */
    @Override
    public void configureRepositoryRestConfiguration
            (RepositoryRestConfiguration config) {
        config.exposeIdsFor(Review.class, User.class);
    }
}
