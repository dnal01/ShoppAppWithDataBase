package org.example.test_suits;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"org.example.services","org.example.repositories"})
public class TestSuitePackages {
}
