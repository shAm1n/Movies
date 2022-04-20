package project.movies.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import project.movies.domain.User;
import project.movies.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository users;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.users = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	User curUser = users.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curUser.getPasswordHash(), 
        AuthorityUtils.createAuthorityList(curUser.getRole()));
        return user;
    }   
}