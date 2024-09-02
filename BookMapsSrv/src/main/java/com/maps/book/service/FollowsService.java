package com.maps.book.service;
import com.maps.book.model.Follows;

import java.util.List;

public interface FollowsService {
    Follows saveFollows(Follows follows);
    List<Follows> getAllFollows();
    Follows getFollowsById(long id);
    Follows updateFollows(Follows follows,long id);
    void deleteFollows(long id);
}
