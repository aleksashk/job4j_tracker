package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> optional = Optional.empty();
        for (Student s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                optional = Optional.of(s);
                break;
            }
        }
        return optional;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> optionalSubject = Optional.empty();
        Optional<Student> optional = findByAccount(account);
        if (optional.isPresent()) {
            Student s = optional.get();
            Set<Subject> subjects = students.get(s);
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    optionalSubject = Optional.of(subj);
                    break;
                }
            }
        }
        return optionalSubject;
    }
}
