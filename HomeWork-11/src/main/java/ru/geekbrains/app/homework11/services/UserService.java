package ru.geekbrains.app.homework11.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.app.homework11.entities.Role;
import ru.geekbrains.app.homework11.entities.User;
import ru.geekbrains.app.homework11.repositories.UserRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public Optional<User> findUserByUserName(String username) {
        return userRepository.findUserByUsername(username);
    }

    public Optional<User> findUserByUserId(Long id) {
        return userRepository.findUserById(id);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUserByUserName(s).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь с ником '%s' не найден", s)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    public void decBall(User user) {
        user.setScore(user.getScore() - 1);
        userRepository.save(user);
    }

    public void incBall(User user) {
        user.setScore(user.getScore() + 1);
        userRepository.save(user);
    }
}
