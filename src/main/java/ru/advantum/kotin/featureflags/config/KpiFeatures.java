package ru.advantum.kotin.featureflags.config;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;

public enum KpiFeatures implements Feature {
    @Label("Азбука вкуса расчет KPI")
    @EnabledByDefault
    KPI_ALPHABET_OF_TASTY,
    @Label("Метро расчет KPI")
    KPI_METRO;

    public boolean isActive() {
        return true;
//        FeatureContext.getFeatureManager().isActive(this);
    }

}
