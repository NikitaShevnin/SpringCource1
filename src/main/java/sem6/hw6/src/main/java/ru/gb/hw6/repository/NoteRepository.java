package ru.gb.hw6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.hw6.model.Note;

import java.util.Optional;

/**
 * TODO Репозиторий NoteRepository, который наследуется от JpaRepository
 *      для доступа к данным.
 *      Добавлен метод Optional<Note> findById(Long id);
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
