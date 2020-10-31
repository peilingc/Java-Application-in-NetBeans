/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

/**
 *
 * @author harshalneelkamal
 */

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lab7.entities.*;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
        
        System.out.println("average of likes per comment: " + likeNumber / commentNumber);
            
    }
    
    //Find the post with most liked comments.
    public void  getPostWithMostLikedComments(){
        int max = 0;
        Post result = null;
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        for (Post p: posts.values()){
            for (Comment c : p.getComments()){
                if (c.getLikes() > max){
                    result = p;
                    max = c.getLikes();
                }
            }
        }
        
        System.out.println("the post with most liked comments: "+result.getPostId());
                
    }
    
    //Find the post with most comments.
    public void  getPostWithMostComments(){
        int max = 0;
        Post result = null;
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        for (Post p: posts.values()){
            if (p.getComments().size() > max){
                result = p;
                max = p.getComments().size();
            }
        }
        
        System.out.println("the post with most comments: "+result.getPostId());
        
    }
    
    //Top 5 inactive users based on total posts number.
    public void  getTop5InactiveUsersByPosts(){
        
        //userID, # of posts
        Map<Integer, Integer> dict = new HashMap<>();
        
        // get all users
        Map<Integer, User> userList = DataStore.getInstance().getUsers();
        for (Integer uid : userList.keySet()){
            dict.put(uid,0);        //set count of posts = 0
        }
        
        //count posts
        Map<Integer, Post> postList = DataStore.getInstance().getPosts();
        for (Post p:postList.values() ){
            //userID, get object of dict then add 1
            dict.put(p.getUserId(), dict.get(p.getUserId())+1);
        }
        
        //transfer to arrayList to sort
        List<Map.Entry <Integer,Integer>> order = new ArrayList <Map.Entry<Integer, Integer>>(dict.entrySet());
        Collections.sort(order, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Entry<Integer, Integer> n1, Entry<Integer, Integer> n2) {
                return  n1.getValue().compareTo(n2.getValue());
            }  
        });
        
        /**
        //print to show datasets
        for (Integer uid : dict.keySet()){
            System.out.println("Posts------------------------------");
            System.out.println(uid +", "+ dict.get(uid));
        }
        **/
        
        //choose top 5
        order=order.subList(0, 5);
        System.out.println("Top 5 inactive users based on total posts number:");
        for(Map.Entry<Integer,Integer> entry:order){
            for(User user:userList.values()){
                if(user.getId()==entry.getKey()){
                    System.out.println(user);
                }         
            }
        }
    }

    
    //Top 5 inactive users based on total comments they created.
    public void  getTop5InactiveUsersByComments(){
        //userID, count
        Map<Integer, Integer> dict = new HashMap<>();
        
        Map<Integer, User> userList = DataStore.getInstance().getUsers();
        for (User user : userList.values()){
            dict.put(user.getId(), user.getComments().size());
        }
        
        List<Map.Entry <Integer,Integer>> order = new ArrayList <Map.Entry<Integer, Integer>>(dict.entrySet());
        Collections.sort(order, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Entry<Integer, Integer> n1, Entry<Integer, Integer> n2) {
                return  n1.getValue().compareTo(n2.getValue());
            }  
        });
        
        /**
        //print to show datasets
        for (Integer uid : dict.keySet()){
            System.out.println("Comments------------------------------");
            System.out.println(uid +", "+ dict.get(uid));
        }
        **/
        
        order=order.subList(0, 5);
        System.out.println("Top 5 inactive users based on total comments:");
        for(Map.Entry<Integer,Integer> entry:order){
            for(User user:userList.values()){
                if(user.getId()==entry.getKey()){
                    System.out.println(user);
                }         
            }
        }
    }
    
    //Top 5 inactive users overall (sum of comments, posts and likes)
    public void  getTop5InactiveUsersByOverall(){
        //userID, count
        Map<Integer, Integer> dict = new HashMap<>();
        Map<Integer, User> userList = DataStore.getInstance().getUsers();
        for (Integer uid : userList.keySet()){
            dict.put(uid,0);        
        }
        
        //comments
        for (User user : userList.values()){
            dict.put(user.getId(), user.getComments().size());
        }
        
        //likes
        Map<Integer, Comment> commentList = DataStore.getInstance().getComments();
        for (Comment comment : commentList.values()){
            dict.put(comment.getUserId(), dict.get(comment.getUserId())+comment.getLikes());
        }
        
        //posts
        Map<Integer, Post> postList = DataStore.getInstance().getPosts();
        for (Post p:postList.values() ){
            dict.put(p.getUserId(), dict.get(p.getUserId())+1);
        }
        
        //transfer to arrayList to sort
        List<Map.Entry <Integer,Integer>> order = new ArrayList <Map.Entry<Integer, Integer>>(dict.entrySet());
        Collections.sort(order, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Entry<Integer, Integer> n1, Entry<Integer, Integer> n2) {
                return  n1.getValue().compareTo(n2.getValue());
            }  
        });
        
        /**
        //print likes
        Map<Integer, Integer> demo = new HashMap<>();
        for (Comment comment : commentList.values()){
            demo.put(comment.getUserId(), demo.getOrDefault(comment.getUserId(), 0)+comment.getLikes());
        }
        for (Integer userID : demo.keySet()){
            System.out.println("Likes------------------------------");
            System.out.println(userID + ", " + demo.get(userID));
        }
        
        //print to show datasets
        for (Integer uid : dict.keySet()){
            System.out.println("Totals------------------------------");
            System.out.println(uid +", "+ dict.get(uid));
        }
        **/
        
        //choose top 5
        order=order.subList(0, 5);
        System.out.println("Top 5 inactive users based overall:");
        for(Map.Entry<Integer,Integer> entry:order){
            for(User user:userList.values()){
                if(user.getId()==entry.getKey()){
                    System.out.println(user);
                }         
            }
        }
        
    }
    
    //Top 5 proactive users overall (sum of comments, posts and likes)
    public void  getTop5ProactiveUsersByOverall(){
        //userID, count
        Map<Integer, Integer> dict = new HashMap<>();
        Map<Integer, User> userList = DataStore.getInstance().getUsers();
        for (Integer uid : userList.keySet()){
            dict.put(uid,0);        
        }
        
        //comments
        for (User user : userList.values()){
            dict.put(user.getId(), user.getComments().size());
        }
        
        //likes
        Map<Integer, Comment> commentList = DataStore.getInstance().getComments();
        for (Comment comment : commentList.values()){
            dict.put(comment.getUserId(), dict.get(comment.getUserId())+comment.getLikes());
        }
        
        //posts
        Map<Integer, Post> postList = DataStore.getInstance().getPosts();
        for (Post p:postList.values() ){
            dict.put(p.getUserId(), dict.get(p.getUserId())+1);
        }
        
        //transfer to arrayList to sort
        List<Map.Entry <Integer,Integer>> order = new ArrayList <Map.Entry<Integer, Integer>>(dict.entrySet());
        Collections.sort(order, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Entry<Integer, Integer> n1, Entry<Integer, Integer> n2) {
                return  n1.getValue().compareTo(n2.getValue());
            }  
        });
        
        /**
        //print likes
        Map<Integer, Integer> demo = new HashMap<>();
        for (Comment comment : commentList.values()){
            demo.put(comment.getUserId(), demo.getOrDefault(comment.getUserId(), 0)+comment.getLikes());
        }
        for (Integer userID : demo.keySet()){
            System.out.println("Likes------------------------------");
            System.out.println(userID + ", " + demo.get(userID));
        }
        
        //print to show datasets
        for (Integer uid : dict.keySet()){
            System.out.println("Totals------------------------------");
            System.out.println(uid +", "+ dict.get(uid));
        }
        **/
        
        //choose top 5
        order=order.subList(order.size()-5, order.size());
        System.out.println("Top 5 inactive users based overall:");
        for(Map.Entry<Integer,Integer> entry:order){
            for(User user:userList.values()){
                if(user.getId()==entry.getKey()){
                    System.out.println(user);
                }         
            }
        }
    }
    
}
