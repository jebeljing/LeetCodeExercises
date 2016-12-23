package package300;

import java.util.*;

/**
 * Created by Jebeljing on 12/22/2016.
 * 355. Design Twitter
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

 postTweet(userId, tweetId): Compose a new tweet.
 getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 follow(followerId, followeeId): Follower follows a followee.
 unfollow(followerId, followeeId): Follower unfollows a followee.

 Example:

 Twitter twitter = new Twitter();

 // User 1 posts a new tweet (id = 5).
 twitter.postTweet(1, 5);

 // User 1's news feed should return a list with 1 tweet id -> [5].
 twitter.getNewsFeed(1);

 // User 1 follows user 2.
 twitter.follow(1, 2);

 // User 2 posts a new tweet (id = 6).
 twitter.postTweet(2, 6);

 // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 twitter.getNewsFeed(1);

 // User 1 unfollows user 2.
 twitter.unfollow(1, 2);

 // User 1's news feed should return a list with 1 tweet id -> [5],
 // since user 1 is no longer following user 2.
 twitter.getNewsFeed(1);

 */
public class DesignTwitter {

    public static void main(String... args) {

         Twitter obj = new Twitter();
         obj.postTweet(2,5);
         List<Integer> param_2 = obj.getNewsFeed(1);
         obj.follow(1,2);
//         obj.postTweet(2,6);
         List<Integer> param = obj.getNewsFeed(2);
         obj.unfollow(2,1);
         List<Integer> param3 = obj.getNewsFeed(2);
    }
}

class Twitter {

    public static int count = 0;

    class Post {
        int tweetId;
        int time;


        public Post(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    Map<Integer, List<Post>> userPosts = new HashMap<>();
    Map<Integer, List<Integer>> followMap = new HashMap<>();


    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (userPosts.containsKey(userId)) {
            userPosts.get(userId).add(new Post(tweetId, count++));
        } else {
            List<Post> newTweets = new ArrayList<>();
            newTweets.add(new Post(tweetId, count++));
            userPosts.put(userId, newTweets);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Post> result = new ArrayList<>();
        if (userPosts.containsKey(userId)) {
            List<Post> posts = userPosts.get(userId);
            for (int i = posts.size() - 1; i >= 0; i--) {
                result.add(posts.get(i));
            }
        }

        if (followMap.containsKey(userId)) {
            List<Integer> followees = followMap.get(userId);
            for (Integer i: followees) {
                if (userPosts.containsKey(i) && i != userId) {
                    List<Post> tmpPosts = userPosts.get(i);
                    for (int idx = 0; idx < tmpPosts.size(); idx++) {
                        result.add(tmpPosts.get(idx));
                    }
                }
            }
        }

        Collections.sort(result, new Comparator<Post>() {
            @Override
            public int compare(Post p1, Post p2) {
                return p2.time - p1.time;
            }
        });

        List<Integer> finalResult = new ArrayList<>();
        for (int tmpCnt = 0; tmpCnt < result.size() && tmpCnt < 10; tmpCnt++) {
            finalResult.add(result.get(tmpCnt).tweetId);
        }
        return finalResult;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            if (!followMap.get(followerId).contains(followeeId))
                followMap.get(followerId).add(followeeId);
        } else {
            List<Integer> newFollowees = new ArrayList<>();
            newFollowees.add(followeeId);
            followMap.put(followerId, newFollowees);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(new Integer(followeeId));
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */