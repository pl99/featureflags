package ru.advantum.kotin.featureflags.config;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;
/*
Other types of activation strategies provided by the Togglz library are:

    @EnabledByDefault
    @DefaultActivationStrategy(id = SystemPropertyActivationStrategy.ID, parameters =
            { @ActivationParameter(name = SystemPropertyActivationStrategy.PARAM_PROPERTY_NAME,
            value = "tariff.feature"),
            @ActivationParameter(name = SystemPropertyActivationStrategy.PARAM_PROPERTY_VALUE, value = "true") })


UsernameActivationStrategy – allows the feature to be active for a specified list of users
UserRoleActivationStrategy – the current user's role is used to determine the state of a feature
ReleaseDateActivationStrategy – automatically activates a feature at a certain date and time
GradualActivationStrategy – enables a feature for a specified percentage of users
ScriptEngineActivationStrategy – allows the use of a custom script written in a language supported by the ScriptEngine of the JVM to determine whether a feature is active or not
ServerIpActivationStrategy – a feature is enabled based on IP addresses of the server
 */

public enum TariffFeatures implements Feature {
    @Label("Азбука вкуса тарификация")
    ALPHABET_OF_TASTY,
    @Label("Метро тарификация")
    METRO
    ;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }

    }
