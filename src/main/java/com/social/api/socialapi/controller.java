package com.social.api.socialapi;

import com.social.api.socialapi.dao.*;
import com.social.api.socialapi.entity.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class controller {
    private userJpaRepo userJpaRepo;
    private PostJpaRepo postJpaRepo;
    private ReactionJpaRepo reactionJpaRepo;
    private CommentJpaRepo commentJpaRepo;
    private cm2JpaRepo cm2JpaRepo;





    public controller(com.social.api.socialapi.dao.userJpaRepo userJpaRepo, PostJpaRepo postJpaRepo,ReactionJpaRepo reactionJpaRepo,CommentJpaRepo commentJpaRepo,cm2JpaRepo cm2JpaRepo) {
        this.userJpaRepo = userJpaRepo;
        this.postJpaRepo = postJpaRepo;
        this.reactionJpaRepo = reactionJpaRepo;
        this.commentJpaRepo = commentJpaRepo;
        this.cm2JpaRepo = cm2JpaRepo;

    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userJpaRepo.findAll();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id ) throws UserNotFoundException {
        User cuser=null;
        Optional<User> user=userJpaRepo.findById(id);
        if (user.isPresent()){
            cuser=user.get();
            return cuser;
        }
        throw  new UserNotFoundException("not found");
    }
    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Integer id){
            userJpaRepo.deleteById(id);
    }

    @PostMapping("/users")
    public void addPost(@RequestBody User user){
        userJpaRepo.save(user);
    }
    @GetMapping("/posts")
    public List<Post> getAllPost(){
        return postJpaRepo.findAll();
    }
    @GetMapping("/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable Integer id){
        Optional<User> user=userJpaRepo.findById(id);
        User user1=null;
        if (user.isPresent()){
            user1=user.get();
            return user1.getPosts();

        }
        throw  new UserNotFoundException("not found");


    }
    @PostMapping("/users/{id}/posts")
    public void addPost(@PathVariable Integer id,@RequestBody Post post){

        Optional<User> user=userJpaRepo.findById(id);
        User user1=null;
        if (user.isPresent()){
            user1=user.get();
            post.setUser(user1);

            postJpaRepo.save(post);

        }
        throw  new UserNotFoundException("not found");



    }
    @GetMapping("/posts/{id}")
    public Post getPostBYId(@PathVariable Integer id){
        Optional<Post> post=postJpaRepo.findById(id);
        Post post1=null;
        if (post.isPresent()){
            post1=post.get();
            post1.setReactionCount(post1.getReaction().size());
            post1.setCommentCount(post1.getComment().size());
            return post1;

        }
        throw  new PostNotFoundException("not found");


    }
    @GetMapping("/posts/{id}/reaction")
    public List<Reaction> getPostReaction(@PathVariable Integer id){
        Optional<Post> post=postJpaRepo.findById(id);
        Post post1=null;
        if (post.isPresent()){
            post1=post.get();

            return post1.getReaction();

        }
        throw  new PostNotFoundException("not found");


    }

    @GetMapping("/posts/{id}/reactionCount")
    public Object getPostReactionCount(@PathVariable Integer id){
        Optional<Post> post=postJpaRepo.findById(id);
        Post post1=null;
        if (post.isPresent()){
            post1=post.get();
            return post1.getReaction().size();

        }
        throw  new PostNotFoundException("not found");


    }


    @PostMapping("/posts/{id}/reaction")
    public void addReaction(@PathVariable Integer id,@RequestBody Reaction reaction){

        Optional<Post> post=postJpaRepo.findById(id);
        Post post1=null;
        if (post.isPresent()){
            post1=post.get();
            reaction.setPost(post1);
           reactionJpaRepo.save(reaction);

        }else {
            throw new PostNotFoundException("not found");

        }

    }


    @GetMapping("/posts/{id}/comment")
    public List<Comment> getPostComment(@PathVariable Integer id){
        Optional<Post> post=postJpaRepo.findById(id);
        Post post1=null;
        if (post.isPresent()){
            post1=post.get();
            return post1.getComment();

        }
        throw  new PostNotFoundException("not found");


    }
    @GetMapping("/posts/{id}/commentCount")
    public Object getPostCommentCount(@PathVariable Integer id){
        Optional<Post> post=postJpaRepo.findById(id);
        Post post1=null;
        if (post.isPresent()){
            post1=post.get();
            return post1.getComment().size();

        }
        throw  new PostNotFoundException("not found");


    }
    @PostMapping("/posts/{id}/comment")
    public void addComment(@PathVariable Integer id,@RequestBody Comment comment){

        Optional<Post> post=postJpaRepo.findById(id);
        Post post1=null;
        if (post.isPresent()){
            post1=post.get();
            comment.setPost(post1);
            commentJpaRepo.save(comment);

        }else {
            throw new PostNotFoundException("not found");

        }

    }


    @GetMapping("/Comment/{id}/reply")
    public List<Reply> getReplyForComment(@PathVariable Integer id){
        Optional<Comment> comment=commentJpaRepo.findById(id);
        Comment comm=null;
        if (comment.isPresent()){
            comm=comment.get();
            return comm.getReply();


        }else {
            throw new PostNotFoundException("not found");

        }


    }
    @PostMapping("/Comment/{id}/reply")
    public void addReplyToComment(@PathVariable Integer id,@RequestBody Reply reply){

        Optional<Comment> r=commentJpaRepo.findById(id);
        Comment reply2=null;
        if (r.isPresent()){
            reply2=r.get();
            reply.setComment(reply2);
            cm2JpaRepo.save(reply);

        }else {
            throw new PostNotFoundException("not found");

        }

    }

}
