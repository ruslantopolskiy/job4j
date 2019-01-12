package ru.job4j.stream;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {

    private String name;
    private Integer score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().
                flatMap(Stream::ofNullable).
                sorted().
                takeWhile(student -> student.getScore() > bound).
                collect(Collectors.toList());
    }

    @Override
    public int compareTo(Student o) {
        return o.score.compareTo(this.score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(score, student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

