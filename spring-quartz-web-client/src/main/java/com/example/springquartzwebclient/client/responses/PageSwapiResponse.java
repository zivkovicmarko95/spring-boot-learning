package com.example.springquartzwebclient.client.responses;

import java.util.List;
import java.util.Objects;

public class PageSwapiResponse<T> {
    
    private final Integer count;
    private final String next;
    private final String previous;
    private final List<T> results;

    public PageSwapiResponse(final Integer count, final String next, final String previous, final List<T> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Integer getCount() {
        return this.count;
    }


    public String getNext() {
        return this.next;
    }


    public String getPrevious() {
        return this.previous;
    }


    public List<T> getResults() {
        return this.results;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PageSwapiResponse)) {
            return false;
        }
        PageSwapiResponse pageSwapiResponse = (PageSwapiResponse) o;
        return Objects.equals(count, pageSwapiResponse.count) && Objects.equals(next, pageSwapiResponse.next) && Objects.equals(previous, pageSwapiResponse.previous) && Objects.equals(results, pageSwapiResponse.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, next, previous, results);
    }

    @Override
    public String toString() {
        return "{" +
            " count='" + getCount() + "'" +
            ", next='" + getNext() + "'" +
            ", previous='" + getPrevious() + "'" +
            ", results='" + getResults() + "'" +
            "}";
    }
    

}
