package ru.smal.sm.currency.rate.facade.model;

public enum RateType {

    CBR("cbr");

    private final String serviceName;

    RateType(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
