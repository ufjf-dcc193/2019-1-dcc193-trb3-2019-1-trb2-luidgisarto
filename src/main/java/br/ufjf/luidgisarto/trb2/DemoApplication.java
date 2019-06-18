package br.ufjf.luidgisarto.trb2;

import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.repositories.AreaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		AreaRepository areaRepository = ctx.getBean(AreaRepository.class);

		areaRepository.deleteAll();

		for (int i = 1; i < 6; i++) {
			Area a = new Area("Area " + i);

			areaRepository.save(a);
		}
	}

}
