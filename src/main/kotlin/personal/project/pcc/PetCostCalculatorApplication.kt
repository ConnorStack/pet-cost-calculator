package personal.project.pcc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PetCostCalculatorApplication

fun main(args: Array<String>) {
	runApplication<PetCostCalculatorApplication>(*args)
}
