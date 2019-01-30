package com.revature.krowdboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.service.CommentService;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

	private CommentService commentService;

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/getallcomments")
	public ResponseEntity<List<Comment>> getAllComments() {
		return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
	}

	@GetMapping("/getById/{getId}")
	public ResponseEntity<Comment> getCommentById(@PathVariable String getId) {
		int id = Integer.parseInt(getId);
		return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
	}

	@GetMapping("/getByFlag/{getFlag}")
	public ResponseEntity<List<Comment>> getCommentByFlag(@PathVariable String getFlag) {
		int flag = Integer.parseInt(getFlag);
		return new ResponseEntity<>(commentService.getCommentsByFlag(flag), HttpStatus.OK);
	}

	@PostMapping("/deletecomment")
	public ResponseEntity<String> deleteComment(@RequestBody String comment) {
		JSONObject js = new JSONObject(comment);
		int id = js.getInt("id");
		commentService.deleteCommentById(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@PostMapping("/createcomment")
	public ResponseEntity<String> createComment(@RequestBody Comment comment) {
		LocalDateTime ldt = LocalDateTime.now();
		String time = ldt.toString();

		comment.setTimestamp(time);
		comment.setFlag(0);

		commentService.createAComment(comment);

		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@PostMapping("/flagcomment")
	public ResponseEntity<Comment> flagComment(@RequestBody String id) {
		JSONObject js = new JSONObject(id);
		int comid = js.getInt("id");
		Comment com = commentService.getCommentById(comid);
		com.setFlag(1);
		commentService.updateComment(com);
		return new ResponseEntity<>(com, HttpStatus.OK);
	}

}
