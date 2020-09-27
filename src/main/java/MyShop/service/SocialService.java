package MyShop.service;

import MyShop.model.SocialAccount;

public interface SocialService {
    String getAuthorizeUrl();

    SocialAccount getSocialAccount(String authToken);
}
