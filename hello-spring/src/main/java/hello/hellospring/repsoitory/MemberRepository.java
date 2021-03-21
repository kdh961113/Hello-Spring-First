package hello.hellospring.repsoitory;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByid(Long id);
    Optional<Member> findByname(String name);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    Optional<Member> findByName(String name);
}
