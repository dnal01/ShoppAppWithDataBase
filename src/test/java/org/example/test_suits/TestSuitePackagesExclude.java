package org.example.test_suits;

import org.example.repositories.ProductRepositoryTest;
import org.example.repository.impl.ProductRepository;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
@Suite
@SelectPackages({"org.example.repositories", "org.example.services"})
@ExcludeClassNamePatterns({
        "ProductRepositoryTest"
})
public class TestSuitePackagesExclude {
}
