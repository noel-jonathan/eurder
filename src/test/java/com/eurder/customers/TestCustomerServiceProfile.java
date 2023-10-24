package com.eurder.customers;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class TestCustomerServiceProfile implements QuarkusTestProfile {
//    @Override
//    public Map<String, String> getConfigOverrides() {
//        return Collections.singletonMap("quarkus.resteasy.path","/customers");
//    }

    @Override
    public Set<Class<?>> getEnabledAlternatives() {
        return Collections.singleton(MockCustomerService.class);
    }
//
//    @Override
//    public String getConfigProfile() {
//        return "test-mocked";
//    }

//    @Override
//    public List<TestResourceEntry> testResources() {
//        return Collections.singletonList(new TestResourceEntry(CustomWireMockServerManager.class));
//    }
}
