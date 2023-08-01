package io.quarkus.hibernate.search.orm.elasticsearch.aws.runtime;

import java.util.Map;
import java.util.Optional;

import io.quarkus.amazon.common.runtime.AwsCredentialsProviderConfig;
import io.quarkus.runtime.annotations.ConfigDocMapKey;
import io.quarkus.runtime.annotations.ConfigGroup;
import io.smallrye.config.WithName;
import io.smallrye.config.WithUnnamedKey;
import software.amazon.awssdk.regions.Region;

@ConfigGroup
public interface HibernateSearchOrmElasticsearchAwsRuntimeConfigPersistenceUnit {

    /**
     * Configuration for backends.
     */
    @WithName("elasticsearch")
    @WithUnnamedKey // The default backend has the null key
    @ConfigDocMapKey("backend-name")
    Map<String, ElasticsearchBackendRuntimeConfig> backends();

    @ConfigGroup
    interface ElasticsearchBackendRuntimeConfig {

        /**
         * AWS services configurations
         */
        ElasticsearchBackendAwsConfig aws();

    }

    @ConfigGroup
    interface ElasticsearchBackendAwsConfig {

        /**
         * Configuration for signing.
         */
        ElasticsearchBackendAwsSigningConfig signing();

        // @formatter:off
        /**
         * An Amazon Web Services region that hosts the Elasticsearch service.
         *
         * Must be provided if signing is enabled; the region won't be automatically detected.
         *
         * See `software.amazon.awssdk.regions.Region` for available regions.
         *
         * @asciidoclet
         */
        // @formatter:on
        Optional<Region> region();

        /**
         * Defines the credentials provider.
         */
        AwsCredentialsProviderConfig credentials();

    }

    @ConfigGroup
    interface ElasticsearchBackendAwsSigningConfig {

        /**
         * Whether requests should be signed using the AWS credentials.
         */
        boolean enabled();

    }

}
