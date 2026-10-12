package io.quarkus.hibernate.search.elasticsearch.aws.test.configuration;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusExtensionTest;

public class MissingRegionSigningEnabledNoIndexedEntityTest {

    @RegisterExtension
    static final QuarkusExtensionTest config = new QuarkusExtensionTest().setArchiveProducer(
            () -> ShrinkWrap.create(JavaArchive.class).addClass(NonIndexedEntity.class))
            .withConfigurationResource("application.properties")
            .overrideConfigKey("quarkus.hibernate-search-orm.elasticsearch.aws.signing.enabled", "true");

    @Test
    public void testNoConfig() {
        // Just check there are no exceptions on startup, on contrary to MissingRegionSigningEnabledTest
    }
}
