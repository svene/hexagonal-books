package org.example.hexagonalarchitecture.books.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(
	packages = "org.example.hexagonalarchitecture.books",
	importOptions = {ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class}
)
public class ArchitectureTest {

	@ArchTest
	public static final ArchRule verifyOnionArchitecture = onionArchitecture()
		.adapter("http", "..adapters.http")
		.adapter("repository", "..adapters.repository")
		.applicationServices("..applicationservices..")
		.domainModels("..domain.model")
		.domainServices("..domain.ports")
		;
	@ArchTest
	public static final ArchRule httpNotPublic = noClasses()
		.that().resideInAPackage("..http..").should().bePublic()
		;

}
