package com.tibtof.empoweringproperties.ft.actuator

import org.springframework.boot.actuate.endpoint.annotation.Endpoint
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation
import org.springframework.boot.actuate.endpoint.annotation.Selector
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@Endpoint(id = "featuretoggles")
class FeatureToggleEndpoint(val features: Features) {

    @ReadOperation
    fun featureToggles() = features

    @ReadOperation
    fun featureToggle(@Selector name: String): Feature? = features.feature[name]

}

@Component
@ConfigurationProperties("empowering-properties")
class Features(val feature: Map<String, Feature>)

class Feature(val enabled: Boolean)
