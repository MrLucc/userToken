package br.pratiqs.todolist;

import br.pratiqs.todolist.entity.toDoEt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSucess() {
        var toDoEt = new toDoEt();

		webTestClient.post().uri("/todos")
				.bodyValue(toDoEt)
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(toDoEt.getNome())
				.jsonPath("$[0].discricao").isEqualTo(toDoEt.getDiscricao())
				.jsonPath("$[0].realizado").isEqualTo(toDoEt.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(toDoEt.getPrioridade());

    }

	@Test
	void testCreateTodoFailue(){

	}
}
