    package com.nnd.lesson09.repository;

    import com.nnd.lesson09.entity.Student;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface StudentRepository extends JpaRepository<Student, Long> {
    }
