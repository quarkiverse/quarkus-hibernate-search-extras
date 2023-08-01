package io.quarkus.hibernate.search.orm.elasticsearch.aws.runtime;

import java.util.Map;

import io.quarkus.hibernate.orm.runtime.PersistenceUnitUtil;
import io.quarkus.runtime.annotations.ConfigDocMapKey;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithParentName;
import io.smallrye.config.WithUnnamedKey;

@ConfigMapping(prefix = "quarkus.hibernate-search-orm")
@ConfigRoot(phase = ConfigPhase.RUN_TIME)
public interface HibernateSearchOrmElasticsearchAwsRuntimeConfig {

    /**
     * Configuration for persistence units.
     */
    @WithParentName
    @WithUnnamedKey(PersistenceUnitUtil.DEFAULT_PERSISTENCE_UNIT_NAME)
    @ConfigDocMapKey("persistence-unit-name")
    Map<String, HibernateSearchOrmElasticsearchAwsRuntimeConfigPersistenceUnit> persistenceUnits();

}
