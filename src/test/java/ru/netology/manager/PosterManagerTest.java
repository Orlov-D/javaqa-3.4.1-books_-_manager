package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)

class PosterManagerTest {
    @Mock
    private PosterRepository repository;
    @InjectMocks
    private PosterManager manager;
    private Movie first = new Movie(1, "first", "ved1", "detective");
    private Movie second = new Movie(2, "second", "ruby2", "horror");
    private Movie tri = new Movie(3, "third", "ved3", "drama");

//    @Test
//    void deleteById() {
//        doNothing().when(repository).removeById(2);
//
//        Movie[] returned = new Movie[]{first, second, tri};
//        doReturn(returned).when(repository).removeById(2);
//        manager.removeById(2);
//
//        verify(repository).removeById(2);
//    }
//
//    @Test
//    void add() {
//        doNothing().when(repository).save(first);
//        manager.add(first);
//
//        verify(repository).save(first);
//    }
//    тут вроде логики нет и покрывать тестами не надо...

    @Test
    void getAll() {
        Movie[] returned = new Movie[]{first, second, tri};
        Movie[] expected = new Movie[]{tri, second, first};
        doReturn(returned).when(repository).findAll();

        assertArrayEquals(expected, manager.getAll());

        verify(repository).findAll();
    }

}