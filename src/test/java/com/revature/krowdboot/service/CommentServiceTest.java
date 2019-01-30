package com.revature.krowdboot.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.repository.CommentRepository;
import com.revature.krowdboot.utility.MockUtility;

/*
 * @Author Moises Trevino
 */

public class CommentServiceTest {

	MockUtility mock;

	@Mock
	CommentRepository commentRepositoryMock;

	@InjectMocks
	private CommentService commentService;

	@Test
	public void testGetCommentsByFlag() {

		mock = new MockUtility();

		commentRepositoryMock = mock(CommentRepository.class);

		commentService = new CommentService();

		commentService.setCommentRepository(commentRepositoryMock);

		List<Comment> comments = mock.getCommentList();

		List<Comment> flagged = new ArrayList<>();

		for (Comment comment : comments) {
			if (comment.getFlag() == 1) {
				flagged.add(comment);
			}
		}

		when(commentRepositoryMock.getCommentsByFlag(1)).thenReturn(flagged);

		List<Comment> actual = commentService.getCommentsByFlag(1);

		assertEquals(flagged, actual);

	}

	@Test
	public void testGetAllComments() {

		mock = new MockUtility();

		commentRepositoryMock = mock(CommentRepository.class);

		commentService = new CommentService();

		commentService.setCommentRepository(commentRepositoryMock);

		List<Comment> comments = mock.getCommentList();

		when(commentRepositoryMock.findAll()).thenReturn(comments);

		List<Comment> actual = commentService.getAllComments();

		assertEquals(comments, actual);

	}

	@Test
	public void testGetCommentById() {

		mock = new MockUtility();

		commentRepositoryMock = mock(CommentRepository.class);

		commentService = new CommentService();

		commentService.setCommentRepository(commentRepositoryMock);

		int id = 1;

		Comment comment = mock.getComment();

		when(commentRepositoryMock.getOne(id)).thenReturn(comment);

		Comment actual = commentService.getCommentById(id);

		assertEquals(comment, actual);

	}

	@Ignore
	@Test
	public void testDeleteCommentById() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateAComment() {

		mock = new MockUtility();

		commentRepositoryMock = mock(CommentRepository.class);

		commentService = new CommentService();

		commentService.setCommentRepository(commentRepositoryMock);

		Comment comment = mock.getComment();

		when(commentRepositoryMock.save(comment)).thenReturn(comment);

		Comment actual = commentService.createAComment(comment);

		assertEquals(comment, actual);

	}

	@Test
	public void testUpdateComment() {

		mock = new MockUtility();

		commentRepositoryMock = mock(CommentRepository.class);

		commentService = new CommentService();

		commentService.setCommentRepository(commentRepositoryMock);

		Comment comment = mock.getComment();

		when(commentRepositoryMock.save(comment)).thenReturn(comment);

		Comment actual = commentService.updateComment(comment);

		assertEquals(comment, actual);

	}

}
