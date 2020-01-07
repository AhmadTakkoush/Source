package com.ahmadtakkoush.source;


import com.google.firebase.firestore.Exclude;

public class BlogPostId {

    @Exclude
    public String BlogPostId;

    @SuppressWarnings("unchecked")
    public <T extends BlogPostId> T withId( final String id){
        this.BlogPostId = id;
        return (T) this;
    }
}
