package $package;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ${package}.assembler.${entity}ModelAssembler;
import ${package}.controller.${entity}Controller;
import ${package}.repository.${entity}Repository;
import ${package}.service.I${entity}Service;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ${entity}ModelAssembler assembler;
    @Autowired
    private ${entity}Controller controller;
    @Autowired
    private ${entity}Repository repository;
    @Autowired
    private I${entity}Service service;

    @Test
    void contextLoads() {
	assertThat(assembler).isNotNull();
	assertThat(controller).isNotNull();
	assertThat(repository).isNotNull();
	assertThat(service).isNotNull();
    }

}
