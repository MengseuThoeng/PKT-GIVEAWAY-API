package org.pktstore.cambodia;

import java.util.List;

public interface UserService {
    void createUser(UserCreateRequest request);

    List<User> getAllUser();

    String getTotalUserJoinGiveaway();

    List<User> getUsersByUsernamePrefix(String prefix);
}
