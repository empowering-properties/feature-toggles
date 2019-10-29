package com.tibtof.empoweringproperties

 import org.springframework.boot.autoconfigure.SpringBootApplication
 import org.springframework.boot.autoconfigure.domain.EntityScan
 import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.tibtof.empoweringproperties.core")
class EmpoweringPropertiesApplication

fun main(args: Array<String>) {
	runApplication<EmpoweringPropertiesApplication>(*args)
}
