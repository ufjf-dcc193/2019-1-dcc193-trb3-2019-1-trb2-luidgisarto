package br.ufjf.luidgisarto.trb2;

import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.models.Avaliador;
import br.ufjf.luidgisarto.trb2.models.Trabalho;
import br.ufjf.luidgisarto.trb2.repositories.AreaRepository;
import br.ufjf.luidgisarto.trb2.repositories.AvaliadorRepository;
import br.ufjf.luidgisarto.trb2.repositories.TrabalhoRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		AreaRepository areaRepository = ctx.getBean(AreaRepository.class);

		TrabalhoRepository trabalhoRepository = ctx.getBean(TrabalhoRepository.class);

		AvaliadorRepository avaliadorRepository = ctx.getBean(AvaliadorRepository.class);

		areaRepository.deleteAll();

		for (int i = 1; i < 6; i++) {
			Area a = new Area("Area " + i);

			areaRepository.save(a);
		}

		Area area = areaRepository.findAll().get(0);

		trabalhoRepository.save(new Trabalho("Trabalho 1", "Trabalho 1", area));
		trabalhoRepository.save(new Trabalho("Trabalho 2", "Trabalho 2", area));
		trabalhoRepository.save(new Trabalho("Trabalho 3", "Trabalho 3", area));
		trabalhoRepository.save(new Trabalho("Trabalho 4", "Trabalho 4", area));
		trabalhoRepository.save(new Trabalho("Trabalho 5", "Trabalho 5", area));

		avaliadorRepository.save(new Avaliador("Avaliador 1", area));
	}

}
