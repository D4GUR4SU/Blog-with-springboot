package com.spring.blog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.blog.model.Post;
import com.spring.blog.repository.BlogRepository;

@Component
public class DummyData {

	@Autowired
	BlogRepository blogRepository;

	//@PostConstruct
	public void savePosts() {

		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAuthor("Douglas Souza");
		post1.setDate(LocalDate.now());
		post1.setTitle("Spring Boot");
		post1.setText(
				"Projeto blog em Spring Boot, utilizando frameworks, para autenticação, conexão com banco de dados....etc");

		Post post2 = new Post();
		post2.setAuthor("Douglas Souza");
		post2.setDate(LocalDate.now());
		post2.setTitle("API REST");
		post2.setText("Projeto blog em Spring Boot, a fim de desvendar os mistérios da arquitetura REST");

		postList.add(post1);
		postList.add(post2);

		for (Post post : postList) {
			Post postSaved = blogRepository.save(post);
			System.out.println("Post id: " + postSaved.getId());
		}
	}

}
