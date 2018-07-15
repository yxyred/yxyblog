/**
 * 
 */
package com.waylau.spring.boot.blog.initializrstart.repository;

import com.waylau.spring.boot.blog.initializrstart.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



/**
 * 用户仓库.
 *
 * @since 1.0.0 2017年3月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface UserRepository extends JpaRepository<User , Long> {

    Page<User> findByNameLike(String name, Pageable pageable);

    User findByUsername(String username);
}
