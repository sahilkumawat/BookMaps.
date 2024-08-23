package com.exampleCrud.exampleDemo01.service;
import com.exampleCrud.exampleDemo01.model.Follows;

import java.util.List;

public interface FollowsService {
    Follows saveFollows(Follows follows);
    List<Follows> getAllFollows();
    Follows getFollowsById(long id);
    Follows updateFollows(Follows follows,long id);
    void deleteFollows(long id);
}
