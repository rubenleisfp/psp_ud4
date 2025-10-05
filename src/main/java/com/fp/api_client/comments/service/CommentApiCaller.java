package com.fp.api_client.comments.service;





import com.fp.api_client.comments.domain.Comment;
import com.fp.api_client.comments.domain.CommentPage;
import com.fp.api_client.comments.domain.NewCommentDto;

import java.io.IOException;


public interface CommentApiCaller {

	CommentPage getAllComments() throws IOException, InterruptedException, ApiCallException;

	Comment getComment(int id) throws IOException, InterruptedException, ApiCallException;

	CommentPage getCommentsByPostId(int postId) throws IOException, InterruptedException, ApiCallException;

	Comment addComment(NewCommentDto comment) throws IOException, InterruptedException, ApiCallException;

	Comment updateComment(int id, Comment updatedComment) throws IOException, InterruptedException, ApiCallException;

	Comment deleteComment(int id) throws IOException, InterruptedException, ApiCallException;

	CommentPage getComments(int limit, int skip, String selection) throws ApiCallException, IOException, InterruptedException;
}